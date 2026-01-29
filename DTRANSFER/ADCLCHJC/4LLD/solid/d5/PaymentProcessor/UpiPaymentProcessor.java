package LLD.solid.d5.PaymentProcessor;

public class UpiPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(int productId, int customerId) {
        System.out.println("Processing payment using UPI");
    }
    
}
