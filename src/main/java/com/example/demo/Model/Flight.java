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
}
