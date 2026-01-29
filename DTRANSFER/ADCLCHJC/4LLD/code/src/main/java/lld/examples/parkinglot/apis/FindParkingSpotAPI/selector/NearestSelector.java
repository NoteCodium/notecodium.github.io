package code.src.main.java.lld.examples.parkinglot.apis.FindParkingSpotAPI.selector;

import java.util.List;

import lld.examples.parkinglot.data.EntryPoint;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NearestSelector implements ParkingSpotSelector{

//the difference from RandomSelector
    private final EntryPoint entryPoint;

    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> parkingSpots) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectSpot'");
    }
    
}
