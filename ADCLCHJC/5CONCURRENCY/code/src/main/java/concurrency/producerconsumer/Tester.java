package code.src.main.java.concurrency.producerconsumer;
// package CONCURRENCY.old;

// import CONCURRENCY.old.MyQueue;
// import CONCURRENCY.old.Producer;


public class Tester {

    public static int cntOfProducers=2;

    public static void main(String[] args) {
        MyQueue queue=
            new MyQueue(50);

        Thread producer1= new Thread(new Producer(queue));
        Thread producer2= new Thread(new Producer(queue));

        Thread consumer1=new Thread(new Consumer(queue));
        Thread consumer2=new Thread(new Consumer(queue));
        Thread consumer3=new Thread(new Consumer(queue));

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();

    }
}
