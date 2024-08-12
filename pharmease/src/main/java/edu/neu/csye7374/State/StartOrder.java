package edu.neu.csye7374.State;

import edu.neu.csye7374.Observer.Order;

public class StartOrder implements OrderStateAPI{
    private Order order;

    public StartOrder(Order order) {
        super();
        this.order = order;
    }



    @Override
    public void orderConfirmed() {
        order.setState(order.getOrderConfirmed());
        System.out.println("Thank you for the confirmation, your order has been placed.");
    }

    @Override
    public void orderDispatched() {
        System.out.println("Error!! Order hasnt been confirmed");
    }

    @Override
    public void orderDelivered() {
        System.out.println("Error!! Order hasnt been confirmed");

    }

    @Override
    public void closeOrder() {
        System.out.println("Error!! Order hasnt been confirmed");
    }
}
