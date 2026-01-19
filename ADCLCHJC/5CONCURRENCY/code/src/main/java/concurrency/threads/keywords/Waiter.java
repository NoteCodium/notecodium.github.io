package code.src.main.java.concurrency.threads.keywords;

public class Waiter implements Runnable {
    private final Object o;
    public Waiter(Object o){
        this.o=o;
    }
    @Override
    public void run() {
        synchronized(o){
            try{
                System.out.println("Hello Waiter");
                o.wait();
            }
            catch(InterruptedException e){

            }
            System.out.println("Bye Waiter");

        }
    }
}
