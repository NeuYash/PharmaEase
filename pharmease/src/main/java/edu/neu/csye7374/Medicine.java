package edu.neu.csye7374;

import edu.neu.csye7374.Bridge.MedicalService;
import edu.neu.csye7374.Builder.MedicineBuilder;
import edu.neu.csye7374.Strategy.DiscountStrategy;

public class Medicine implements MedicineAPI {
    public int medicineId;
    public String medicineName;
    public double medicinePrice;
    public MedicineCategory medicineCategory;
    public String medicineManufacturer;

    private MedicalService medicalService;

    public Medicine(MedicalService medicalService) {
        this.medicalService = medicalService;
    }
    public Medicine() {
    }

    public int getMedicineId() {
        return medicineId;
    }
    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public double getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(double medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public String getMedicineManufacturer() {
        return medicineManufacturer;
    }

    public void setMedicineManufacturer(String medicineManufacturer) {
        this.medicineManufacturer = medicineManufacturer;
    }
    public MedicineCategory getMedicineCategory() {
        return medicineCategory;
    }
    public void setMedicineCategory(MedicineCategory medicineCategory) {
        this.medicineCategory = medicineCategory;
    }
    @Override
    public String medicineDescription() {
        return this.medicineName;
    }
    @Override
    public String medicineManufacturer() {
        return null;
    }
    @Override
    public int noOfMedicinesManufactured() {
        return 0;
    }
    @Override
    public double medicinePrice() {
        return getMedicinePrice();
    }
    //Command Pattern
    public String buyMedicine(){
        return this.medicineName+" has been purchased"; //+"\n Price now ="+this.medicinePrice;
    }
    //Command Pattern
    //5% discount on subscribing to a medicine
    public String subscribeMedicine(){
        this.medicinePrice= this.medicinePrice * 0.95;
        return this.medicineName+ " has been added to your subscription list and you will get 5% discount on it from now onwards.";//+"\n Price now ="+this.medicinePrice;
    }

    public Medicine(MedicineBuilder medicineBuilder){
        super();
        this.medicineId = medicineBuilder.medicineId;
        this.medicineName = medicineBuilder.medicineName;
        this.medicinePrice = medicineBuilder.medicinePrice;
        this.medicineManufacturer = medicineBuilder.medicineManufacturer;
        this.medicineCategory = medicineBuilder.medicineCategory;
    }
    public Medicine(int medicineId, String medicineName,
                    double medicinePrice, String medicineManufacturer, MedicineCategory medicineCategory) {
        super();
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.medicinePrice = medicinePrice;
        this.medicineManufacturer = medicineManufacturer;
        this.medicineCategory = medicineCategory;
    }

    public double runStrategy() {
        double value = 0;
        switch (Pharmacy.getStrategy()) {
            case EMPLOYEE_DISCOUNT -> {
                value = Pharmacy.getStrategyAPIMap().get(DiscountStrategy.EMPLOYEE_DISCOUNT).calculatePrice(this);
                break;
            }
            case STUDENT_DISCOUNT -> {
                value = Pharmacy.getStrategyAPIMap().get(DiscountStrategy.STUDENT_DISCOUNT).calculatePrice(this);
                break;
            }
            case MEMBERSHIP_DISCOUNT -> {
                value = Pharmacy.getStrategyAPIMap().get(DiscountStrategy.MEMBERSHIP_DISCOUNT).calculatePrice(this);
                break;
            }
            default -> {
                value = medicinePrice;
            }
        }
        return value;
    }
    @Override
    public String toString() {
        return "Medicine{" +
                "medicineName='" + medicineName + '\'' +
                ", medicinePrice=" + medicinePrice +
                '}';
    }

}
