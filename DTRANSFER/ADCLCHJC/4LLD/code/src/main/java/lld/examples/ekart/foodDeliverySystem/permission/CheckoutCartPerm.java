package code.src.main.java.lld.examples.ekart.foodDeliverySystem.permission;

import data.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckoutCartPerm implements Permission{
    
    private final User user;

    @Override
    public boolean isPermitted() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
