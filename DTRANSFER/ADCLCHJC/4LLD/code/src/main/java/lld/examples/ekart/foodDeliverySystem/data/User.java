package code.src.main.java.lld.examples.ekart.foodDeliverySystem.data;

import lombok.Data;

//revise abstract class
@Data
public class User {
    private final int id;
    private final String name;
    private final Address address;
    private final String phoneNumber;
    private final String email;
}
