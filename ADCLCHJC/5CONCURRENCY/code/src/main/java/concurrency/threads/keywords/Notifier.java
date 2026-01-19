package code.src.main.java.concurrency.threads.keywords;

public class Notifier implements Runnable{
    private final Object o;
    public Notifier(Object o){
        this.o=o;
    }

    @Override
    public void run() {
        synchronized(o){
            o.notify();
            //notify dont throw exception
        }
    }
    
}
