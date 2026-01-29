package code.src.main.java.lld.examples.ekart.foodDeliverySystem.apis;

import businesslogic.searchers.RestaurantSearcher;
import data.Restaurant;

public class GetRestByIdAPI {
    public Restaurant getRestById(int id){
        if(id<0){

        }
        
        return new RestaurantSearcher().searchById(id);
           
    }
}
