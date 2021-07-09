package com.madhawa.flightapi.service;

import com.madhawa.flightapi.domain.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    List<Flight> findByFlightNumberAndDepartureDateGreaterThan(String flightNumber, LocalDate departureDate);
}