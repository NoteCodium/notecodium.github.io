package code.src.main.java.concurrency.threads.synchronise;

public class Worker implements Runnable{
    public final int val;
    private final Object o;
    public Worker(int val, Object o){
        this.val=val;
        this.o=o;
    }
    @Override
    public void run() {
        synchronized(o){
            // synchronized(o){
            //     while(val> Main.curr){}
            // }
            // while(compare()){}
            while(val> Main.curr){
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
            }
            //thread doing something else if it is not its turn
            System.out.println(val);
            // synchronized(o){
            //     Main.curr++;
            // }
            Main.curr++;
            o.notifyAll();
        }    



    }

    // private boolean compare(){
    //     boolean ans=false;
    //     synchronized(o){
    //         ans=val>Main.curr;
    //     }
    //     return ans;
    // }


}
