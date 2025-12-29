package ro.ase.subscriptionshub.factory;

import ro.ase.subscriptionshub.data.models.BasicSubscription;
import ro.ase.subscriptionshub.data.models.Subscription;

public class BasicSubscriptionFactory implements SubscriptionFactory {
    @Override
    public Subscription createSubscription() {
        return new BasicSubscription();
    }
}
