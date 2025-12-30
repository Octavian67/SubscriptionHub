package ro.ase.subscriptionshub.observer.consumer;

import org.springframework.stereotype.Component;
import ro.ase.subscriptionshub.data.models.Subscription;

@Component
public class FakeEmailSubscriptionCreatedObserver
        implements SubscriptionCreatedObserver {

    @Override
    public void onSubscriptionCreated(Subscription subscription) {
        System.out.println(
                "[FAKE EMAIL] Subscription created: " +
                        subscription.getName() +
                        " | monthly price=" + subscription.getMonthlyCost()
        );
    }
}