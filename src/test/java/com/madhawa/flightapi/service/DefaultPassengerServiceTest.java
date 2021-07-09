package com.madhawa.flightapi.service;

import com.madhawa.flightapi.domain.Booking;
import com.madhawa.flightapi.domain.Flight;
import com.madhawa.flightapi.domain.Passenger;
import com.madhawa.flightapi.repository.PassengerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DefaultPassengerServiceTest {

    @InjectMocks
    DefaultPassengerService defaultPassengerService;
    @Mock
    PassengerRepository passengerRepository;
    
    Passenger mockPassenger; 

    @Test
    void getPassenger() {
        Mockito.when(passengerRepository.findById(Mockito.anyString())).thenReturn(Optional.of(mockPassenger));
        Assertions.assertEquals(mockPassenger, defaultPassengerService.getPassengerUsingId("123"));
    }

    @BeforeEach
    void setUp() {
        mockPassenger= new Passenger("123", new Booking("231", Arrays.asList(new Flight(
                "","","",LocalDate.of(2019,2,12),
                LocalDate.of(2019,2,12)))), "213", "322", "332");
        MockitoAnnotations.initMocks(this);
    }
}