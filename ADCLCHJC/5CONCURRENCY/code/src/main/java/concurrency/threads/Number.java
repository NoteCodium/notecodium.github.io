package code.src.main.java.concurrency.threads;
public class Number {
    private int x=0;

    public synchronized void increment() {
        int oldVal=getX();
        setX(oldVal+1);
    }

    public synchronized int getX() {
        return x;
    }

    public synchronized void setX(int val) {
        x=val;
    }


    // private Object o= new Object();

    // public void increment() {
    //     synchronized(o){
    //         x++;
    //     }
    // }


}