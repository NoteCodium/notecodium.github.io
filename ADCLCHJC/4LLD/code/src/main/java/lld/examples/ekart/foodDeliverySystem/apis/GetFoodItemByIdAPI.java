package code.src.main.java.lld.examples.ekart.foodDeliverySystem.apis;

import businesslogic.searchers.FoodItemSearcher;
import data.FoodItem;

//where will be it used?
public class GetFoodItemByIdAPI {
    public FoodItem getFoodItemById(int id){
        if(id<0){

        }
        return new FoodItemSearcher().searchById(id);  
    }
}
