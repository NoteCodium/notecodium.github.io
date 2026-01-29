// package CONCURRENCY.NEW.ThreadPool.server;
package concurrencyrefractored.NEW.ThreadPool.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Multithreaded server");
        MultiThreadedServer multiThreadedServer= new MultiThreadedServer();
        Random random= new Random();
        Map<Integer, FutureTask<Integer>> futureTasks= new HashMap<>();

        long start=System.currentTimeMillis();
        //////////////////////////////////////
        for(int i=0;i<5;i++){
            int qty=30000;
            List<Integer> v= new ArrayList<>();
            for(int j=0; j<qty;j++){
                v.add(random.nextInt(100,200));
            }
            int k=random.nextInt(200, 400);
            FutureTask<Integer> futureTask= multiThreadedServer.getPairCounter(v,k);
            //kind of we got the token for the future processing
            System.out.println("Process started for task "+(i+1));
            futureTasks.put(i+1, futureTask);
        }
        ///////////////////////////////////////
        long end=System.currentTimeMillis();
        System.out.println("multiThreadedServer response time: "+(end-start));


        start=System.currentTimeMillis();
        ///////////////////////////////////////
        //how to write custom implementation that whatever result is ready show it 
        for(int i=1;i<=5;i++){
            System.out.println("Result for task "+i+": "+futureTasks.get(i).get());
        }
        ///////////////////////////////////////
        end=System.currentTimeMillis();
        System.out.println("multiThreadedServer Processing time: "+(end-start));

        System.out.println("Single threaded server");
        SingleThreadedServer singleThreadedServer= new SingleThreadedServer();
        start=System.currentTimeMillis();
        ///////////////////////////////////////

        for(int i=0;i<5;i++){
            int qty=30000;
            List<Integer> v= new ArrayList<>();
            for(int j=0; j<qty;j++){
                v.add(random.nextInt(100,200));
            }
            int k=random.nextInt(200, 400);
            System.out.println("Process started for task "+(i+1));
            System.out.println(singleThreadedServer.getPairCounter(v,k));
        }
        ///////////////////////////////////////
        end=System.currentTimeMillis();
        System.out.println("singleThreadedServer response time: "+(end-start));



    }
}
