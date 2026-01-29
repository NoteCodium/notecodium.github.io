package code.src.main.java.concurrency.threads.synchronise.specialseries;

public class Odd implements Runnable{
    private final Object o;
    public Odd(Object o){
        this.o=o;
    }
    // public static boolean zeroTurn=true;
    // public static int natNum=1;
    @Override
    public void run() {
        synchronized(o){
            while(Tester.natNum<=Tester.n){
                while(!(!Tester.zeroTurn && Tester.natNum%2!=0) && Tester.natNum<=Tester.n){
                        try{
                            o.wait();
                        }catch(InterruptedException e){

                        }
                        if(Test.natNum>Test.n){
                            o.notifyAll();
                            break;
                        }
                        System.out.println(Test.curr);
                        Tester.zeroTurn=true;
                        Tester.natNum++;
                        o.notifyAll();
                    }
                }
            }
    }
    
}
