package code.src.main.java.lld.designpatterns.factory.old.factory;
import java.util.Map;

import businesslogic.managers.CardBased;
import businesslogic.managers.NetBanking;
import businesslogic.managers.PaymentManager;

public class PaymentManagerFactory {
    private PaymentManagerFactory(){}

    public static PaymentManager getPaymentManager(String paymentMode, Map<String, String> paymentInfo){
        PaymentManager paymentManager=null;
        if(paymentMode.equals("Netbanking")){
            //make it enum
            paymentManager=getNetBankingPaymentManager(paymentInfo);
        }

        else if(paymentMode.equals("CardBased")){

        }
        else{
            throw new IllegalArgumentException("Invalid payment mode");
        }

        return paymentManager;
        ///use switch cas
    }

    private static PaymentManager getNetBankingPaymentManager(Map<String, String> paymentInfo){
// Suggested code may be subject to a license. Learn more: ~LicenseLog:2335369040.
        return new NetBanking(paymentInfo.get("bankName"), paymentInfo.get("userName"), paymentInfo.get("password"), paymentInfo.get("pin"), Double.parseDouble(paymentInfo.get("amount")));
    }

    // private static PaymentManager getCardPaymentManager(Map<String, String> paymentInfo){
    //     return new CardBased(paymentInfo.get("bankName"), paymentInfo.get("cardNumber"), paymentInfo.get("pin"), Double.parseDouble(paymentInfo.get("amount")));
    // }

}
