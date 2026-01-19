package concurrencyrefractored.NEW.ThreadPool.server;


import java.util.List;
// import java.util.concurrent.Callable;
// import java.util.concurrent.FutureTask;

public class SingleThreadedServer {
    public int getPairCounter(List<Integer> v, int k) throws Exception {
        // Callable<Integer> callable= new PairCounter(v,k);
        // FutureTask<Integer> futureTask= new FutureTask<>(callable);
        // new Thread(futureTask).start();
        // return futureTask;
        return new PairCounter(v,k).call();
    }
}
