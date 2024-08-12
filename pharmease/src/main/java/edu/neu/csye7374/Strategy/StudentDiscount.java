package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.Medicine;

//20% discount
public class StudentDiscount implements DiscountAPI {
    double percentage=0.20;
    @Override
    public double calculatePrice(Medicine medicine) {
        return medicine.getMedicinePrice() * (1-percentage);
    }
}
