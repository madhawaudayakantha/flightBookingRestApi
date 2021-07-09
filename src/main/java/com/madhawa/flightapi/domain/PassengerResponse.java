package com.madhawa.flightapi.domain;

import java.util.List;

//This will be the customized response object for Passenger
public class PassengerResponse {

    private String passengerId;

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    private String firstName;
    private String lastName;
    private String bookingId;
    private List<Flight> flights;

    public PassengerResponse() {
    }

    public PassengerResponse(Passenger passenger, String bookingId, List<Flight> flights) {
        this.passengerId = passenger.getPassengerId();
        this.firstName = passenger.getFirstName();
        this.lastName = passenger.getLastName();
        this.bookingId = bookingId;
        this.flights = flights;
    }
}