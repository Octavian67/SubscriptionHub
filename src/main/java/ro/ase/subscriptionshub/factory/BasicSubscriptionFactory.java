package ro.ase.subscriptionshub.factory;

import ro.ase.subscriptionshub.models.BasicSubscription;
import ro.ase.subscriptionshub.models.Subscription;

public class BasicSubscriptionFactory implements SubscriptionFactory {
    @Override
    public Subscription createSubscription() {
        return new BasicSubscription();
    }
}
