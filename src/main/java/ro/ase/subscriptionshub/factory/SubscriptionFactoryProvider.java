package ro.ase.subscriptionshub.factory;

import ro.ase.subscriptionshub.data.models.SubscriptionType;

import java.util.EnumMap;
import java.util.Map;

public class SubscriptionFactoryProvider {
    private static final Map<SubscriptionType, SubscriptionFactory> FACTORIES =
            new EnumMap<>(SubscriptionType.class);

    static {
        FACTORIES.put(SubscriptionType.BASIC, new BasicSubscriptionFactory());
        FACTORIES.put(SubscriptionType.STANDARD, new StandardSubscriptionFactory());
        FACTORIES.put(SubscriptionType.PREMIUM, new PremiumSubscriptionFactory());
    }

    public static SubscriptionFactory getFactory(SubscriptionType type) {
        SubscriptionFactory factory = FACTORIES.get(type);
        if (factory == null) {
            throw new IllegalArgumentException("Unsupported subscription type: " + type);
        }
        return factory;
    }
}
