package concurrencyrefractored.NEW.BatchProcess.custom;

import java.util.concurrent.BlockingQueue;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Worker implements Runnable{

    // private final int id;
    private final BlockingQueue<Task> taskQueue;

    @Override
    public void run() {
        while(true){
            try {
                Task task=taskQueue.take();
                long currTime = System.currentTimeMillis();
                long fireTime = task.getFireTimeInMilliSecs();
                if(currTime>=fireTime){
                    task.run();
                    if(task.getSubsequentGapsInSecs()>0){
                        task.setFireTimeInMilliSecs(fireTime);
                        taskQueue.put(task);
                    }
                }
                else{
                    taskQueue.put(task);
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                // e.printStackTrace();
            }

        }
    }
    
}
