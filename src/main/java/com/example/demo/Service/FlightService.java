package com.example.demo.Service;

import com.example.demo.DTO.FlightSearchDTO;
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
    public List<Flight> Search(FlightSearchDTO details){
        LocalDateTime dateTime = details.getDate().atStartOfDay();

        return flightRepository.findByBeginIsBetweenAndDestinationIsContainingIgnoreCaseAndStartingPlaceIsContainingIgnoreCaseAndTakenSeatsLessThan
                (dateTime,dateTime.plusDays(1),details.getDestination(),details.getStartingLocation(),details.getNumberOfPeople() );
    }
}
