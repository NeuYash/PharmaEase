package edu.neu.csye7374.Factory;

import edu.neu.csye7374.Builder.BuilderAPI;
import edu.neu.csye7374.Builder.MedicineBuilder;
import edu.neu.csye7374.Medicine;

public class MedicineFactory extends AbstractFactory {
    private static MedicineFactory instance;
    private  MedicineFactory() {
        super();
        instance=null;
    }
    public static synchronized MedicineFactory getInstance() {
        if (instance == null) {
            instance = new MedicineFactory();
        }
        return instance;
    }
    @Override
    public Medicine getObject(BuilderAPI buildObject) {
        MedicineBuilder medicineBuilder=(MedicineBuilder)buildObject;
        return new Medicine(medicineBuilder);
    }
}
