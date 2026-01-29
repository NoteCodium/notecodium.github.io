package code.src.main.java.lld.examples.parkinglot.apis.FindParkingSpotAPI.finder;

import java.util.List;

import lld.examples.parkinglot.apis.FindParkingSpotAPI.selector.ParkingSpotSelector;
import lld.examples.parkinglot.manager.VehicleTypeManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ParkingSpotFinder {
    private final VehicleTypeManager vehicleTypeManager;
    private final ParkingSpotSelector parkingSpotSelector;

    public ParkingSpot findParkingSpot(){
        List<ParkingSpot> parkingSpots=
            vehicleTypeManager.getParkingSpots();
        return parkingSpotSelector.selectSpot(parkingSpots);
    }
    
}
