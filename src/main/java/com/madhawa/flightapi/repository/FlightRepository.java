package com.madhawa.flightapi.repository;

import com.madhawa.flightapi.domain.Flight;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, String> {
    List<Flight> findByFlightNumberAndDepartureDateGreaterThan(String flightNumber, LocalDate departureDate);
}