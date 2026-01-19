package code.src.main.java.concurrency.threads;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Number n= new Number();
        Thread t1 = new Thread(new Worker(n));
        Thread t2 = new Thread(new Worker(n));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(n.getX());

        // Worker w=new Worker();
        // Thread t=new Thread(w);
        // try {
        //     t.start();
        //     Thread.sleep(2000);
        // } catch (Exception e) {
        //     System.out.println("Caught");
        // }
        // System.out.println(Thread.currentThread().getName());


    }
}