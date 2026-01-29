package concurrencyrefractored.NEW.ThreadPool.server;


import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MultiThreadedServer {
    public FutureTask<Integer> getPairCounter(List<Integer> v, int k) {
        Callable<Integer> callable= new PairCounter(v,k);
        FutureTask<Integer> futureTask= new FutureTask<>(callable);
        new Thread(futureTask).start();
        return futureTask;
    }
}
