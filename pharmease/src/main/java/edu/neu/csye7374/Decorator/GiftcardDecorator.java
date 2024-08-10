package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.Medicine;
import edu.neu.csye7374.MedicineAPI;

public class GiftcardDecorator extends MedicineDecorator {

    public GiftcardDecorator(MedicineAPI decoratedMedicine) {
        super(decoratedMedicine);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String medicineDescription() {
        // TODO Auto-generated method stub
        return decoratorMedicine.medicineDescription()+ " + Free Gift Card of $10";
    }

    @Override
    public String medicineManufacturer() {
        // TODO Auto-generated method stub
        return decoratorMedicine.medicineManufacturer();
    }

    public double medicinePrice() {
        Medicine b = Medicine.class.cast(decoratorMedicine);
        return b.getMedicinePrice()+10;
    }
}
