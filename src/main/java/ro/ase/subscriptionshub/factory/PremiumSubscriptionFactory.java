package ro.ase.subscriptionshub.factory;

import ro.ase.subscriptionshub.models.PremiumSubscription;
import ro.ase.subscriptionshub.models.Subscription;

public class PremiumSubscriptionFactory implements SubscriptionFactory {
    @Override
    public Subscription createSubscription() {
        return new PremiumSubscription();
    }
}
