package code.src.main.java.lld.examples.ekart.foodDeliverySystem.businesslogic.searchers;

import java.util.List;

import data.Restaurant;
import filters.RestFilter;
import lld.examples.ekart.foodDeliverySystem.dataaccessor.DataAccessor;

public class RestSearcher {
    public List<Restaurant> search(String restName, List<RestFilter> filters){

        if(restName==null || restName.length()==0 || filters==null){
            throw new IllegalArgumentException("Missing params");
        }

        //list of restaurants wich lazily matches with restaurantName
        //because we can we wrongly spelling it
        //then apply filters to it
        //many cons, there can be millions of items oming from db, so you have to apply pagination


        DataAccessResult dataAccessResult=
            DataAccessor.getRestaurantsWithName(restName);

        List<Restaurant> restaurants= 
            DataAccessObjectConverter.convert2Restaurants(dataAccessResult);

    }

    public Restaurant searchById(int id){
        //this is how it differs from the above implementation
    }
    //admin token wagera
}
