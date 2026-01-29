package code.src.main.java.lld.examples.CLASSIFICATION.statecode.cofeemachine;

public class DDefaultIngredientFactory implements DIngredientFactory{
    @Override
    public DBean getBean(){
        return new DAmericanBean();
    }
}

