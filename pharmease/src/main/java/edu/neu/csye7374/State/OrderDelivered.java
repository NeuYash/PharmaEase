package edu.neu.csye7374.State;

import edu.neu.csye7374.Observer.Order;

public class OrderDelivered implements OrderStateAPI{
    private Order order;

    public OrderDelivered(Order order) {
        super();
        this.order = order;
    }

    @Override
    public void orderConfirmed() {
        System.out.println("ERROR! Order has already been delivered.");

    }

    @Override
    public void orderDispatched() {
        System.out.println("ERROR! Order has already been delivered.");
    }

    @Override
    public void orderDelivered() {
        System.out.println("ERROR! Order has already been delivered.");
    }

    @Override
    public void closeOrder() {
        order.setState(order.getCloseOrder());
        System.out.println("Order has been CLOSED.");
    }
}
