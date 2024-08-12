package edu.neu.csye7374.Adapter;

import edu.neu.csye7374.MedicineAPI;

public class ManufacturerObjectAdapter implements MedicineAPI {


    private Manufacturer manufacturer;
    private MedicineAPI medicine;

    public ManufacturerObjectAdapter(Manufacturer manufacturer, MedicineAPI medicine) {
        this.manufacturer = manufacturer;
        this.medicine = medicine;
    }

    @Override
    public String toString() {
        return "ManufacturerObjectAdapter{" +
                "manufacturer=" + manufacturer +
                ", medicine=" + medicine +
                '}';
    }

    @Override
    public String medicineDescription() {
        return medicine.medicineDescription();
    }

    @Override
    public String medicineManufacturer() {
        return manufacturer.getManufacturerName();
    }

    @Override
    public int noOfMedicinesManufactured() {
        return manufacturer.getProductsManufactured();
    }

    @Override
    public double medicinePrice() {
        return medicine.medicinePrice();
    }
}
