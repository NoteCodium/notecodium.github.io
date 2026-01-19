package concurrencyrefractored.NEW.ThreadPool.problematiccustomthreadpoolRefractored;

import static concurrencyrefractored.NEW.ThreadPool.problematiccustomthreadpoolRefractored.shutdownRefractored.Shutter.SHUTDOWN_THREAD;

import java.util.Set;
import java.util.concurrent.BlockingQueue;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@AllArgsConstructor
@Slf4j
public class Worker implements Runnable{
    private final int id;
    private final BlockingQueue<Runnable> taskQueue;
    private final Set<Integer> deadThreadIds;

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
                synchronized(deadThreadIds){
                    deadThreadIds.add(id);
                    deadThreadIds.notifyAll();
                }
                log.info("Thread {} died unfortunatly", Thread.currentThread().getName());
                break;

            }
        }
        synchronized(deadThreadIds){
            ThreadPool.yetToTerminateCnt--;   
        }
        System.out.println("Thread "+id+" shutdown completed");  
    }
    
}
