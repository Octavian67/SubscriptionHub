package ro.ase.subscriptionshub.models;

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
        return "Ultra HD (4K) streaming on up to 4 devices";
    }

    @Override
    public double getMonthlyCost() {
        return 15.99;
    }

    @Override
    public int getMaxDevices() {
        return 4;
    }

    @Override
    public boolean supportsUltraHD() {
        return true;
    }
}
