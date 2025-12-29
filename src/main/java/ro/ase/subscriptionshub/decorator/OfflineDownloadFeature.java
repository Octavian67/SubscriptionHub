package ro.ase.subscriptionshub.decorator;

import ro.ase.subscriptionshub.models.Subscription;

public class OfflineDownloadFeature extends SubscriptionDecorator{
    public OfflineDownloadFeature(Subscription base) {
        super(base);
    }

    @Override
    public boolean canDownloadOffline() {
        return true;
    }

    @Override
    public String getDescription() {
        return base.getDescription() + " + offline downloads";
    }

    @Override
    public double getMonthlyCost() {
        return base.getMonthlyCost() + 1.99;
    }
}
