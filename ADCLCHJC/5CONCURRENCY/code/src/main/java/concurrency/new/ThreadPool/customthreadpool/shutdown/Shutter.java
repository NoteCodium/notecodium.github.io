package concurrencyrefractored.NEW.ThreadPool.customthreadpool.shutdown;

public class Shutter implements Runnable{

    public final static String SHUTDOWN_THREAD="Shutdown initiated, present thread is being shutting down";

    @Override
    public void run() {
        throw new RuntimeException(SHUTDOWN_THREAD);
       
    }
    
}
