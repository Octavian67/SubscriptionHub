package ro.ase.subscriptionshub.strategy;

public class YearlyPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double monthlyBasePrice) {
        return monthlyBasePrice * 12 * 0.80;
    }
}
