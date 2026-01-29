package code.src.main.java.lld.examples.ekart.foodDeliverySystem.businesslogic.managers;

import java.util.List;

import data.CartItem;
import data.FoodItem;
import data.User;
import dataaccessor.DataAccessor;
import dataaccessor.ResultsConverterNew;

import dataaccessor.Result;
// import dataaccessor.ResultsConverter;
import permission.Permission;
import factory.PermFactory;

//buy directly without adding to cart
public class CartManager {
    
    //doubt why not userID?
    public List<CartItem> getUserCart(User user){
        //the cart can be figured out from the db table


        Result results=
            DataAccessor.getCart(user);

        return ResultsConverterNew.convert2CartItems(results);
    }


    //doubt why not foodItemId?
    public void add2Cart(User user, FoodItem foodItem){
        //we need permissions and they can grow ver fast
        //ex read write execute
        //we cant make so many classes
        //Instead of creating the objects with new

        Permission permission=
            PermFactory.getAdd2CartPerm(user, foodItem);
        //doubt
        

        if(!permission.isPermitted()){
            throw new IllegalArgumentException("Permission denied");
        }

        if(!isFoodItemFromSameRest(user,foodItem)){
            throw new IllegalArgumentException("Food item not from same rest");
        }

        DataAccessor.add2Cart(user, foodItem);
        

    }


    private boolean isFoodItemFromSameRest(User user, FoodItem foodItem){
        List<CartItem> cartItems=
            getUserCart(user);

        return !cartItems.isEmpty() || 
            cartItems.get(0).getFoodItem().getRestId()==foodItem.getRestId();

    }


    public void deleteFromCart(User user, FoodItem foodItem){
        //bonus concurrecny issues


        Permission permission=
            PermFactory.getAdd2CartPerm(user, foodItem);
        //doubt
        

        if(!permission.isPermitted()){
            throw new IllegalArgumentException("Permission denied");
        }

        if(!isFoodItemPresentInCart(user, foodItem)){
            throw new IllegalArgumentException("Food item not present in cart");
        }


        DataAccessor.deleteFromCart(user, foodItem);



    }


// Suggested code may be subject to a license. Learn more: ~LicenseLog:856049483.
    private boolean isFoodItemPresentInCart(User user, FoodItem foodItem){
        List<CartItem> cartItems=
            getUserCart(user);


        //write linear search instead

        for(CartItem cartItem: cartItems){
            if(cartItem.getFoodItem().equals(foodItem)){
                return true;
            }
        }
        return false;
    }


    public void updateCart(User user, FoodItem foodItem, int quantity){

    }

    public void checkoutCart(User user){

        // List<CartItem> cartItems=
        //     getUserCart(user);

        Permission permission=
            PermFactory.getCheckoutCartPerm(user);
        
        if(!permission.isPermitted()){
            throw new IllegalArgumentException("Permission denied");
        }

        if(isCartEmpty(user)){
            throw new IllegalArgumentException("Cart is empty");
        }

        DataAccessor.checkoutCart(user);        
    }


    private boolean isCartEmpty(User user){
        List<CartItem> cartItems=
            getUserCart(user);

        return cartItems.isEmpty();
    }


}


//cart 
//cart_id, user_id, food_item_id, qty, status

//Orders
// order_id, cart_id


