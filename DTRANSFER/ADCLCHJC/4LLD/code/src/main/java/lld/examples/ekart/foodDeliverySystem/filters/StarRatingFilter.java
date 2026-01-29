package code.src.main.java.lld.examples.ekart.foodDeliverySystem.filters;

import data.FoodItem;
import data.Restaurant;
import data.StarRating;
import lombok.RequiredArgsConstructor;

//imp
@RequiredArgsConstructor
public class StarRatingFilter implements FoodItemFilter, RestFilter {

    private final StarRating starRating;
    //implement StarRating

    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getStarRating().getVal()>=starRating.getVal();
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        return restaurant.getStarRating().getVal()>=starRating.getVal();
    }
    
}