package ro.ase.subscriptionshub.models;

import java.util.Collections;
import java.util.Set;

public class StandardSubscription implements Subscription{
    @Override
    public SubscriptionType getType() {
        return SubscriptionType.STANDARD;
    }

    @Override
    public String getName() {
        return "Standard";
    }

    @Override
    public String getDescription() {
        return "Full HD streaming on up to 2 users";
    }

    @Override
    public double getMonthlyCost() {
        return 11.99;
    }

    @Override
    public int getMaxUsers() {
        return 2;
    }

    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.FULL_HD;
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
