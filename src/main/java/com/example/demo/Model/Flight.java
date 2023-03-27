package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document("flights")
public class Flight {
    @Id
    private Integer id;
    private LocalDateTime begin;
    private LocalDateTime end;
    private String startingPlace;
    private String destination;
    private Integer maxSeats;
    private Integer takenSeats;
    private Float seatPrice;

    public Float PricePerPerson
    public Flight(Integer _id, LocalDateTime  Begin, LocalDateTime  end, String startingPlace, String destination, Integer maxSeats, float seatPrice) {
        this.id = _id;
        this.begin = Begin;
        this.end = end;
        this.startingPlace = startingPlace;
        this.destination = destination;
        this.maxSeats = maxSeats;
        this.seatPrice = seatPrice;
        this.takenSeats =0;
    }
    public Flight(Integer _id, LocalDateTime  Begin, LocalDateTime  end, String startingPlace, String destination, Integer maxSeats, float seatPrice, Integer takenSeats) {
        this.id = _id;
        this.begin = Begin;
        this.end = end;
        this.startingPlace = startingPlace;
        this.destination = destination;
        this.maxSeats = maxSeats;
        this.seatPrice = seatPrice;
        this.takenSeats =takenSeats;
    }

    public Flight() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = Id;
    }

    public LocalDateTime  getBegin() {
        return begin;
    }

    public void setBegin(LocalDateTime  begin) {
        this.begin = begin;
    }

    public LocalDateTime  getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime  end) {
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

    public Integer getTakenSeats() {
        return takenSeats;
    }

    public void setTakenSeats(Integer takenSeats) {
        this.takenSeats = takenSeats;
    }

    public float getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(float seatPrice) {
        this.seatPrice = seatPrice;
    }
}
