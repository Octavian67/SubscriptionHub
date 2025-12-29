package ro.ase.subscriptionshub.models;

import java.util.Set;

public interface Subscription {
    SubscriptionType getType();

    String getName();

    String getDescription();

    double getMonthlyCost();

    int getMaxUsers();

    VideoQuality getVideoQuality();

    boolean canDownloadOffline();

    Set<ContentPackage> getContentPackages();
}
