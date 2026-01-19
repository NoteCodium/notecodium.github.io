package code.src.main.java.lld.examples.ekart.foodDeliverySystem.dataaccessor;

import java.util.List;

import data.CartItem;
import data.FoodItem;
import data.User;

public class DataAccessor {
    private DataAccessor(){}

    public static void add2Cart(User user, FoodItem foodItem){
         
    } 

    public static Result getFoodItemWithName(String foodItemName){
        return null;
    }

    public static Result getCart(User user){
    //How the DB table of the Cart looks like
    //id, user_id, food_item_id, qty, status (ready, checked_out)
    //the cart can be figured out from the db table
        return null;
    }

    public static void deleteFromCart(User user, FoodItem foodItem) {
       
    }

    //changing the status of products in the Cart table in db
    public static void checkoutCart(User user){
        
    }


    //creating an order in the orders tables db
    public static int createOrder(User user, List<CartItem> cartItems){
        return 1;
    }


}
