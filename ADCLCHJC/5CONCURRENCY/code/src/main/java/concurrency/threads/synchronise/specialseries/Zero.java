package code.src.main.java.concurrency.threads.synchronise.specialseries;

public class Zero implements Runnable{

    // public static boolean zeroTurn=true;
    // public static int natNum=1;

    private final Object o;
    public Zero(Object o){
        this.o=o;
    }
    // public static int curr=0, natNum=1;
    @Override
    public void run(){
        synchronized(o){
            while(Tester.natNum<=Tester.n){
                while(!Tester.zeroTurn && Tester.natNum<=Tester.n){
                    try{
                        o.wait();
                    }
                    catch(InterruptedException e){

                    }
                }
                if(Test.natNum>Test.n){
                    o.notifyAll();
                    break;
                }
                System.out.println(0);
                Tester.zeroTurn=false;
                o.notifyAll();
            }
        }

    }
    
}
