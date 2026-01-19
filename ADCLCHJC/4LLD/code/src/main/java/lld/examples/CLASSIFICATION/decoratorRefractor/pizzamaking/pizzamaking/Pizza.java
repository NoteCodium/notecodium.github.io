package code.src.main.java.lld.examples.CLASSIFICATION.decoratorRefractor.pizzamaking.pizzamaking;

@Setter
public abstract class Pizza {
//At present we have to introduce many changes when we add something
//List of topping interface
// 

    private Mushroom mushroom;

    public double getCost(){
        double cost=0;
        if(mushroom!=null){
            cost+=mushroom.getCost();
        }

        return cost;
    }

    public String getName(){
        String name="";
        if(mushroom!=null){
            name+=mushroom.getName()+" ";
        }
        return name;
    }

}
