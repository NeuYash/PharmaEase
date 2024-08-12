package edu.neu.csye7374.Factory;

import edu.neu.csye7374.Builder.BuilderAPI;
import edu.neu.csye7374.Builder.PharmacistBuilder;
import edu.neu.csye7374.Pharmacist;

public class PharmacistFactory extends AbstractFactory {
    private static PharmacistFactory instance = new PharmacistFactory();
    private PharmacistFactory(){
        super();
    }
    public synchronized static PharmacistFactory getInstance(){
        return instance;
    }
    @Override
    public Pharmacist getObject(BuilderAPI buildObject) {
        PharmacistBuilder pharmacistBuilder = (PharmacistBuilder) buildObject;
        return new Pharmacist(pharmacistBuilder);
    }
}
