package LLD.solid.d5;

import LLD.solid.d5.NotificationSender.SmsNotificationSender;
import LLD.solid.d5.PaymentProcessor.UpiPaymentProcessor;

public class Main {
    public static void main(String[] args) {
        //client decide whatto use
        PurchaseFlowManager purchaseFlowManager = 
        new PurchaseFlowManager(
            new UpiPaymentProcessor(),
            new SmsNotificationSender()
        );

        purchaseFlowManager.triggerPurchaseFlow(1, 1);

    }
}
