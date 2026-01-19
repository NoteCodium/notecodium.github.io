package code.src.main.java.lld.examples.mcdonaldticketing;

import java.util.List;

public class TicketingBoard {
    private final List<Integer> appointments;
    private int curr;
    public TicketingBoard(List<Integer> appointments) {
        this.appointments = appointments;
        this.curr = 0;
    }
    
    public synchronized boolean isMyTurn(int appointmentId){
        //check happen that current is what
        //and during that time context switch happened
        if(curr==appointments.size()){
            throw new RuntimeException("No more appointments");
        }

        if(appointments.get(curr)!=appointmentId){
            return false;
        }
        curr++;
        return true;
    }

}
