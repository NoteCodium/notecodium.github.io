package code.src.main.java.concurrency.threads.numberstore1;

public class NumberStore {
    private int x;
    public NumberStore(){
        this.x=0;
    }
    public synchronized void increment(){
        x++;
    }
    public synchronized int getX(){
        return x;
    }


}
