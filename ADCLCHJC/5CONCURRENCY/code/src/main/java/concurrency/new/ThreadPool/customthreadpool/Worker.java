package concurrencyrefractored.NEW.ThreadPool.customthreadpool;


import static concurrencyrefractored.NEW.ThreadPool.customthreadpool.shutdown.Shutter.SHUTDOWN_THREAD;

import java.util.concurrent.BlockingQueue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Worker implements Runnable{
    private final int id;
    private final BlockingQueue<Runnable> taskQueue;

    @Override
    public void run() {
        while(true){
            //Using the famous syntax here
            Runnable task=null;       
            try {
                task=taskQueue.take();
                task.run();
            } catch (Exception e) {
                if((e.getMessage()).equals(SHUTDOWN_THREAD)){
                    break;
                }
                // System.out.println(e.getMessage());
                // e.printStackTrace();
            }
        }    
        System.out.println("Thread "+id+" shutdown completed");  
    }
    
}
