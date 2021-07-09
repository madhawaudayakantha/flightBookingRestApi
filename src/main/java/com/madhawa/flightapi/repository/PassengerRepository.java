package com.madhawa.flightapi.repository;

import com.madhawa.flightapi.domain.Booking;
import com.madhawa.flightapi.domain.Passenger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface PassengerRepository extends CrudRepository<Passenger, String> {
    @Query("SELECT n FROM Passenger n WHERE n.booking IN ?1")     
    List<Passenger> findAllByBookingIds(Set<Booking> bookingIds);
}