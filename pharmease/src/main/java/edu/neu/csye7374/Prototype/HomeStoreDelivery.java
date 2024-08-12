package edu.neu.csye7374.Prototype;

import edu.neu.csye7374.Observer.Order;

public class HomeStoreDelivery extends StoreDeliveryType {

    public HomeStoreDelivery(int deliveryId, String deliveryType, double deliveryCost, Order order) {
        super(deliveryId, deliveryType, deliveryCost, order);
        // TODO Auto-generated constructor stub
    }

    @Override
    public HomeStoreDelivery clone() {
        return new HomeStoreDelivery(this.getDeliveryId(), this.getDeliveryType(), this.getDeliveryCost(), this.getOrder());
    }

    @Override
    String delivertDescription() {
        // TODO Auto-generated method stub
        return "Your order will be delivered to home";
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Delivery Type: ")
                .append(getDeliveryType()).append("\t Delivery Cost: ")
                .append(getDeliveryCost()).append("For Order: ")
                .append(getOrder().toString()).toString();
    }
}
