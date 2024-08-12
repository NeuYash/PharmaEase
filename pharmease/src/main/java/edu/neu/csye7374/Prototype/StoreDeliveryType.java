package edu.neu.csye7374.Prototype;

import edu.neu.csye7374.Observer.Order;

public abstract class StoreDeliveryType implements Cloneable {
    private int deliveryId;
    private String deliveryType;
    private double deliveryCost;
    private Order order;

    public StoreDeliveryType(int deliveryId, String deliveryType, double deliveryCost, Order order) {
        super();
        this.deliveryId = deliveryId;
        this.deliveryType = deliveryType;
        this.deliveryCost = deliveryCost;
        this.order = order;
    }

    abstract String delivertDescription();

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }
    public Order getOrder() {
        return order;
    }

    @Override
    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }


}
