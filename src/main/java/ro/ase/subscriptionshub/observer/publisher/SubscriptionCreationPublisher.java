package ro.ase.subscriptionshub.observer.publisher;

import org.springframework.stereotype.Component;
import ro.ase.subscriptionshub.data.models.Subscription;
import ro.ase.subscriptionshub.observer.consumer.SubscriptionCreatedObserver;

import java.util.List;

@Component
public class SubscriptionCreationPublisher {

    private final List<SubscriptionCreatedObserver> observers;

    public SubscriptionCreationPublisher(List<SubscriptionCreatedObserver> observers) {
        this.observers = observers;
    }

    public void notifyCreated(Subscription subscription) {
        observers.forEach(o -> o.onSubscriptionCreated(subscription));
    }
}