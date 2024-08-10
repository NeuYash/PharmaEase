package edu.neu.csye7374;

import edu.neu.csye7374.Bridge.MedicalService;
import edu.neu.csye7374.Builder.PharmacistBuilder;

public class Pharmacist extends Person {
    private double salary;
    public Pharmacist(PharmacistBuilder pharmacistBuilder) {
            super(pharmacistBuilder.getId(), pharmacistBuilder.getAge(),
                    pharmacistBuilder.getFirstName(), pharmacistBuilder.getLastName());
            this.salary = pharmacistBuilder.getSalary();
    }
    private MedicalService medicalService;

    public Pharmacist(MedicalService medicalService) {
        this.medicalService = medicalService;
    }

    public void dispense(Medicine medicine) {
        System.out.println("Dispensing medicine " + medicine.getMedicineName() + " manufactured by " + medicine.getMedicineManufacturer());
    }

    public Pharmacist() {

    }

    public double getSalary() {
            return salary;
    }
    public void setSalary(double salary) {
            this.salary = salary;
    }
    public Pharmacist(int id, int age, String firstName, String lastName, double salary) {
            super(id, age, firstName, lastName);
            this.salary = salary;
    }
    @Override
    public String toString() {
            return "\nPharmacist ["+ super.toString() +", salary= "+ salary +"]";
    }
    public String getFirstName() {
            return super.getFirstName();
    }
    public String getLastName() {
            return super.getLastName();
    }
}
