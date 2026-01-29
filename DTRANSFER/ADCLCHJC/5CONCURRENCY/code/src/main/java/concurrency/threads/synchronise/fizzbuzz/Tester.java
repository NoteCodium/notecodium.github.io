package code.src.main.java.concurrency.threads.synchronise.fizzbuzz;

public class Tester {
    public static final int n=15;
    public static int i=1;
    public static void main(String[] args) {
        Object o= new Object();
        Thread fizz= new Thread(new Fizz(o));
        Thread buzz= new Thread(new Buzz(o));
        Thread fizzbuzz= new Thread(new FizzBuzz(o));
        Thread plain= new Thread(new Plain(o));
        fizz.start();
        buzz.start();
        fizzbuzz.start();
        plain.start();
    }
}
