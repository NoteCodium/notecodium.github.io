package concurrencyrefractored.NEW.ThreadPool.customthreadpool.client;

import java.util.concurrent.Callable;


public class PairCounterCallable implements Callable<Integer>{
    // private final List<Integer> v;
    // private final int k;
    
    @Override
    public Integer call() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return 0;
    }    
}
