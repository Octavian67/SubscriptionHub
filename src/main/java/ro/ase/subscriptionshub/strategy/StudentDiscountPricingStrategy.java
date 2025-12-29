package ro.ase.subscriptionshub.strategy;

public class StudentDiscountPricingStrategy implements PricingStrategy {
    private final PricingStrategy baseStrategy;

    public StudentDiscountPricingStrategy(PricingStrategy baseStrategy) {
        this.baseStrategy = baseStrategy;
    }

    @Override
    public double calculatePrice(double monthlyBasePrice) {
        double price = baseStrategy.calculatePrice(monthlyBasePrice);
        return price * 0.85;
    }
}
