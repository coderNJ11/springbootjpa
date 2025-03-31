package service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dto.FlightBookingAcknowledgement;
import dto.FlightBookingRequest;
import entity.PassengerInfo;
import entity.PaymentInfo;
import repository.PassengerInfoRepository;
import repository.PaymentInfoRepository;
import utils.PaymentUtils;

@Service
public class FlightBookinService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;


    @Transactional//(readOnly = false , isolation = Isolation.READ_COMMITTED , propagation = Propagation.MANDATORY)
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request){

        FlightBookingAcknowledgement flightBookingAcknowledgement = null;

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();
        PaymentUtils.validateCredentials( paymentInfo.getAccountNo(), passengerInfo.getFare());
        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfo = paymentInfoRepository.save(paymentInfo);


        return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare() , UUID.randomUUID().toString().split("-")[0], passengerInfo) ;

    }
}
