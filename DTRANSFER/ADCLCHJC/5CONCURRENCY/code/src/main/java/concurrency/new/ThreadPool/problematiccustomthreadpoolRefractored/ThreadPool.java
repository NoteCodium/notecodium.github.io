package concurrencyrefractored.NEW.ThreadPool.problematiccustomthreadpoolRefractored;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import concurrencyrefractored.NEW.ThreadPool.problematiccustomthreadpoolRefractored.shutdownRefractored.Shutter;


public class ThreadPool {
    private final int noOfThreads;
    private final List<Thread> actualThreadPool;
    private final BlockingQueue<Runnable> tasksQueue;
    private final Set<Integer> deadThreadIds;
    //This should be concurrent Set?
    private boolean isShutDownInitiated;
    public static int yetToTerminateCnt;
    private final Thread bookkeeperThread;


    public ThreadPool(int noOfThreads){
        yetToTerminateCnt=noOfThreads;
        deadThreadIds=new HashSet<>();
        isShutDownInitiated=false;
        this.noOfThreads=noOfThreads;
        tasksQueue=new ArrayBlockingQueue<>(10);
        actualThreadPool=new ArrayList<>();
        for(int i=0;i<noOfThreads;i++){
            Thread thread=new Thread(new Worker(
                i,
                tasksQueue,
                deadThreadIds
            ));
            actualThreadPool.add(thread);
        }

        for(Thread thread: actualThreadPool){
            thread.start();
        }
        bookkeeperThread=new Thread(new BookkeeperRunnable(
            deadThreadIds, 
            actualThreadPool, 
            tasksQueue
        ));
        bookkeeperThread.start();
    }

    public synchronized FutureTask<Integer> submit(Callable<Integer> callable){
        if(isShutDownInitiated){
            try {
                throw new Exception("Shut down already initiated, cant accept more jobs");
            } catch (Exception e) {
            }
        }
        FutureTask<Integer> futureTask= new FutureTask<>(callable);
        try {
            tasksQueue.put(futureTask);
        } catch (Exception e) {
        }
        return futureTask;
    }    


    public void submit(Runnable runnable) {
        if(isShutDownInitiated){
            try {
                throw new Exception("Shut down already initiated, cant accept more jobs");
            } catch (Exception e) {
            }
        }
        try {
            tasksQueue.put(runnable);
        } catch (Exception e) {
        }
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
            }
        }

    }




}

