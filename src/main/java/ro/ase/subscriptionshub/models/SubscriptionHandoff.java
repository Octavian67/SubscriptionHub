package ro.ase.subscriptionshub.models;

import java.util.Set;

public class SubscriptionHandoff {
    private SubscriptionType type;
    private Set<FeatureType> features;
    private boolean student;
    private SubscriptionPeriod period;

    public SubscriptionHandoff() {
    }

    public SubscriptionType getType() {
        return type;
    }

    public void setType(SubscriptionType type) {
        this.type = type;
    }

    public Set<FeatureType> getFeatures() {
        return features;
    }

    public void setFeatures(Set<FeatureType> features) {
        this.features = features;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public SubscriptionPeriod getPeriod() {
        return period;
    }

    public void setPeriod(SubscriptionPeriod period) {
        this.period = period;
    }
}
