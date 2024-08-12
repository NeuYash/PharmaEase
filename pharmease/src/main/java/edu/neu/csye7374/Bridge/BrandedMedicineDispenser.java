package edu.neu.csye7374.Bridge;

import edu.neu.csye7374.Medicine;
import edu.neu.csye7374.Pharmacist;

public class BrandedMedicineDispenser implements MedicalService {
    private Medicine medicine;
    private Pharmacist pharmacist;

    public BrandedMedicineDispenser(Medicine medicine, Pharmacist pharmacist) {
        this.medicine = medicine;
        this.pharmacist = pharmacist;
    }

    public void dispenseMedicine() {
        pharmacist.dispense(medicine);
    }
}
