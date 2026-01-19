package code.src.main.java.lld.examples.ekart.foodDeliverySystem.data;

@Data
public class Address {
    private final String addressLine1;
    private final String addressLine2;
    private final String addressLine3;
    //make it optional somehow 
    private final String city;
    private final String state;
    private final String pincode;
}
