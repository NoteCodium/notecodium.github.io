package concurrencyrefractored.NEW.ThreadPool.customthreadpool;

import java.util.ArrayList;
import java.util.List;
// import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import concurrencyrefractored.NEW.ThreadPool.customthreadpool.shutdown.Shutter;

// @RequiredArgsConstructor
// @AllArgsConstructor
public class ThreadPool {
    private final int noOfThreads;
    private final List<Thread> actualThreadPool;
    private final BlockingQueue<Runnable> tasksQueue;
    // private final Set<Integer> deadThreads;
    private boolean isShutDownInitiated;
    // private int yetToTerminateCnt;

    //Constructor overloading if @RequiredArgsConstructor

    public ThreadPool(int noOfThreads){
        isShutDownInitiated=false;
        this.noOfThreads=noOfThreads;
        tasksQueue=new ArrayBlockingQueue<>(10);
        actualThreadPool=new ArrayList<>();
        for(int i=0;i<noOfThreads;i++){
            Thread thread=new Thread(new Worker(i,tasksQueue));
            actualThreadPool.add(thread);
        }
        //These all thread will keep on looking inside the queue for task to be executed
        for(Thread thread: actualThreadPool){
            thread.start();
        }
    }

    public synchronized FutureTask<Integer> submit(Callable<Integer> callable){
        if(isShutDownInitiated){
            try {
                throw new Exception("Shut down already initiated, cant accept more jobs");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                // e.printStackTrace();
            }
        }
        FutureTask<Integer> futureTask= new FutureTask<>(callable);
        try {
            tasksQueue.put(futureTask);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return futureTask;
    }    

    //first be clear about the shut down policy
        //the queue may have jobs
            //lets finish all the jobs in queue 
        //the clients may be still submitting new jobs
        //the threads may be still doing some work
    public synchronized void shutDown(){
        isShutDownInitiated=true;
        for(int i=0;i<noOfThreads;i++){
            try {
                tasksQueue.put(new Shutter());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                // e.printStackTrace();
            }
        }
    }


}

