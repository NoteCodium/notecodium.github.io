package code.src.main.java.lld.examples.parkinglot.apis.FindParkingSpotAPI;

import lld.examples.parkinglot.apis.FindParkingSpotAPI.finder.ParkingSpotFinder;
import lld.examples.parkinglot.apis.FindParkingSpotAPI.selector.ParkingSpotSelector;
import lld.examples.parkinglot.apis.FindParkingSpotAPI.selector.SpotSelectionFactory;
import lld.examples.parkinglot.data.EntryPoint;
import lld.examples.parkinglot.data.SpotSelection;
import lld.examples.parkinglot.data.VehicleType;
import lld.examples.parkinglot.manager.VehicleTypeManager;
import lld.examples.parkinglot.manager.VehicleTypeManagerFactory;

public class FindParkingSpotAPI {
    public ParkingSpot findParkingSpot(
        EntryPoint entryPoint,
        VehicleType vehicleType,
        SpotSelection spotSelection
    ){
        //avoiding if else and different writing different queries imn it 
        VehicleTypeManager vehicleTypeManager=
            VehicleTypeManagerFactory.getVehicleTypeManager(vehicleType);

        //delaying if checks on as top as possible,  having them at api level is ok
        ParkingSpotSelector parkingSpotSelector;
        if(spotSelection.equals(SpotSelection.NEAREST)){
            parkingSpotSelector=SpotSelectionFactory.getNearestParkingSpotSelector(entryPoint);
        }
        else if(spotSelection.equals(SpotSelection.RANDOM)){
            parkingSpotSelector=SpotSelectionFactory.getRandomParkingSpotSelector();
        }
        else{
            throw new RuntimeException();
        }
        // return parkingSpotSelector.selectSpot(vehicleTypeManager.getParkingSpots());
        //strategy * vehicles
        //for this line of code only we created whole class and done all the jhanjhat 

        return new ParkingSpotFinder(vehicleTypeManager, parkingSpotSelector).findParkingSpot();

    }

}
