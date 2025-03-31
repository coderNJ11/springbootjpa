package dto;

import entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingAcknowledgement {
   
    private String status;

    private Double totalFare;

    private String prnNo;

    private PassengerInfo passengerInfo;

}
