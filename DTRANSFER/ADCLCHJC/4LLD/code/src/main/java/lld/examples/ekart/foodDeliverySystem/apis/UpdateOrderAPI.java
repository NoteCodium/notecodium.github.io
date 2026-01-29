package code.src.main.java.lld.examples.ekart.foodDeliverySystem.apis;

import businesslogic.managers.OrderManager;
import businesslogic.managers.UserManager;
import data.Order;
import data.OrderStatus;
import data.User;

public class UpdateOrderAPI {

    UserManager userManager=
        new UserManager();

    OrderManager orderManager=
        new OrderManager();

    public void updateOrder(int orderId, OrderStatus status, String userToken){
        User user=
            userManager.getUserByToken(userToken);

        Order order=
            orderManager.getOrder(orderId);

        if(status.equals(OrderStatus.COOKING)){
            orderManager.setOrder2Cooking(user, order);
        }
        else if(status.equals(OrderStatus.READY_FOR_DELIVERY)){
            orderManager.setOrder2OutForDelivery(user, order);
        }
        else if(status.equals(OrderStatus.DELIVERED)){
            orderManager.setOrder2Delivered(user, order);
        }
        else{
            throw new IllegalArgumentException("Invalid order status");
        }
    }    
}
