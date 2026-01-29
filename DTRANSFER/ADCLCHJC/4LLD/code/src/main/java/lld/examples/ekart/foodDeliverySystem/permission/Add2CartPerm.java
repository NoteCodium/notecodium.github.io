package code.src.main.java.lld.examples.ekart.foodDeliverySystem.permission;
import businesslogic.managers.DeliveryManager;
import businesslogic.searchers.RestSearcher;
import data.FoodItem;
import data.Restaurant;
import data.User;

public class Add2CartPerm implements Permission{

    private final User user;
    private final FoodItem foodItem;
    //for checkout you added the foodItem long aga and now the foodItem is not available
    //A user in different city adding a foodItem 
    private final DeliveryManager deliveryManager;

    public Add2CartPerm(User user, FoodItem foodItem) {
        this.user = user;
        this.foodItem = foodItem;
        this.deliveryManager = new DeliveryManager();
        //Figuring out this is important
    }

    @Override
    public boolean isPermitted() {
        if(!foodItem.isAvailable()){
            return false;
        }


        Restaurant restaurant=
            new RestSearcher().searchById(foodItem.getRestId());

        return deliveryManager.isDeliveryPossible(restaurant.getAddress(), user.getAddress());
        
    }
    
}
