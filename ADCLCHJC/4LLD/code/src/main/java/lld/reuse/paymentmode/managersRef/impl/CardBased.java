package code.src.main.java.lld.reuse.paymentmode.managersRef.impl;

import data.PaymentResponse;
import lld.reuse.paymentmode.managersRef.PaymentManager;

public class CardBased implements PaymentManager{

    private final String bankName;
    private final String cardNumber;
    private final String pin;
    private final double amount; 



    public CardBased(String bankName, String cardNumber, String pin, double amount) {
        this.bankName = bankName;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.amount = amount;
    }

    

    @Override
    public PaymentResponse executePayment() {
        
    }
    
}
