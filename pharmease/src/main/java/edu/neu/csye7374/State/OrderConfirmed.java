package edu.neu.csye7374.State;

import edu.neu.csye7374.Observer.Order;

public class OrderConfirmed implements OrderStateAPI{
    private Order order;

    public OrderConfirmed(Order order) {
        super();
        this.order = order;
    }

    @Override
    public void orderConfirmed() {
        System.out.println("ERROR! Order already confirmed");
    }

    @Override
    public void orderDispatched() {
        order.setState(order.getOrderDispatched());
        System.out.println("Order has been DISPATCHED!.");
    }

    @Override
    public void orderDelivered() {
        System.out.println("ERROR! Order hasn't been dispatched.");
    }

    @Override
    public void closeOrder() {
        System.out.println("ERROR! Order hasnt been dispatched.");
    }
}
