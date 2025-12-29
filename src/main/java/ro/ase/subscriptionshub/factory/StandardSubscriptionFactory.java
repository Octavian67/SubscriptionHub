package ro.ase.subscriptionshub.factory;

import ro.ase.subscriptionshub.models.StandardSubscription;
import ro.ase.subscriptionshub.models.Subscription;

public class StandardSubscriptionFactory implements SubscriptionFactory {
    @Override
    public Subscription createSubscription() {
        return new StandardSubscription();
    }
}
