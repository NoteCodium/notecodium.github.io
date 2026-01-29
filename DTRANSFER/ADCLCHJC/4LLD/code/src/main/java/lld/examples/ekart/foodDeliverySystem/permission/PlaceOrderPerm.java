package code.src.main.java.lld.examples.ekart.foodDeliverySystem.permission;
import data.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaceOrderPerm implements Permission{
    //how it difers from Checkout Permission?

    private final User user;

    @Override
    public boolean isPermitted() {
        return true;
    }

}
