package code.src.main.java.lld.examples.parkinglot.data;

// import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ParkingSpot {
    private final String floorNum;
    private final VehicleType vehicleType;
    private final String name;
    private boolean isFree;  
}
