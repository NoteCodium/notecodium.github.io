package code.src.main.java.lld.examples.parkinglot.manager;

import lld.examples.parkinglot.data.VehicleType;

public class VehicleTypeManagerFactory {
    private VehicleTypeManagerFactory(){}

    public static VehicleTypeManager getVehicleTypeManager(VehicleType vehicleType){
        VehicleTypeManager vehicleTypeManager;
        if(vehicleType.equals(VehicleType.TWO_WHEELER)){
            vehicleTypeManager=new TwoWheelerManager();
        }
        else{
            vehicleTypeManager=new TwoWheelerManager();            
        }
        return vehicleTypeManager;
    }


}
