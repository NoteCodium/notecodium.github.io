package code.src.main.java.lld.examples.parkinglot.apis.FindParkingSpotAPI.selector;

import lld.examples.parkinglot.data.EntryPoint;

public class SpotSelectionFactory {
    
    private SpotSelectionFactory(){}

    public static ParkingSpotSelector getNearestParkingSpotSelector(EntryPoint entryPoint){
        return new NearestSelector(entryPoint);
    }

    public static ParkingSpotSelector getRandomParkingSpotSelector(){
        return new RandomSelector();
    }    

}
