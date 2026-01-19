package code.src.main.java.lld.examples.ekart.foodDeliverySystem.filters;

import data.FoodItem;
import data.MealType;
import data.Restaurant;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class MealTypeFilter implements FoodItemFilter, RestFilter {

    private final MealType mealType;
    //implement MealType

    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getMealType().equals(mealType);
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        return restaurant.getMealType().equals(mealType);
    }
    
}
