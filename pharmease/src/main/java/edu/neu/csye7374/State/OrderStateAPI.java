package edu.neu.csye7374.State;

public interface OrderStateAPI {
    public void orderConfirmed();
    public void orderDispatched();
    public void orderDelivered();
    public void closeOrder();
}
