package code.src.main.java.lld.examples.CLASSIFICATION.decoratorRefractor.pizzamaking.pm2;

import lombok.Getter;

@Getter
public abstract class Pizza {

    private final String name;
    private final double cost;

    // Protected lets only subclasses (and same‑package code)? call the constructor
    // to initialize shared state, which is exactly what you want for an abstract
    // base class. It prevents unrelated code from calling it, while still allowing
    // subclasses in other packages to do super(name, cost). Package‑private would
    // block subclasses in other packages; private would block all subclasses.
    protected Pizza(String name, double cost){
        this.name=name;
        this.cost=cost;
    }
    
}
