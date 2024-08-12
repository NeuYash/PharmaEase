package edu.neu.csye7374.Command;

import edu.neu.csye7374.Medicine;

public class SubscribeMedicineCommand implements CommandAPI {
    private static SubscribeMedicineCommand instance;
    private Medicine medicine;

    public SubscribeMedicineCommand() {
        super();
    }
    public static synchronized SubscribeMedicineCommand getInstance(){
        if(instance==null){
            instance= new SubscribeMedicineCommand();
        }
        return instance;
    }

    @Override
    public String execute() {
        return medicine.subscribeMedicine();
    }
    public Medicine getMedicine(){
        return medicine;
    }
    public SubscribeMedicineCommand setMedicine(Medicine medicine){
        this.medicine=medicine;
        return this;
    }
}
