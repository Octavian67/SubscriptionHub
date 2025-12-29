package ro.ase.subscriptionshub.data.models;

import java.util.Collections;
import java.util.Set;

public class PremiumSubscription implements Subscription{
    @Override
    public SubscriptionType getType() {
        return SubscriptionType.PREMIUM;
    }

    @Override
    public String getName() {
        return "Premium";
    }

    @Override
    public String getDescription() {
        return "Ultra HD streaming on up to 4 users";
    }

    @Override
    public double getMonthlyCost() {
        return 15.99;
    }

    @Override
    public int getMaxUsers() {
        return 4;
    }

    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.ULTRA_HD;
    }

    @Override
    public boolean canDownloadOffline() {
        return true;
    }

    @Override
    public Set<ContentPackage> getContentPackages() {
        return Collections.emptySet();
    }
}
