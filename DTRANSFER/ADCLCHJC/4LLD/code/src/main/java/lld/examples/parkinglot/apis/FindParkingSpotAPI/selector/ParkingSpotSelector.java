package code.src.main.java.lld.examples.parkinglot.apis.FindParkingSpotAPI.selector;

import java.util.List;

public interface ParkingSpotSelector {
    ParkingSpot selectSpot(List<ParkingSpot> parkingSpots);
}
