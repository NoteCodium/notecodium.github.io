package concurrencyrefractored.NEW.future.inbuilt;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask=new FutureTask<>(new CustomCallable());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
