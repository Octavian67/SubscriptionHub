package ro.ase.subscriptionshub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.ase.subscriptionshub.decorator.*;
import ro.ase.subscriptionshub.models.*;
import ro.ase.subscriptionshub.service.SubscriptionService;
import ro.ase.subscriptionshub.service.SubscriptionServiceImpl;

import java.util.Set;

@SpringBootApplication
public class SubscriptionsHub {
    public static void main(String[] args) {
        SpringApplication.run(SubscriptionsHub.class, args);

        SubscriptionHandoff handoff = new SubscriptionHandoff();
        handoff.setType(SubscriptionType.STANDARD);
        handoff.setFeatures(Set.of(
                FeatureType.SUPERIOR_VIDEO_QUALITY,
                FeatureType.MULTIPLE_USERS
        ));
        handoff.setStudent(true);
        handoff.setPeriod(SubscriptionPeriod.YEARLY);

        SubscriptionService service = new SubscriptionServiceImpl();

        SubscriptionResult result = service.createSubscription(handoff);

        System.out.println(result.getSubscription().getDescription());
        System.out.println("Final price: " + result.getFinalPrice());

        Subscription s = new PremiumSubscription();
        s = new SportsChannelsFeature(s);
        s = new KidsChannelsFeature(s);

        s.getContentPackages(); // [SPORTS, KIDS]

    }
}
