// Suggested code may be subject to a license. Learn more: ~LicenseLog:3601794993.
// Suggested code may be subject to a license. Learn more: ~LicenseLog:964960135.
package code.src.main.java.concurrency.threads.synchronise;

public class Main {
    public static int curr=1;
    public static void main(String[] args) {
        Object o= new Object();
        Thread t1= new Thread(new Worker(1,o));
        Thread t2= new Thread(new Worker(2,o));
        Thread t3= new Thread(new Worker(3,o));
        Thread t4= new Thread(new Worker(4,o));
        Thread t5= new Thread(new Worker(5,o));
        Thread t6= new Thread(new Worker(6,o));
        Thread t7= new Thread(new Worker(7,o));
        Thread t8= new Thread(new Worker(8,o));
        Thread t9= new Thread(new Worker(9,o));
        Thread t10= new Thread(new Worker(10,o));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
}
