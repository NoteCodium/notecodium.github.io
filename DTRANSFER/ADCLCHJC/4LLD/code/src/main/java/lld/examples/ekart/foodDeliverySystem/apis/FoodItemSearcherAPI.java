package code.src.main.java.lld.examples.ekart.foodDeliverySystem.apis;

import java.util.List;

import data.CuisineType;
import data.FoodItem;
import data.MealType;
import data.StarRating;

///I think we wont need an interface this time

//apply pagination bonus
public class FoodItemSearcherAPI {
    public List<FoodItem> searchFoodItems(String foodItemName, MealType MealType, List<CuisineType> cuisines, StarRating StarRating){
        return null;   
    }
}

//Searcherf generic
//fuzzy search for food item
//this is how it differ from a normal get for an id
