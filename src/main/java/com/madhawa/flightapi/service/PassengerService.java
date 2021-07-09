package com.madhawa.flightapi.service;

import com.madhawa.flightapi.domain.Booking;
import com.madhawa.flightapi.domain.Passenger;

import java.util.List;
import java.util.Set;

public interface PassengerService {
    Passenger getPassengerUsingId(String id);
    List<Passenger> findAllByBookingId(Set<Booking> bookingIds);
}