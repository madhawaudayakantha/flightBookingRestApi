package com.madhawa.flightapi.service;

import com.madhawa.flightapi.domain.Flight;
import com.madhawa.flightapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DefaultFlightService implements FlightService {

    private FlightRepository flightRepository;

    @Autowired
    public DefaultFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> findByFlightNumberAndDepartureDateGreaterThan(String flightNumber, LocalDate departureDate) {
        return flightRepository.findByFlightNumberAndDepartureDateGreaterThan(flightNumber, departureDate);
    }
}