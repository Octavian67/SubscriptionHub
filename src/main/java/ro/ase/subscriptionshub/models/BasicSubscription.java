package ro.ase.subscriptionshub.models;

import java.util.Collections;
import java.util.Set;

public class BasicSubscription implements Subscription{
    @Override
    public SubscriptionType getType() {
        return SubscriptionType.BASIC;
    }

    @Override
    public String getName() {
        return "Basic";
    }

    @Override
    public String getDescription() {
        return "HD streaming on 1 user";
    }

    @Override
    public double getMonthlyCost() {
        return 7.99;
    }

    @Override
    public int getMaxUsers() {
        return 1;
    }

    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.HD;
    }

    @Override
    public boolean canDownloadOffline() {
        return false;
    }

    @Override
    public Set<ContentPackage> getContentPackages() {
        return Collections.emptySet();
    }
}
