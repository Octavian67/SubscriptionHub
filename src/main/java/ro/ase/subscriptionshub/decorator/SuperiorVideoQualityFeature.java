package ro.ase.subscriptionshub.decorator;

import ro.ase.subscriptionshub.models.Subscription;
import ro.ase.subscriptionshub.models.VideoQuality;

public class SuperiorVideoQualityFeature extends SubscriptionDecorator{
    public SuperiorVideoQualityFeature(Subscription base) {
        super(base);
    }

    @Override
    public VideoQuality getVideoQuality() {
        return switch (base.getVideoQuality()) {
            case HD -> VideoQuality.FULL_HD;
            case FULL_HD -> VideoQuality.ULTRA_HD;
            case ULTRA_HD -> VideoQuality.ULTRA_HD;
        };
    }

    @Override
    public String getDescription() {
        return base.getDescription() + " + superior video quality";
    }

    @Override
    public double getMonthlyCost() {
        return base.getMonthlyCost() + 3.99;
    }
}
