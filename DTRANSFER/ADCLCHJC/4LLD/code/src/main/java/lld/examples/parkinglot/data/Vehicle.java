package code.src.main.java.lld.examples.parkinglot.data;

import java.time.LocalDateTime;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Vehicle {
    private final String name;
    private final VehicleType vehicleType;
    private final String number;
    private final LocalDateTime entryTime;
   
}
