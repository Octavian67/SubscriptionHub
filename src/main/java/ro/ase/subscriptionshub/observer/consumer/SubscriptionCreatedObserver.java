package ro.ase.subscriptionshub.observer.consumer;

import ro.ase.subscriptionshub.data.models.Subscription;

public interface SubscriptionCreatedObserver {
    void onSubscriptionCreated(Subscription subscription);
}
