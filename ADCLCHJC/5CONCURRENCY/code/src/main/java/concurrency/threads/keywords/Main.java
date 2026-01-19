package code.src.main.java.concurrency.threads.keywords;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Object o= new Object();
        Thread wait1=new Thread(new Waiter(o));
        Thread wait2=new Thread(new Waiter(o));
        Thread notify=new Thread(new Notifier(o));
        wait1.start();
        wait2.start();
        Thread.sleep(500);
        //to make sure notify is started after wait
        notify.start();
    }
}
