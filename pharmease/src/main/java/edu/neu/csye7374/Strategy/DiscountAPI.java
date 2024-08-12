package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.Medicine;

@FunctionalInterface
public interface DiscountAPI {
    public double calculatePrice(Medicine medicine);
}
