package code.src.main.java.lld.examples.parkinglot.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Ticket {
    private final String refNum;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
}
