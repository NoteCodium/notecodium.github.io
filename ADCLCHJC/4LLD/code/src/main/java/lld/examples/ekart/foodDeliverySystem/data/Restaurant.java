package code.src.main.java.lld.examples.ekart.foodDeliverySystem.data;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// @Getter
// @RequiredArgsConstructor 
@Data
public class Restaurant {
    private final int id;
    private final String name;
    private final String description;

    //specific to rest
    private final BusinessHours BusinessHours;
    private final Menu menu;
    private final Address address;

    private final MealType mealType;
    private final StarRating starRating;

    private final List<CuisineType> cuisineTypes;

}
