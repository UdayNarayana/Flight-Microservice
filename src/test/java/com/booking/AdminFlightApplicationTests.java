package com.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.booking.model.Flight;
import com.booking.repository.FlightRepository;
import com.booking.service.FlightService;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminFlightApplicationTests {

	@Autowired
	FlightService flightService;
	
	@MockBean
	FlightRepository flightRepository;
	
	
	@Test
	void testGetAllFlightDetails() {
		Mockito.when(flightRepository.findAll()).thenReturn(Stream.of(
				 new Flight(1,"Delhi","Bangalore","Indigo","A320",120),
				 new Flight(2,"Delhi","Bangalore","Indigo","A320",120))
				 .collect(Collectors.toList()));
		assertEquals(2,flightService.getAllFlightDetails().size());
	}
	
	@Test
	void testGetFlightByFlightId() {
		Flight flight = new Flight(1,"Delhi","Bangalore","Indigo","A320",120);
		Mockito.when(flightRepository.findByFlightId(1)).thenReturn(flight);
		assertEquals(flight,flightService.getFlightByFlightId(1));
	}
	
	@Test
	void testAddFlight() {
		Flight flight = new Flight(1,"Bangalore","Delhi","Indigo","A320",120);
		Mockito.when(flightRepository.save(flight)).thenReturn(flight);
		assertEquals("Flight with ID "+flight.getFlightId()+" has been added.",
					 flightService.addOneFlight(flight));
	}
	
	@Test
	void testUpdateFlight() {
		Flight flight = new Flight(1,"Bangalore","Delhi","Indigo","A320",120);
		Mockito.when(flightRepository.saveAndFlush(flight)).thenReturn(flight);
		assertEquals(flightRepository.saveAndFlush(flight),
					 flightService.updateFlightDetail(flight));
	}
	
	@Test
	void testDeleteByFlightId() {
		Flight flight = new Flight(1,"Bangalore","Delhi","Indigo","A320",120);
		int flightId=flight.getFlightId();
		assertEquals("Flight with ID "+flightId+" has been deleted.",
					 flightService.deleteByFlightId(1));
	}
	
	@Test
	void testDeleteAllflightDetails() {
		assertEquals("All the flight details are deleted.",
					 flightService.deleteAllFlightDetails());
	}
	
	@Test
	void testNoSuchFlightIdException() {
		Flight flight = new Flight(1,"Bangalore","Delhi","Indigo","A320",120);
		flightService.addOneFlight(flight);
		assertEquals(null,flightService.getFlightByFlightId(2));
	}
	
	@Test
	void testNoDataFoundException() {
		Flight flight1 = new Flight(1,"Bangalore","Delhi","Indigo","A320",120);
		Flight flight2 = new Flight(2,"Chennai","Mumbai","Spicejet","737-800",117);
		flightRepository.save(flight1);
		flightRepository.save(flight2);
		flightRepository.deleteAll();
		assertEquals(0,flightService.getAllFlightDetails().size());
	}
	
}
