package code.src.main.java.lld.examples.ekart.foodDeliverySystem.permission;

import data.FoodItem;
import data.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteFromCartPerm implements Permission{

    private final User user;
    private final FoodItem foodItem;

    @Override
    public boolean isPermitted() {
       return true;
    }
    
}
