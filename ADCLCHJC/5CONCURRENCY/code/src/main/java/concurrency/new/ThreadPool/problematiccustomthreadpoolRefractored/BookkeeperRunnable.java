package concurrencyrefractored.NEW.ThreadPool.problematiccustomthreadpoolRefractored;

import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class BookkeeperRunnable implements Runnable{
    //What if this dies 
    //it wont because it will not handling any type of task

    private final Set<Integer> deadThreadIds;
    private final List<Thread> actualThreadPool;
    private final BlockingQueue<Runnable> tasksQueue;

    @Override
    public void run() {
        while (true) {
            // synchronized(deadThreadIds){
                while (deadThreadIds.isEmpty() && ThreadPool.yetToTerminateCnt!=0){
                    try {
                        deadThreadIds.wait();
                    } catch (Exception e) {
                    }
                }

                for(Integer id: deadThreadIds){
                    Thread thread= new Thread(
                        new Worker(id,tasksQueue, deadThreadIds)
                        );
                    actualThreadPool.set(id, thread);
                    log.info("Dead thread {} is now reborn", id);
                    thread.start();

                }
                deadThreadIds.clear();
                if(ThreadPool.yetToTerminateCnt==0){
                    break;
                }
                // deadThreadIds.notifyAll();
            // }
        }
    }
    
}
