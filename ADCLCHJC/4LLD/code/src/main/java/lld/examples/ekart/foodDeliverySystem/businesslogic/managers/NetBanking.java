package code.src.main.java.lld.examples.ekart.foodDeliverySystem.businesslogic.managers;

import data.PaymentResponse;

public class NetBanking implements PaymentManager{

    private final String bankName;
    private final String userName;
    private final String password;
    private final String pin;
    private final double amount;

// Suggested code may be subject to a license. Learn more: ~LicenseLog:3527833786.
    public NetBanking(String bankName, String userName, String password, String pin, double amount) {
        this.bankName = bankName;
        this.userName = userName;
        this.password = password;
        this.pin = pin;
        this.amount = amount;
    }


    @Override
    public PaymentResponse executePayment() {
        return null;
    }
    
}


