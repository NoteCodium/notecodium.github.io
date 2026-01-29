package code.src.main.java.lld.examples.ekart.foodDeliverySystem.apis;

import businesslogic.managers.CartManager;
import businesslogic.managers.UserManager;
import businesslogic.searchers.FoodItemSearcher;
import data.FoodItem;
import data.User;

public class Add2CartAPI {

    private final UserManager userManager=
         new UserManager();
    // i THINK better stratedy would be making them static

    private final FoodItemSearcher FoodItemSearcher=   
        new FoodItemSearcher();

    private final CartManager cartManager=
        new CartManager();

    public void add2Cart(String userToken, int foodItemId){
        //figuring out user from userToken
        User user=
             userManager.getUserByToken(userToken);


        if(user==null){

        }
        
        FoodItem foodItem=
            FoodItemSearcher.searchById(foodItemId);

        if(foodItem==null){

        }
        
        //this is the in CartManager we have made add2Cart accept a user
        cartManager.add2Cart(user, foodItem);
        
    }


    // public void add2Cart(String userToken, int foodItemId, int quantity){
        
    // }

}
