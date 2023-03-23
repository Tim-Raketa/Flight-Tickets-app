package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tickets")
public class Ticket {
    @Id
    private Integer Id;
    private Flight Flight;
    private User User;
    private Integer NumberOfSeats;
}
