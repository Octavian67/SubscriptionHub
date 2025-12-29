package ro.ase.subscriptionshub.strategy;

public class MonthlyPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double monthlyBasePrice) {
        return monthlyBasePrice;
    }
}
