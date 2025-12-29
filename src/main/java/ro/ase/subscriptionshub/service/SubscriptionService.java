package ro.ase.subscriptionshub.service;

import ro.ase.subscriptionshub.data.models.SubscriptionHandoff;
import ro.ase.subscriptionshub.data.models.SubscriptionResult;
import ro.ase.subscriptionshub.data.models.SubscriptionViewModel;

public interface SubscriptionService {
    SubscriptionResult createSubscription(SubscriptionHandoff handoff);

    SubscriptionViewModel getSubscription();

}
