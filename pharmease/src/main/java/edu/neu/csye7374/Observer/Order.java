package edu.neu.csye7374.Observer;

import edu.neu.csye7374.Facade.DeliveryType;
import edu.neu.csye7374.MedicineAPI;
import edu.neu.csye7374.State.*;

import java.util.ArrayList;
import java.util.List;

public class Order implements OrderStateAPI {
    private int id;

    private double orderCost=0;

    private int count=0;

    private double discount=0;

    private double shippingCost;

    private List<MedicineAPI> medicineList = new ArrayList<>();
    private DeliveryType deliveryType;
    private static int counter=0;
    private List<OrderObserver> observers = new ArrayList<>();
    {
        observers.add(new PriceObserver());
        observers.add(new QuantityObserver());
    }
    private OrderStateAPI state;
    private OrderStateAPI startOrder= new StartOrder(this);
    private OrderStateAPI orderConfirmed = new OrderConfirmed(this);
    private OrderStateAPI orderDispatched = new OrderDispatched(this);
    private OrderStateAPI orderDelivered = new OrderDelivered(this);
    private OrderStateAPI closeOrder = new CloseOrder(this);

    public Order() {
        super();
        this.id = ++counter;
        this.deliveryType = DeliveryType.Pickup;
        this.state = getStartOrder();
    }
    public Order(double orderCost, int count, double shippingCost, DeliveryType deliveryType) {
        super();
        this.id = ++counter;
        this.orderCost = orderCost;
        this.count = count;
        this.deliveryType = deliveryType;

        if(deliveryType==DeliveryType.Pickup) {
            this.shippingCost = 0;
        }else {
            this.shippingCost = shippingCost;
        }
        this.state = getStartOrder();
    }
    public void addMedicine(MedicineAPI medicine) {
        medicineList.add(medicine);
        orderCost+=medicine.medicinePrice();
        count++;
        observers.forEach(o->o.updated(this));
    }

    public boolean removeMedicine(MedicineAPI book) {
        if(medicineList.remove(book)) {
            return true;
        }
        return false;
    }


    @Override
    public void orderConfirmed() {
        this.state.orderConfirmed();
    }

    @Override
    public void orderDispatched() {
        this.state.orderDispatched();
    }

    @Override
    public void orderDelivered() {
        this.state.orderDelivered();
    }

    @Override
    public void closeOrder() {
        this.state.closeOrder();
    }

    public OrderStateAPI getState() {
        return state;
    }

    public void setState(OrderStateAPI state) {
        this.state = state;
    }

    public OrderStateAPI getStartOrder() {
        return startOrder;
    }

    public void setStartOrder(OrderStateAPI startOrder) {
        this.startOrder = startOrder;
    }

    public OrderStateAPI getOrderConfirmed() {
        return orderConfirmed;
    }

    public void setOrderConfirmed(OrderStateAPI orderConfirmed) {
        this.orderConfirmed = orderConfirmed;
    }

    public OrderStateAPI getOrderDispatched() {
        return orderDispatched;
    }

    public void setOrderDispatched(OrderStateAPI orderDispatched) {
        this.orderDispatched = orderDispatched;
    }

    public OrderStateAPI getOrderDelivered() {
        return orderDelivered;
    }

    public void setOrderDelivered(OrderStateAPI orderDelivered) {
        this.orderDelivered = orderDelivered;
    }

    public OrderStateAPI getCloseOrder() {
        return closeOrder;
    }

    public void setCloseOrder(OrderStateAPI closeOrder) {
        this.closeOrder = closeOrder;
    }
    public List<MedicineAPI> getMedicineList() {
        return medicineList;
    }


    public void setMedicineList(List<MedicineAPI> bookList) {
        this.medicineList = bookList;
    }

    public String getMedicineListString() {
        StringBuilder sb = new StringBuilder();
        for(MedicineAPI b : medicineList) {
            sb.append(b);
            sb.append("; ");
        }
        return sb.toString();
    }
    public DeliveryType getDeliveryType() {
        return deliveryType;
    }


    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }
    public static int getCounter() {
        return counter;
    }


    public static void setCounter(int counter) {
        Order.counter = counter;
    }


    public List<OrderObserver> getObservers() {
        return observers;
    }


    public void setObservers(List<OrderObserver> observers) {
        this.observers = observers;
    }


    public void setCount(int count) {
        this.count = count;
    }


    public double getOrderCost() {
        return orderCost;
    }

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public Order(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return orderCost - discount + shippingCost;
    }

    public void setOrderCost(double orderCost) {
        this.orderCost = orderCost;
    }

    public int getCount() {
        return medicineList.size();
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", itemCost=" + orderCost + ", count=" + count + ", discount=" + discount
                + ", shippingCost=" + shippingCost+ "]";
    }


}
