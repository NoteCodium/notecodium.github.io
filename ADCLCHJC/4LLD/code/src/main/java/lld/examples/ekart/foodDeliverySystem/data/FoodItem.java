package code.src.main.java.lld.examples.ekart.foodDeliverySystem.data;

import java.util.List;

import lombok.Data;

@Data
public class FoodItem {
    private final int id;
    private final String name;
    private final MealType mealType;
    private final CuisineType cuisineType;
    private final StarRating starRating;

    private final String description;
    private final double priceINR;
    private final int restId;
    private final boolean isAvailable;
    //builder pattern to avoid this big constructor
    //it also helps us for optional fields

}
