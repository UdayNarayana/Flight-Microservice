package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	Flight findByFlightId(int flghtId);
}
