package concurrencyrefractored.NEW.ThreadPool.server;

import java.util.List;
import java.util.concurrent.Callable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PairCounter implements Callable<Integer>{
    private final List<Integer> v;
    private final int k;
    
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 0;
    }   
    
}
