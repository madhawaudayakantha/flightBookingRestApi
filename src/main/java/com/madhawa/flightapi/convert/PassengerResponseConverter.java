package com.madhawa.flightapi.convert;

import com.madhawa.flightapi.domain.Booking;
import com.madhawa.flightapi.domain.Flight;
import com.madhawa.flightapi.domain.Passenger;
import com.madhawa.flightapi.domain.PassengerResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PassengerResponseConverter implements Converter<Passenger, PassengerResponse> {

	@Override
	public PassengerResponse convert(Passenger source) {
		Booking booking = source.getBooking();
		String bookingId= booking.getBookingId();
		List<Flight> flightList = booking.getFlightList();
		return new PassengerResponse(source, bookingId, flightList);
	}
}