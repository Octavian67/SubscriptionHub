package ro.ase.subscriptionshub.models;

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
        return "Full HD streaming on up to 2 devices";
    }

    @Override
    public double getMonthlyCost() {
        return 11.99;
    }

    @Override
    public int getMaxDevices() {
        return 2;
    }

    @Override
    public boolean supportsUltraHD() {
        return false;
    }
}
