package com.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="flight")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="flight_id")
	private int flightId;

	@NotEmpty
	@Column(name="arrival_location")
	private String arrivalLoc;

	@NotEmpty
	@Column(name="departure_location")
	private String departureLoc;

	@NotEmpty
	@Column(name="fleet_name")
	private String fleetName;

	@NotEmpty
	@Column(name="model")
	private String model;

	@NotNull
	@Column(name="remaining_seats")
	private Integer remainingSeats;
	
}
