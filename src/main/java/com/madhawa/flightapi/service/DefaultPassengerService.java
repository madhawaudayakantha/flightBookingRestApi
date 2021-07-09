package com.madhawa.flightapi.service;

import com.madhawa.flightapi.domain.Booking;
import com.madhawa.flightapi.domain.Passenger;
import com.madhawa.flightapi.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DefaultPassengerService implements PassengerService{

    private PassengerRepository passengerRepository;

    @Autowired
    public DefaultPassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger getPassengerUsingId(String id) {
        return passengerRepository.findById(id).get();
    }

    @Override
    public List<Passenger> findAllByBookingId(Set<Booking> bookingIds) {
        return passengerRepository.findAllByBookingIds(bookingIds);
    }
}