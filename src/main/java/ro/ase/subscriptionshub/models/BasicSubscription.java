package ro.ase.subscriptionshub.models;

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
        return "HD streaming on 1 device";
    }

    @Override
    public double getMonthlyCost() {
        return 7.99;
    }

    @Override
    public int getMaxDevices() {
        return 1;
    }

    @Override
    public boolean supportsUltraHD() {
        return false;
    }
}
