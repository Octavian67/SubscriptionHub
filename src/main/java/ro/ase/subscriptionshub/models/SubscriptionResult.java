package ro.ase.subscriptionshub.models;

import ro.ase.subscriptionshub.models.Subscription;

public class SubscriptionResult {
    private Subscription subscription;
    private double finalPrice;

    public SubscriptionResult(Subscription subscription, double finalPrice) {
        this.subscription = subscription;
        this.finalPrice = finalPrice;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public double getFinalPrice() {
        return finalPrice;
    }
}
