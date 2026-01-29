package code.src.main.java.lld.designpatterns.factory.old.factory;

import java.util.List;

import data.CartItem;
import data.Order;
import data.OrderStatus;
import data.User;
import dataaccessor.DataAccessor;
import factory.PermFactory;
import permission.Permission;

public class OrderManager {
    public Order placeOrder(User user){
        Permission permission=
            PermFactory.getPlaceOrderPerm(user);

        if(!permission.isPermitted()){
            throw new IllegalArgumentException("Permission denied");
        }
        
        CartManager cartManager=
            new CartManager();

        //we are not sure CartManager will be needed by the other methods or not

        List<CartItem> cartItems=
            cartManager.getUserCart(user);

        int orderId=
            DataAccessor.createOrder(user, cartItems);


        cartManager.checkoutCart(user);

        return new Order(cartItems, orderId, user.getId(), OrderStatus.ORDER_PLACED);
    }



    public List<Order> getOrders(User user){
        return null;
    }

    public Order getOrder(int orderId){
        return null;
    }


    public void cancelOrder(User user, Order order){
        //special logic
        //time based bonus


    }


    public void setOrder2Cooking(User user, Order order){
        Permission permission=
            PermFactory.getUpdateOrderPerm(user, order, OrderStatus.COOKING);

        if(!permission.isPermitted()){
            throw new IllegalArgumentException("Permission denied");
        }

        if(!order.getOrderStaus().equals(OrderStatus.ORDER_PLACED)){
            throw new IllegalArgumentException("Order not in correct state");
        }

        //now db accessor code


    }


    public void setOrder2OutForDelivery(User user, Order order){
        
    }


    public void setOrder2Delivered(User user, Order order){

    }
    //to reduce this continous checks we have
    // State Design Pattern

}
