package ro.ase.subscriptionshub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.ase.subscriptionshub.factory.SubscriptionFactory;
import ro.ase.subscriptionshub.factory.SubscriptionFactoryProvider;
import ro.ase.subscriptionshub.models.PremiumSubscription;
import ro.ase.subscriptionshub.models.Subscription;
import ro.ase.subscriptionshub.models.SubscriptionType;

@SpringBootApplication
public class SubscriptionsHub {
    public static void main(String[] args) {
        SpringApplication.run(SubscriptionsHub.class, args);
        SubscriptionFactory factory =
                SubscriptionFactoryProvider.getFactory(SubscriptionType.PREMIUM);

        Subscription subscription = factory.createSubscription();

        System.out.println(subscription.getName());
        System.out.println(subscription.getMonthlyCost());
    }
}
