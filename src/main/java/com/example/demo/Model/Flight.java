package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Document("flights")
public class Flight {
    @Id
    private Integer Id;
    private Date Begin;
    private Date End;
    private String StartingPlace;
    private String Destination;
    private Integer MaxSeats;
    private Integer TakenSeats;
    private float SeatPrice;

    public Flight(Integer id, Date begin, Date end, String startingPlace, String destination, Integer maxSeats, float seatPrice) {
        Id = id;
        Begin = begin;
        End = end;
        StartingPlace = startingPlace;
        Destination = destination;
        MaxSeats = maxSeats;
        SeatPrice = seatPrice;
        TakenSeats=0;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Date getBegin() {
        return Begin;
    }

    public void setBegin(Date begin) {
        Begin = begin;
    }

    public Date getEnd() {
        return End;
    }

    public void setEnd(Date end) {
        End = end;
    }

    public String getStartingPlace() {
        return StartingPlace;
    }

    public void setStartingPlace(String startingPlace) {
        StartingPlace = startingPlace;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public Integer getMaxSeats() {
        return MaxSeats;
    }

    public void setMaxSeats(Integer maxSeats) {
        MaxSeats = maxSeats;
    }

    public Integer getTakenSeats() {
        return TakenSeats;
    }

    public void setTakenSeats(Integer takenSeats) {
        TakenSeats = takenSeats;
    }

    public float getSeatPrice() {
        return SeatPrice;
    }

    public void setSeatPrice(float seatPrice) {
        SeatPrice = seatPrice;
    }
}
