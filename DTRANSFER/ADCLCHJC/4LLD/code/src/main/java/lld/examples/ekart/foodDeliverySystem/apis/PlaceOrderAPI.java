package code.src.main.java.lld.examples.ekart.foodDeliverySystem.apis;

import java.util.Map;

import businesslogic.managers.OrderManager;
import businesslogic.managers.PaymentManager;
import businesslogic.managers.UserManager;
import data.PaymentResponse;
import data.PaymentStatus;
import data.User;
import factory.PaymentManagerFactory;

public class PlaceOrderAPI {

    private final UserManager userManager=
        new UserManager();

    private final OrderManager orderManager=
        new OrderManager(); 

    public Order placeOrder(String userToken, Map<String, String> paymentInfo, String paymentMode){
        //using an object instead for paymentInfo, but here is the thing it can vary

        User user=
            userManager.getUserByToken(userToken);


        PaymentManager paymentManager=
            PaymentManagerFactory.getPaymentManager(paymentMode, paymentInfo);

        PaymentResponse paymentResponse=
            paymentManager.executePayment();


        //why for getStatus()?
        if(paymentResponse==null || paymentResponse.getStatus()==null || paymentResponse.getStatus().equals(PaymentStatus.FAILED)){
            throw new IllegalArgumentException("Payment failed");
        }

        return orderManager.placeOrder(user);
    }
}
