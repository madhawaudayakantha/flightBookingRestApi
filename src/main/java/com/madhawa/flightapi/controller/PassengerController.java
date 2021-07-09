package com.madhawa.flightapi.controller;

import com.madhawa.flightapi.convert.PassengerByRelatedFightsResponseConverter;
import com.madhawa.flightapi.convert.PassengerResponseConverter;
import com.madhawa.flightapi.domain.Booking;
import com.madhawa.flightapi.domain.Flight;
import com.madhawa.flightapi.domain.Passenger;
import com.madhawa.flightapi.domain.PassengerForAFlightResponse;
import com.madhawa.flightapi.domain.PassengerResponse;
import com.madhawa.flightapi.service.FlightService;
import com.madhawa.flightapi.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("passengers")
public class PassengerController {
    
    @Autowired
    private PassengerResponseConverter passengerResponseConverter;

    @Autowired
    private PassengerByRelatedFightsResponseConverter passengerByRelatedFightsResponseConverter;
    
    @Autowired
    private PassengerService passengerService;

    @Autowired
    private FlightService flightService;
    
    @GetMapping("/{id}")
    public PassengerResponse getPassenger(@PathVariable("id") String id){
        System.out.println("Hello");
        Passenger passenger = passengerService.getPassengerUsingId(id);
        return passengerResponseConverter.convert(passenger);
    }

    @GetMapping
    public List<PassengerForAFlightResponse> getAllPassengersOnFlight(@RequestParam("flightNumber") String flightNumber,
                                                                      @RequestParam("departureDate") String departureDate) {
        System.out.println("Should search for All Passengers related to flight number: " + flightNumber
                + " after DepartureDate " + departureDate);
        Set<Booking> bookings = fetchBookingsAssociatedWithFlights(flightNumber, departureDate);
        List<Passenger> passengers = fetchAllPassengers(bookings);
        List<PassengerForAFlightResponse> passengerForAFlightResponses = new ArrayList<>();
        for (Passenger passenger : passengers) {
            PassengerForAFlightResponse passengerForAFlightResponse= passengerByRelatedFightsResponseConverter.
                    convert(passenger);
            passengerForAFlightResponses.add(passengerForAFlightResponse);
        }
        return passengerForAFlightResponses;
    }

    private Set<Booking> fetchBookingsAssociatedWithFlights(String flightNumber, String departureDate) {
        LocalDate parsedDepartureDate = parseLocalDate(departureDate);
        List<Flight> flights = flightService.findByFlightNumberAndDepartureDateGreaterThan(flightNumber,
                parsedDepartureDate);
        System.out.println("Fetched flight list size: " + flights.size());
        Set<Booking> bookings = new HashSet<>();
        for (Flight flight : flights) {
            bookings.addAll(flight.getBookingList());
        }
        return bookings;
    }

    private List<Passenger> fetchAllPassengers(Set<Booking> bookings) {
        List<Passenger> passengers = passengerService.findAllByBookingId(bookings);
        System.out.println("Fetched Passengers Size" + passengers.size());
        return passengers;
    }

    private LocalDate parseLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);        //convert String to LocalDate
    }
}