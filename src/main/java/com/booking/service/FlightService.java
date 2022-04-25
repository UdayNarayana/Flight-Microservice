package com.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.model.Flight;
import com.booking.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	public String addOneFlight(Flight flight) {
		flightRepository.save(flight);
		return "Flight with ID "+flight.getFlightId()+" has been added.";
	}
	
	public Flight getFlightByFlightId(int flightId){
		return flightRepository.findByFlightId(flightId);
	}

	public List<Flight> getAllFlightDetails(){
		return flightRepository.findAll();
	}
	
	public String deleteByFlightId(int flightId) {
		flightRepository.deleteById(flightId);
		return "Flight with ID "+flightId+" has been deleted.";
	}
	
	public String deleteAllFlightDetails() {
		flightRepository.deleteAll();
		return "All the flight details are deleted.";
	}

	public Flight updateFlightDetail(Flight flight) {
		return flightRepository.saveAndFlush(flight);
	}
	
}
