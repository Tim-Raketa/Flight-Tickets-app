package com.example.demo.DTO;

import com.example.demo.Model.Flight;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
public class FlightShowDTO {
    private Integer id;
    private String begin;
    private String end;
    private String startingPlace;
    private String destination;
    private Integer maxSeats;
    private Integer freeSeats;
    private Float seatPrice;

    public FlightShowDTO(Flight flight) {
        this.id=flight.getId();
        this.begin = flight.getBegin().toString();
        this.end = flight.getEnd().toString();
        this.startingPlace=flight.getStartingPlace();
        this.destination=flight.getDestination();
        this.maxSeats=flight.getMaxSeats();
        this.freeSeats=flight.getFreeSeats();
        this.seatPrice=flight.getSeatPrice();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStartingPlace() {
        return startingPlace;
    }

    public void setStartingPlace(String startingPlace) {
        this.startingPlace = startingPlace;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(Integer maxSeats) {
        this.maxSeats = maxSeats;
    }

    public Integer getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(Integer freeSeats) {
        this.freeSeats = freeSeats;
    }

    public Float getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(Float seatPrice) {
        this.seatPrice = seatPrice;
    }
}
