package code.src.main.java.lld.examples.CLASSIFICATION.decoratorRefractor.pizzamaking.pm2;

public class Main {
    public static void main(String[] args) {
        Pizza pizza=
            new Mushroom(new Mushroom(new WheatBase()));

        //how to do this programatically
        
        System.out.println(pizza.getName());
        System.out.println(pizza.getCost());

    }
}
