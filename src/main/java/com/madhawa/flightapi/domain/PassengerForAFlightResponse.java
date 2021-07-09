package com.madhawa.flightapi.domain;

//This will be the customized response object for a Passenger related with flights
public class PassengerForAFlightResponse {

    private String passengerId;
    private String firstName;
    private String lastName;
    private String email;
    private String bookingId;
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public PassengerForAFlightResponse() {
    }

    public PassengerForAFlightResponse(Passenger passenger, String bookingId) {
        this.passengerId = passenger.getPassengerId();
        this.firstName = passenger.getFirstName();
        this.lastName = passenger.getLastName();
        this.email = passenger.getEmail();
        this.bookingId = bookingId;
    }
}