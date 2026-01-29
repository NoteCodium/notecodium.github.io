package code.src.main.java.lld.examples.CLASSIFICATION.statecode.cofeemachine;

@RequiredArgsConstructor
public class CoffeeServer {
    public final AbstractCoffeeFactory abstractCoffeeFactory;

    //bad code
    public Coffee serve(String coffeeType){
        Coffee coffee=
            abstractCoffeeFactory.getCoffee(coffeeType);
        coffee.brew();
        coffee.boil();
        return coffee;
    }

}
