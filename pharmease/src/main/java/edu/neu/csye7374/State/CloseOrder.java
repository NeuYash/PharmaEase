package edu.neu.csye7374.State;

import edu.neu.csye7374.Observer.Order;

public class CloseOrder implements OrderStateAPI{
    private Order order;

    public CloseOrder(Order order) {
        super();
        this.order = order;
    }

    @Override
    public void orderConfirmed() {
        System.out.println("Error!! Order has already been closed.");
    }

    @Override
    public void orderDispatched() {
        System.out.println("Error!! Order has already been closed.");
    }

    @Override
    public void orderDelivered() {
        System.out.println("Error!! Order has already been closed.");
    }

    @Override
    public void closeOrder() {
        System.out.println("Error!! Order has already been closed.");
    }
}
