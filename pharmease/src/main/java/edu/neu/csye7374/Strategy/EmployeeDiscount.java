package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.Medicine;

//15% discount
public class EmployeeDiscount implements DiscountAPI {
    double percentage=0.15;
    @Override
    public double calculatePrice(Medicine medicine) {
        return medicine.getMedicinePrice() * (1-percentage);
    }

}
