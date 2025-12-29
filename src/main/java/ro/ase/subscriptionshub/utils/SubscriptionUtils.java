package ro.ase.subscriptionshub.utils;

import org.springframework.stereotype.Component;
import ro.ase.subscriptionshub.data.models.FeatureType;
import ro.ase.subscriptionshub.data.models.SubscriptionType;

import java.util.Set;

@Component
public class SubscriptionUtils {
    public Set<FeatureType> getAvailableFeatures(SubscriptionType type) {
        return switch (type) {
            case BASIC -> Set.of(
                    FeatureType.SUPERIOR_VIDEO_QUALITY,
                    FeatureType.OFFLINE_DOWNLOADS
            );
            case STANDARD -> Set.of(
                    FeatureType.SUPERIOR_VIDEO_QUALITY,
                    FeatureType.MULTIPLE_USERS
            );
            case PREMIUM -> Set.of(
                    FeatureType.SPORTS_CHANNELS,
                    FeatureType.KIDS_CHANNELS
            );
        };
    }

    public Set<FeatureType> getIncludedFeatures(SubscriptionType type) {
        return switch (type) {
            case BASIC -> Set.of();
            case STANDARD -> Set.of(
                    FeatureType.OFFLINE_DOWNLOADS
            );
            case PREMIUM -> Set.of(
                    FeatureType.OFFLINE_DOWNLOADS,
                    FeatureType.MULTIPLE_USERS
            );
        };
    }


}
