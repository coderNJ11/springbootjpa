package com.springbootjpa.springbootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.FlightBookingAcknowledgement;
import dto.FlightBookingRequest;
import service.FlightBookinService;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class FlightService {

	@Autowired
	private FlightBookinService fliBookinService;

	@PostMapping("/bookflight")
	public FlightBookingAcknowledgement bookingAcknowledgement(@RequestBody FlightBookingRequest flightBookingRequest){
		return fliBookinService.bookFlightTicket(flightBookingRequest);
	}



	public static void main(String[] args) {
		SpringApplication.run(FlightService.class, args);
	}

}
