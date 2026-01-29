package code.src.main.java.lld.examples.parkinglot.ticket;

import lld.examples.parkinglot.data.ParkingSpot;
import lld.examples.parkinglot.data.Ticket;
import lld.examples.parkinglot.data.Vehicle;

public class TicketGenerator {
    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot){
        String ticketNum=getUniqueTicketNum();
        return new Ticket(ticketNum, vehicle, parkingSpot);
    }


    //you can impress the interviwer, this random generator concept was
    //already done in ppa, do it while revising
    //also the suffle function which uses fisher-yale karke
    private String getUniqueTicketNum(){
        return "";
    }
}
