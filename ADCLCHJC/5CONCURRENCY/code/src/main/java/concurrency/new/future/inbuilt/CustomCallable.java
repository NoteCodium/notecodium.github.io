package concurrencyrefractored.NEW.future.inbuilt;

import java.util.concurrent.Callable;
//Runnable was not being imported 


public class CustomCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "Hi from CustomCallable";
    }
        
}
