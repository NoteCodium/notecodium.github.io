package code.src.main.java.lld.examples.mcdonaldticketing.workers;

import examplesRefractor.mcdonaldticketing.TicketingBoard;


//each customer is a separate thread
//we will launch all these workers separately
public class Customer implements Runnable{
    private final int appointmentId;
    private final TicketingBoard ticketingBoard;

    public Customer(int appointmentId, TicketingBoard ticketingBoard) {
        this.appointmentId = appointmentId;
        this.ticketingBoard = ticketingBoard;
    }

    @Override
    public void run() {
        synchronized(ticketingBoard){
            //the thread will keep on running at this place
            //untill it get access ahead in the firstiteration
            while(!ticketingBoard.isMyTurn(appointmentId)){
                System.out.println(appointmentId+" denied entry");
                try {
                    ticketingBoard.wait();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(appointmentId+" got entry");
            ticketingBoard.notifyAll();
        }

    }
}
