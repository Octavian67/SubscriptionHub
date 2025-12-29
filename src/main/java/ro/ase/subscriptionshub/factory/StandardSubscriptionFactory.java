package ro.ase.subscriptionshub.factory;

import ro.ase.subscriptionshub.data.models.StandardSubscription;
import ro.ase.subscriptionshub.data.models.Subscription;

public class StandardSubscriptionFactory implements SubscriptionFactory {
    @Override
    public Subscription createSubscription() {
        return new StandardSubscription();
    }
}
