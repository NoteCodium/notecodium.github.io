package concurrencyrefractored.NEW.BatchProcess.custom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

// import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor
public class ThreadPool {
    private final int numThreads;
    private final List<Thread> actualThreadPool;
    private final BlockingQueue<Task> taskQueue;

    public ThreadPool(int numThreads) {
        this.numThreads = numThreads;
        this.taskQueue = new PriorityBlockingQueue<>(10,
            new Comparator<Task>() {
                @Override
                public int compare(Task t1, Task t2){
                    long diff = t1.getFireTimeInMilliSecs() - t2.getFireTimeInMilliSecs();
                    int ans=0;
                    if(diff>0){
                        ans=1;
                    }else if(diff<0){
                        ans=-1;
                    }
                    return ans;
                }        
            } 
        );

        this.actualThreadPool = new ArrayList<>();
        for(int i=0;i<numThreads;i++){
            Thread t = new Thread(new Worker(taskQueue));
            actualThreadPool.add(t);
            t.start();
        }
    }

    public void submitTask(Task task){
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
    }


}
