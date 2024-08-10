package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.MedicineAPI;

public abstract class MedicineDecorator implements MedicineAPI {

    protected MedicineAPI decoratorMedicine;

    public MedicineDecorator(MedicineAPI decoratorMedicine) {
        this.decoratorMedicine = decoratorMedicine;
    }

    @Override
    public String medicineDescription() {
        return decoratorMedicine.medicineDescription();
    }

    @Override
    public int noOfMedicinesManufactured() {
        return decoratorMedicine.noOfMedicinesManufactured();
    }

    public MedicineAPI getDecoratorMedicine() {
        return this.decoratorMedicine;
    }

    @Override
    public String toString() {
        return "MedicineDecorator{" +
                "decoratorMedicine=" + decoratorMedicine +
                '}';
    }
}
