package ro.ase.subscriptionshub.service;

import ro.ase.subscriptionshub.models.SubscriptionHandoff;
import ro.ase.subscriptionshub.models.SubscriptionResult;

public interface SubscriptionService {
    SubscriptionResult createSubscription(SubscriptionHandoff handoff);

}
