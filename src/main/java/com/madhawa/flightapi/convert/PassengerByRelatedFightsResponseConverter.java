package com.madhawa.flightapi.convert;

import com.madhawa.flightapi.domain.Booking;
import com.madhawa.flightapi.domain.Passenger;
import com.madhawa.flightapi.domain.PassengerForAFlightResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PassengerByRelatedFightsResponseConverter implements Converter<Passenger, PassengerForAFlightResponse> {

    @Override
    public PassengerForAFlightResponse convert(Passenger source) {
        Booking booking = source.getBooking();
        String bookingId = booking.getBookingId();
        return new PassengerForAFlightResponse(source, bookingId);
    }
}