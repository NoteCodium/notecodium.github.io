package code.src.main.java.lld.examples.CLASSIFICATION.decoratorRefractor.pizzamaking.pm2;

public class Mushroom extends Topping{
    public Mushroom(Pizza pizza){
        super("Mushroom", 5, pizza);
    }
}
