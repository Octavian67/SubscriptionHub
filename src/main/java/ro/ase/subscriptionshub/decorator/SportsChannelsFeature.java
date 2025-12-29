package ro.ase.subscriptionshub.decorator;

import ro.ase.subscriptionshub.data.models.ContentPackage;
import ro.ase.subscriptionshub.data.models.Subscription;

import java.util.HashSet;
import java.util.Set;

public class SportsChannelsFeature extends SubscriptionDecorator {
    public SportsChannelsFeature(Subscription base) {
        super(base);
    }

    @Override
    public Set<ContentPackage> getContentPackages() {
        Set<ContentPackage> packages = new HashSet<>(base.getContentPackages());
        packages.add(ContentPackage.SPORTS);
        return packages;
    }

    @Override
    public String getDescription() {
        return base.getDescription() + " + sports channels";
    }

    @Override
    public double getMonthlyCost() {
        return base.getMonthlyCost() + 4.99;
    }
}
