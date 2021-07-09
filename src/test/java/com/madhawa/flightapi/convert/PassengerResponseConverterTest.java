package com.madhawa.flightapi.convert;

import com.madhawa.flightapi.domain.Booking;
import com.madhawa.flightapi.domain.Flight;
import com.madhawa.flightapi.domain.Passenger;
import com.madhawa.flightapi.domain.PassengerResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PassengerResponseConverterTest {

    Passenger passenger;
    @BeforeEach
    void init(){
        Flight flight= new Flight("123", "123", "abc", LocalDate.of(
                2019,2,12),
                LocalDate.of(2019,2,12));
        List<Flight> flightList = Arrays.asList(flight);
        Booking booking = new Booking("123", flightList);
        passenger = new Passenger("123", booking,  "Lokesh", "Gupta", 
                "howtodoinjava@gmail.com");
    }

    @Test
    void convertToResponse() {
        PassengerResponse passengerResponse = new PassengerResponseConverter().convert(passenger);
        Assertions.assertEquals(passengerResponse.getBookingId(), "123");
        Assertions.assertEquals(passengerResponse.getFirstName(), "Lokesh");
        Assertions.assertEquals(passengerResponse.getPassengerId(), "123");
    }
}