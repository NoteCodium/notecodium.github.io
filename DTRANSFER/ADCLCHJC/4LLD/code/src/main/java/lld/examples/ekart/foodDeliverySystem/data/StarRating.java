package code.src.main.java.lld.examples.ekart.foodDeliverySystem.data;

// public enum MealType {
//     VEG,
//     NON_VEG,
//     VEG_NON_VEG
// }

//enum are initialized only once
//important
public enum StarRating {
    ONE_STAR(1),
    TWO_STAR(2),
    THREE_STAR(3),
    FOUR_STAR(4),
    FIVE_STAR(5);
    //important syntax

    private final int val;

    private  StarRating(int val){
        this.val=val;
    }

    public int getVal(){
        return this.val;
    }

}

 