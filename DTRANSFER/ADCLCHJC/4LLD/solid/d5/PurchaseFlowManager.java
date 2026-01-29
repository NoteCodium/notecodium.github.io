package LLD.solid.d5;

import LLD.solid.d5.NotificationSender.NotificationSender;
import LLD.solid.d5.PaymentProcessor.PaymentProcessor;

public class PurchaseFlowManager {
    private final PaymentProcessor paymentProcessor;
    private final NotificationSender notificationSender;

    //di
    //It is up to the client which implementaton of interface he want to use
    //they will inject it
    public PurchaseFlowManager(PaymentProcessor paymentProcessor, NotificationSender notificationSender) {
        this.paymentProcessor = paymentProcessor;
        this.notificationSender = notificationSender;
    }

    //this makes many types of implementation possible
    //di by
    //1. constructor
    //2. setter

    //You are not using new keyword
    //your client has that responsbility
    //better testing

    void triggerPurchaseFlow(int productId, int customerId) {
        paymentProcessor.processPayment(productId, customerId);
        notificationSender.sendNotification(productId, customerId);
    } 



}
