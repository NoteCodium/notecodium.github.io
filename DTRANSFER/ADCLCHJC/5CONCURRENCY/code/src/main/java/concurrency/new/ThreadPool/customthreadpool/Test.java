package concurrencyrefractored.NEW.ThreadPool.customthreadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

import concurrencyrefractored.NEW.ThreadPool.customthreadpool.client.DummyCallable;
import concurrencyrefractored.NEW.ThreadPool.customthreadpool.client.PairCounterCallable;


public class Test {
    public static void main(String[] args) {
        ThreadPool threadPool= new ThreadPool(10);
        List<FutureTask<Integer>> futureTaskResults=new ArrayList<>();
        FutureTask<Integer> futureTaskResult=null;;
        for(int i=0; i<20;i++){
            if(i%2==0){
                //this would have been the logic but we have written the method
                //////////////////////////////////////////////////
                // futureTask= new FutureTask<>(new DummyCallable());
                // threadPool.tasksQueue.submit(futureTask);
                /////////////////////////////////////////////////////
                futureTaskResult=threadPool.submit(new DummyCallable());
                futureTaskResults.add(futureTaskResult);
            }
            else{
                futureTaskResult=threadPool.submit(new PairCounterCallable());
                futureTaskResults.add(futureTaskResult);
            }
            // Thread.sleep(1000);
        }
        threadPool.shutDown();

        for(FutureTask<Integer> futureTask:futureTaskResults){
            try {
                System.out.println(futureTask.get());
            } catch (Exception e) {
                // System.out.println(e.getMessage());
                // e.printStackTrace();
            }
        }

    }
}
