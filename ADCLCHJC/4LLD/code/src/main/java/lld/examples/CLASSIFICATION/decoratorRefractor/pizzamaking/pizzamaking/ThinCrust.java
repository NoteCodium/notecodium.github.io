package code.src.main.java.lld.examples.CLASSIFICATION.decoratorRefractor.pizzamaking.pizzamaking;

public class ThinCrust extends Pizza{
    @Override
    public double getCost(){
        return 7.0+ super.getCost();
    }

    @Override
    public String getName(){
        return super.getName()+" "+"Thin Crust";
    }    

}
