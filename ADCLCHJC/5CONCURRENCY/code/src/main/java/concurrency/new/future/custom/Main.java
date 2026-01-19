package concurrencyrefractored.NEW.future.custom;

public class Main {
    public static void main(String[] args) {
        CustomFutureReturnRunnable customFutureReturnRunnable=
            new CustomFutureReturnRunnable();

        new Thread(customFutureReturnRunnable).start();
        String ans= customFutureReturnRunnable.get();
        System.out.println(ans);
    }
}
