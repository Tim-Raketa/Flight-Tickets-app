package com.example.demo.Model;

import com.example.demo.DTO.FlightDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document("flights")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Flight {

    @Transient
    public static final String SEQUENCE_NAME = "flight_sequence";

    @Id
    private Integer id;
    private LocalDateTime begin;
    private LocalDateTime end;
    private String startingPlace;
    private String destination;
    private Integer maxSeats;
    private Integer freeSeats;
    private Float seatPrice;

    public Float getTotalPrice(Integer numberOfPeople){
        return seatPrice*numberOfPeople;
    }
    public Integer TakenSeat( ){
        return maxSeats-freeSeats;
    }
    public void takeUpSeats(Integer numberOfPeople){
        freeSeats-=numberOfPeople;
    }
    public void freeUpSeats(Integer numberOfPeople){
        freeSeats+=numberOfPeople;
    }

    public Flight(Integer _id, LocalDateTime  Begin, LocalDateTime  end, String startingPlace, String destination, Integer maxSeats, float seatPrice) {
        this.id = _id;
        this.begin = Begin;
        this.end = end;
        this.startingPlace = startingPlace;
        this.destination = destination;
        this.maxSeats = maxSeats;
        this.seatPrice = seatPrice;
        this.freeSeats =0;
    }
    public Flight(Integer _id, LocalDateTime  Begin, LocalDateTime  end, String startingPlace, String destination, Integer maxSeats, float seatPrice, Integer freeSeats) {
        this.id = _id;
        this.begin = Begin;
        this.end = end;
        this.startingPlace = startingPlace;
        this.destination = destination;
        this.maxSeats = maxSeats;
        this.seatPrice = seatPrice;
        this.freeSeats =freeSeats;
    }


}
