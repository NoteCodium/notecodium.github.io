package code.src.main.java.concurrency.producerconsumer;
// package CONCURRENCY.old;

public class Consumer implements Runnable{

    private final MyQueue queue;
    //doubt why final?
    //I think I undertood it 
    
    public Consumer(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            synchronized(queue){
                while(queue.isEmpty() && Tester.cntOfProducers>0){
                    try{
                        queue.wait();
                    }
                    catch(InterruptedException e){

                    }
                }
                if(Tester.cntOfProducers==0){
                    queue.notifyAll();
                    break;
                }

                int val=queue.pop();
                queue.notifyAll();
                System.out.println("Consumer consumed "+ val);
                if(val==-1){
                    Tester.cntOfProducers--;
                    break;
                }
            }

        }
        
    }
}
