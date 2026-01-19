package code.src.main.java.lld.examples.CLASSIFICATION.statecode.cofeemachine;

public class DAmericano implements Coffee{

    public DAmericano(DIngredientFactory ingredientFactory){
        super(ingredientFactory);
    }

    @Override
    public void brew() {

    }

    @Override
    public void boil() {

    }

    @Override
    public void pour() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pour'");
    }

}
