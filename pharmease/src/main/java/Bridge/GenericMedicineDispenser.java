package edu.neu.csye7374.Bridge;

import edu.neu.csye7374.Medicine;
import edu.neu.csye7374.Pharmacist;

public class GenericMedicineDispenser implements MedicalService {
    private Medicine medicine;
    private Pharmacist pharmacist;

    public GenericMedicineDispenser(Medicine medicine, Pharmacist pharmacist) {
        this.medicine = medicine;
        this.pharmacist = pharmacist;
    }

    public void dispenseMedicine() {
        System.out.println("Dispensing generic medicine " + medicine.getMedicineName());
        pharmacist.dispense(medicine);
    }
}
