package com.example.demo.Service;

import com.example.demo.Model.Flight;
import com.example.demo.Repository.FlightRepository;
import com.example.demo.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private TicketRepository ticketRepository;

    public List<Flight> GetAll(){
        return flightRepository.findAll();
    }
    public List<Flight> Search(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse("2023-03-24 00:00:00", formatter);
        LocalDateTime dateTime2= dateTime1;

        return flightRepository.findByBeginIsBetweenAndDestinationIsContainingIgnoreCaseAndStartingPlaceIsContainingIgnoreCaseAndTakenSeatsLessThan
                (dateTime1,dateTime2.plusDays(3),"","",89 );
    }
}
