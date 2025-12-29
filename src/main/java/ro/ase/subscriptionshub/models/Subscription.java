package ro.ase.subscriptionshub.models;

public interface Subscription {
    SubscriptionType getType();

    String getName();

    String getDescription();

    double getMonthlyCost();

    int getMaxDevices();

    boolean supportsUltraHD();
}
