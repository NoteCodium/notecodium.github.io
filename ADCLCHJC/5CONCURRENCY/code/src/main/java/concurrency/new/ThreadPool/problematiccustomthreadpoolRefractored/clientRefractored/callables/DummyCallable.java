package concurrencyrefractored.NEW.ThreadPool.problematiccustomthreadpoolRefractored.clientRefractored.callables;

import java.util.concurrent.Callable;

public class DummyCallable implements Callable<Integer>{

    @Override
    public Integer call() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return 0;
    }
    
}
