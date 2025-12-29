package ro.ase.subscriptionshub.decorator;

import ro.ase.subscriptionshub.models.Subscription;

public class MultipleUsersFeature extends SubscriptionDecorator{
    public MultipleUsersFeature(Subscription base) {
        super(base);
    }

    @Override
    public int getMaxUsers() {
        return base.getMaxUsers() + 1;
    }

    @Override
    public String getDescription() {
        return base.getDescription() + " + extra user";
    }

    @Override
    public double getMonthlyCost() {
        return base.getMonthlyCost() + 2.49;
    }
}
