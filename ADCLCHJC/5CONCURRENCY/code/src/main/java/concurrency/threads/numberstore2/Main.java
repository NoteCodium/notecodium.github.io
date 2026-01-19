package code.src.main.java.concurrency.threads.numberstore2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        NumberStore n= new NumberStore();
        for(int i=0;i<100000;i++){
            Thread t=
                new Thread(new Worker(n));

            int curr=
                n.getW();

            t.start();
            //this will trigger this code
            // {
            //     x++;
            //     y++;
            //     z++;
            //     w++;
            // }

            while(curr==n.getW()){}

            if(n.getX()!=n.getY() || n.getY()!=n.getZ() || n.getZ()!=n.getW()){
                System.out.println(n.getX());
                System.out.println(n.getY());
                System.out.println(n.getZ());
                System.out.println(n.getW());
            }

            //so that main thread dont die?
            t.join();
        }
    }


}
