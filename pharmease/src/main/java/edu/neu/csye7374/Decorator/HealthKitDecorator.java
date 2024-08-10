package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.Medicine;
import edu.neu.csye7374.MedicineAPI;

public class HealthKitDecorator extends MedicineDecorator {
    public HealthKitDecorator(MedicineAPI decoratorMedicine) {
        super(decoratorMedicine);
    }

    @Override
    public String medicineDescription() {
        return super.medicineDescription() + " + Free HealthKit Subscription for a month";
    }

    @Override
    public int noOfMedicinesManufactured() {
        return super.noOfMedicinesManufactured();
    }

    @Override
    public String medicineManufacturer() {
        // TODO Auto-generated method stub
        return decoratorMedicine.medicineManufacturer();
    }

    @Override
    public MedicineAPI getDecoratorMedicine() {
        return super.getDecoratorMedicine();
    }

    public double medicinePrice() {
        Medicine b = Medicine.class.cast(decoratorMedicine);
        return b.getMedicinePrice()+10;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
