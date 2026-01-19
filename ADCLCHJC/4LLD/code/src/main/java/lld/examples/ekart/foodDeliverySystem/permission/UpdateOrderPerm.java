package code.src.main.java.lld.examples.ekart.foodDeliverySystem.permission;

import data.Order;
import data.OrderStatus;
import data.User;

public class UpdateOrderPerm implements Permission{

    private final User user;
    private final Order order;
    private final OrderStatus orderStatus;

    @Override
    public boolean isPermitted() {
       return false;
    }
    
    public UpdateOrderPerm(User user, Order order, OrderStatus orderStatus) {
        this.user = user;
        this.order = order;
        this.orderStatus = orderStatus;
    }



}
