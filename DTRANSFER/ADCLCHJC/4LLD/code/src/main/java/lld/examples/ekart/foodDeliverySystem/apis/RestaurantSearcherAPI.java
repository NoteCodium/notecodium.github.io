package code.src.main.java.lld.examples.ekart.foodDeliverySystem.apis;

import java.util.ArrayList;
import java.util.List;

import businesslogic.searchers.RestaurantSearcher;
import data.CuisineType;
import data.MealType;
import data.Restaurant;
import data.StarRating;
import filters.CuisineTypeFilter;
import filters.MealTypeFilter;
import filters.RestFilter;
import filters.StarRatingFilter;

public class RestaurantSearcherAPI {
    public List<Restaurant> searchRest(String restName, MealType mealType, List<CuisineType> cuisines, StarRating starRating){
        if(restName==null || restName.length()==0){
            throw new IllegalArgumentException("Missing params");
        }
        List<RestFilter> filters= new ArrayList<>();
        if(mealType!=null)
            filters.add(new MealTypeFilter(mealType));

        if(cuisines!=null)
            filters.add(new CuisineTypeFilter(cuisines));

        if(starRating!=null)
            filters.add(new StarRatingFilter(starRating));
        //these too many new can be avoided by factory design principle

        RestaurantSearcher restaurantSearcher=
            new RestaurantSearcher();

        return restaurantSearcher.search(restName, filters);
        
    }
}
