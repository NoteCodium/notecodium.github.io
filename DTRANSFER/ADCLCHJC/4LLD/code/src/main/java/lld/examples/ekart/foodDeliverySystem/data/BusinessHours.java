package code.src.main.java.lld.examples.ekart.foodDeliverySystem.data;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BusinessHours {
    //DOIT
    //what is the differene in between all the time data types
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
}
