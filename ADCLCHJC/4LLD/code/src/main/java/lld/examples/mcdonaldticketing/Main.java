package code.src.main.java.lld.examples.mcdonaldticketing;

import java.util.ArrayList;
import java.util.List;

import examplesRefractor.mcdonaldticketing.workers.Customer;

public class Main {
    public static void main(String[] args) {
        //Array of Workers
        List<Customer> customers=
            new ArrayList<>();

        //make it global somehow
        List<Integer> appointments=
            new ArrayList<>();

        //using shuffling algorithm in future
        for(int i=0;i<10;i++){
            appointments.add(i);
        }
        
        // System.out.println(appointments);

        TicketingBoard ticketingBoard=
            new TicketingBoard(appointments);
            
        for(int i=0;i<10;i++){
            customers.add(new Customer(i,ticketingBoard));
        }

        for(Customer c:customers){
            new Thread(c).start();
        }

    }
}
