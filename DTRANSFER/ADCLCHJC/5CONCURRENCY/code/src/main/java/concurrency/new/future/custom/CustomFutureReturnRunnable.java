package concurrencyrefractored.NEW.future.custom;

public class CustomFutureReturnRunnable implements Runnable{

    private String output;
    private boolean isDone;

    public CustomFutureReturnRunnable(){
        isDone=false;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        output="Done";
        isDone=true;
        // doubt in it


        // synchronized(this){
        //     try {
        //         Thread.sleep(2000);
        //     } catch (InterruptedException e) {
        //         throw new RuntimeException(e);
        //     }
        //     output = "Done";
        //     isDone = true;
        // }
        //how to sourround with brackets shortcut in intellij 


        //run method can never return a value
    }

    public String get(){
        while(!isDone){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return output;
    }

}
