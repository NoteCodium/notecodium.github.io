package code.src.main.java.lld.designpatterns.factory.old.factory;

import data.FoodItem;
import data.Order;
import data.OrderStatus;
import data.User;
import permission.Add2CartPerm;
import permission.CheckoutCartPerm;
import permission.DeleteFromCartPerm;
import permission.Permission;
import permission.PlaceOrderPerm;
import permission.UpdateOrderPerm;

public class PermFactory{
 //produce objects
 //need not have state inside it 

    private PermFactory(){}
    
    public static Permission getAdd2CartPerm(User user, FoodItem foodItem){
        return new Add2CartPerm(user, foodItem);
    }

    public static Permission getDeleteFromCartPerm(User user, FoodItem foodItem){
        return new DeleteFromCartPerm(user, foodItem);
    }
    
    public static Permission getUpdateOrderPerm(User user, Order order, OrderStatus orderStatus){
        return new UpdateOrderPerm(user, order, orderStatus);
    }

    public static Permission getCheckoutCartPerm(User user){
         return new CheckoutCartPerm(user);
    }

    public static Permission getPlaceOrderPerm(User user){
        return new PlaceOrderPerm(user);
    }


}