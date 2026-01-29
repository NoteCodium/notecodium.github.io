package code.src.main.java.lld.examples.CLASSIFICATION.statecode.cofeemachine;
package examplesRefractor.CLASSIFICATION.STATE.cofeemachine;

public abstract class Coffee {

    private final Bean bean;
    private final IngredientFactory ingredientFactory;

    protected Coffee(IngredientFactory ingredientFactory){
        this.ingredientFactory=ingredientFactory;
        this.bean=ingredientFactory.getBean();
    }

    abstract void brew();
    abstract void boil();
    abstract void pour();
}
