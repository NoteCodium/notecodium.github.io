package concurrencyrefractored.NEW.ThreadPool.problematiccustomthreadpoolRefractored.clientRefractored.runnables;

public class ProblamaticRunnable implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException("Problematic Runnable");
    }
    
}
