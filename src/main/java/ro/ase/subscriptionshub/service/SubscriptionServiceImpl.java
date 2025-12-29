package ro.ase.subscriptionshub.service;

import org.springframework.stereotype.Service;
import ro.ase.subscriptionshub.decorator.*;
import ro.ase.subscriptionshub.factory.SubscriptionFactoryProvider;
import ro.ase.subscriptionshub.models.*;
import ro.ase.subscriptionshub.strategy.MonthlyPricingStrategy;
import ro.ase.subscriptionshub.strategy.PricingStrategy;
import ro.ase.subscriptionshub.strategy.StudentDiscountPricingStrategy;
import ro.ase.subscriptionshub.strategy.YearlyPricingStrategy;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResult createSubscription(SubscriptionHandoff handoff) {

        Subscription subscription = createBaseSubscription(handoff);

        validateExtraFeatures(subscription, handoff);

        subscription = applyExtraFeatures(subscription, handoff);

        PricingStrategy strategy = buildPricingStrategy(handoff);

        double finalPrice =
                strategy.calculatePrice(subscription.getMonthlyCost());


        return new SubscriptionResult(subscription, finalPrice);
    }

    private Subscription createBaseSubscription(SubscriptionHandoff request) {
        return SubscriptionFactoryProvider
                .getFactory(request.getType())
                .createSubscription();
    }

    private void validateExtraFeatures(
            Subscription subscription,
            SubscriptionHandoff handoff
    ) {
        for (FeatureType featureType : handoff.getFeatures()) {
            switch (featureType) {

                case SUPERIOR_VIDEO_QUALITY -> {
                    if (subscription.getVideoQuality() == VideoQuality.ULTRA_HD) {
                        throw new IllegalArgumentException(
                                "Superior video quality is already included."
                        );
                    }
                }

                case OFFLINE_DOWNLOADS -> {
                    if (subscription.canDownloadOffline()) {
                        throw new IllegalArgumentException(
                                "Offline downloads are already included."
                        );
                    }
                }

                case MULTIPLE_USERS -> {
                    if (subscription.getType() != SubscriptionType.STANDARD) {
                        throw new IllegalArgumentException(
                                "Multiple users are only available for Standard plan."
                        );
                    }
                }

                case SPORTS_CHANNELS, KIDS_CHANNELS -> {
                    if (subscription.getType() != SubscriptionType.PREMIUM) {
                        throw new IllegalArgumentException(
                                "This content package is only available for Premium plan."
                        );
                    }
                }
            }
        }
    }


    private Subscription applyExtraFeatures(
            Subscription subscription,
            SubscriptionHandoff handoff
    ) {
        for (FeatureType feature : handoff.getFeatures()) {
            subscription = switch (feature) {
                case SUPERIOR_VIDEO_QUALITY ->
                        new SuperiorVideoQualityFeature(subscription);
                case MULTIPLE_USERS ->
                        new MultipleUsersFeature(subscription);
                case OFFLINE_DOWNLOADS ->
                        new OfflineDownloadFeature(subscription);
                case SPORTS_CHANNELS ->
                        new SportsChannelsFeature(subscription);
                case KIDS_CHANNELS ->
                        new KidsChannelsFeature(subscription);
            };
        }
        return subscription;
    }


    private PricingStrategy createBasePricingStrategy(SubscriptionHandoff handoff) {

        if (handoff.getPeriod() == SubscriptionPeriod.YEARLY) {
            return new YearlyPricingStrategy();
        }
        return new MonthlyPricingStrategy();
    }

    private PricingStrategy buildPricingStrategy(SubscriptionHandoff handoff) {

        PricingStrategy strategy = createBasePricingStrategy(handoff);

        if (handoff.isStudent()) {
            strategy = new StudentDiscountPricingStrategy(strategy);
        }

        return strategy;
    }

}
