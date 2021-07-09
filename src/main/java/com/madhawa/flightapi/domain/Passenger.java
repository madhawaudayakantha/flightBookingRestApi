package com.madhawa.flightapi.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Passenger {

    public Passenger() {
        super();
    }

    public Passenger(String passengerId, Booking booking, String firstName, String lastName, String email) {
        super();
        this.passengerId = passengerId;
        this.booking = booking;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Id
    @GeneratedValue
    private String passengerId;
    @ManyToOne(fetch = FetchType.EAGER)
    private Booking booking;

    private String firstName;

    private String lastName;

    private String email;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Passenger [passengerId=" + passengerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }
}