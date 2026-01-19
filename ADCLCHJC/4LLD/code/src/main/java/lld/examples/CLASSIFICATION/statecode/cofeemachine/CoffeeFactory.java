package code.src.main.java.lld.examples.CLASSIFICATION.statecode.cofeemachine;

//its different from the original code of factory
// public static Permission getAdd2CartPerm(User user, FoodItem foodItem){
//     return new Add2CartPerm(user, foodItem);
// }

// public static Permission getDeleteFromCartPerm(User user, FoodItem foodItem){
//     return new DeleteFromCartPerm(user, foodItem);
// }

public class CoffeeFactory implements AbstractCoffeeFactory{

    @Override
    public Coffee getCoffee(String coffeeType){
        Coffee coffee;
        if(coffeeType.equals("Americano")){
            coffee= new DAmericano();
            //doubt why it is showing error?
        }
        else{
            coffee= new DAmericano();
        }
        return coffee;
    }
}
