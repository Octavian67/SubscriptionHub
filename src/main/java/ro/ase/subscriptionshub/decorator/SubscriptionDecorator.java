package ro.ase.subscriptionshub.decorator;

import ro.ase.subscriptionshub.models.ContentPackage;
import ro.ase.subscriptionshub.models.Subscription;
import ro.ase.subscriptionshub.models.SubscriptionType;
import ro.ase.subscriptionshub.models.VideoQuality;

import java.util.Set;

public abstract class SubscriptionDecorator implements Subscription {
    protected final Subscription base;

    public SubscriptionDecorator(Subscription base) {
        this.base = base;
    }

    @Override
    public SubscriptionType getType() {
        return base.getType();
    }

    @Override
    public String getName() {
        return base.getName();
    }

    @Override
    public String getDescription() {
        return base.getDescription();
    }

    @Override
    public double getMonthlyCost() {
        return base.getMonthlyCost();
    }

    @Override
    public int getMaxUsers() {
        return base.getMaxUsers();
    }

    @Override
    public VideoQuality getVideoQuality() {
        return base.getVideoQuality();
    }

    @Override
    public boolean canDownloadOffline() {
        return base.canDownloadOffline();
    }

    @Override
    public Set<ContentPackage> getContentPackages() {
        return base.getContentPackages();
    }
}
