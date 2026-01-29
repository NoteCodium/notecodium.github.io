package code.src.main.java.lld.examples.ekart.foodDeliverySystem.filters;

import java.util.List;

import data.CuisineType;
import data.FoodItem;
import data.Restaurant;

@ReqquiredArgsConstructor
public class CuisineTypeFilter implements FoodItemFilter, RestFilter {

    //implement CuisineType
    private final List<CuisineType> CuisineTypesOfFilter;

    @Override
    public boolean filter(FoodItem foodItem) {
         return CuisineTypesOfFilter.contains(foodItem.getCuisineType());
    }

    
        //imp
    @Override
    public boolean filter(Restaurant restaurant) {
        List<CuisineType> cuisineTypesOfRest= restaurant.getCuisineTypes();
        for(CuisineType cuisineType: cuisineTypesOfRest){
            if(CuisineTypesOfFilter.contains(cuisineType)){
                return true;
            }
        }
        return false;
        
    } 
    
}
