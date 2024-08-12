package edu.neu.csye7374.State;

import edu.neu.csye7374.Observer.Order;

public class OrderDispatched implements OrderStateAPI{
    private Order order;

    public OrderDispatched(Order order) {
        super();
        this.order = order;
    }

    @Override
    public void orderConfirmed() {
        System.out.println("Error!! Order has already been dispatched.");
    }

    @Override
    public void orderDispatched() {
        System.out.println("Error!! Order has already been dispatched.");
    }

    @Override
    public void orderDelivered() {
        order.setState(order.getOrderDelivered());
        System.out.println("Order has been DELIVERED!");

    }

    @Override
    public void closeOrder() {
        System.out.println("Error!! Order hasn't been delivered.");
    }
}
