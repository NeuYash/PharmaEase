package edu.neu.csye7374.Command;

import edu.neu.csye7374.Medicine;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<Medicine> orderlist= new ArrayList<>();
    public void takeOrder(Medicine medicine){
        orderlist.add(medicine);
    }
    public void placeOrder(){
        BuyMedicineCommand buyMedicineCommand = BuyMedicineCommand.getInstance();
        for(Medicine medicine : orderlist){
            System.out.println(buyMedicineCommand.setMedicine(medicine).execute());
        }
        //order placed, now clear list
        //need to add something that gives option to subscribe to order
        // - before order can be cleared.
        orderlist.clear();
    }
    public void placeOrder(List<Medicine> medicinelist){
        for(Medicine medicine: medicinelist){
            orderlist.add(medicine);
        }
        placeOrder();
    }
    public void subscribeOrder(){
        SubscribeMedicineCommand subscribeMedicineCommand= SubscribeMedicineCommand.getInstance();
        for(Medicine medicine : orderlist){
            System.out.println(subscribeMedicineCommand.setMedicine(medicine).execute());
        }
    }
    public void subscribeOrder(List<Medicine> medicinelist){
        for(Medicine medicine: medicinelist){
            orderlist.add(medicine);
        }
        subscribeOrder();
    }
    public List<Medicine> getOrderlist(){
        return orderlist;
    }

    public void setOrderlist(List<Medicine> orderlist) {
        this.orderlist = orderlist;
    }
}
