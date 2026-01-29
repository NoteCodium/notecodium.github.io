package concurrencyrefractored.NEW.ThreadPool.inbuilt;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService=
            Executors.newFixedThreadPool(5);
        //Like factory method

        Worker worker1= new Worker();
        Worker worker2= new Worker();
        Worker worker3= new Worker();
        Worker worker4= new Worker();
        Worker worker5= new Worker();

        // executorService.submit(worker1);
        // executorService.submit(worker2);
        // executorService.submit(worker3);
        // executorService.submit(worker4);
        // executorService.submit(worker5);

        
        // Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted. Invocation has no additional effect if already shut down.

        // This method does not wait for previously submitted tasks to complete execution. Use awaitTermination to do that
        // executorService.shutdown();

        ThreadPoolExecutor threadPoolExecutor=
            new ThreadPoolExecutor(
                4,
                6,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10)
            );

        // threadPoolExecutor.submit(new Runnable(){
        //     @Override
        //     public void run(){
        //         log.info("Starting task");
        //         log.info("Starting task");
        //     }
        // });
        
        threadPoolExecutor.submit(() -> {
            log.info("Starting task");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
            }
            log.info("Endingtask");
        });

    }
}
