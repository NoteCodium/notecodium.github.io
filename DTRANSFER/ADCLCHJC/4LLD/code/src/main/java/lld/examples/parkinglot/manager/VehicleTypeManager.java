package code.src.main.java.lld.examples.parkinglot.manager;

import java.util.List;

import code.src.main.java.lld.examples.parkinglot.data.ParkingSpot;

public interface VehicleTypeManager {
    
    List<ParkingSpot> getParkingSpots();

    double getParkingFees(double durationInHours);

}
