package concurrencyrefractored.NEW.ThreadPool.inbuilt;

import lombok.RequiredArgsConstructor;

public class Worker implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        // }
        System.out.println(Thread.currentThread().getName());
        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        // }
    }
    
}
