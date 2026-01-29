package code.src.main.java.concurrency.threads.numberstore1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        NumberStore n= new NumberStore();
        Thread t1 = new Thread(new Worker(n));
        Thread t2 = new Thread(new Worker(n));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(n.getX());
    }


}
