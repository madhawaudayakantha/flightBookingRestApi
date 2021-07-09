package com.madhawa.flightapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Booking {

    public Booking() {
        super();
    }

    public Booking(String bookingId, List<Flight> flightList) {
        super();
        this.bookingId = bookingId;
        this.flightList = flightList;
    }

    @Id
    @Column(length = 6)
    @GeneratedValue
    private String bookingId;
    
    @ManyToMany( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable
    @JsonIgnore
    private List<Flight> flightList;

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }


    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + "]";
    }
}