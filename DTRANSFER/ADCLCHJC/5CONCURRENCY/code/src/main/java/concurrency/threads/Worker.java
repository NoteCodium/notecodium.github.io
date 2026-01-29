package code.src.main.java.concurrency.threads;
public class Worker implements Runnable{

    private final Number number;
    public Worker(Number number){
        this.number = number;
    }

    @Override
    public void run() {
        // int oldVal=number.getX();
        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }
        // number.setX(oldVal+1);
        

        number.increment();

        // for (int i = 0; i < 50000; i++) {
        //     number.increment();
        // }
        // for(int i=0;i<1000000000;i++){

        // }
        // System.out.println(Thread.currentThread().getName());
        // throw new RuntimeException();
    }   
}
