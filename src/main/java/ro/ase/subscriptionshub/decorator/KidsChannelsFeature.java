package ro.ase.subscriptionshub.decorator;

import ro.ase.subscriptionshub.models.ContentPackage;
import ro.ase.subscriptionshub.models.Subscription;

import java.util.HashSet;
import java.util.Set;

public class KidsChannelsFeature extends SubscriptionDecorator{
    public KidsChannelsFeature(Subscription base) {
        super(base);
    }

    @Override
    public Set<ContentPackage> getContentPackages() {
        Set<ContentPackage> packages = new HashSet<>(base.getContentPackages());
        packages.add(ContentPackage.KIDS);
        return packages;
    }

    @Override
    public String getDescription() {
        return base.getDescription() + " + kids channels";
    }

    @Override
    public double getMonthlyCost() {
        return base.getMonthlyCost() + 2.99;
    }
}
