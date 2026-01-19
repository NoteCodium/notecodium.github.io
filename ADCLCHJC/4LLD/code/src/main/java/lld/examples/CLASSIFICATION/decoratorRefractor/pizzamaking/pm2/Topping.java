package code.src.main.java.lld.examples.CLASSIFICATION.decoratorRefractor.pizzamaking.pm2;

//Topping is also a pizza
//Topping contain a pizza

public abstract class Topping extends Pizza{
    private final Pizza pizza;
    //doubt

    public Topping(String name, double cost, Pizza pizza){
        super(name, cost);
        this.pizza=pizza;
    }

    @Override
    public String getName(){
        return super.getName()+" "+pizza.getName();
    }

    @Override
    public double getCost(){
        return super.getCost()+pizza.getCost();
    }
}

