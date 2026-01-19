package code.src.main.java.concurrency.threads.synchronise.specialseries;

public class Tester {
    public static final int n=4;
    public static boolean zeroTurn=true;
    public static int natNum=1;
    public static void main(String[] args) {
        Object o= new Object();
        Thread zero= new Thread(new Zero(o));
        Thread odd= new Thread(new Odd(o));
        Thread even= new Thread(new Even(o));;
        zero.start();
        odd.start();
        even.start();
    }
}
