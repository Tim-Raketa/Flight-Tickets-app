package com.example.demo.Service;

import com.example.demo.DTO.FlightDTO;
import com.example.demo.DTO.FlightSearchDTO;
import com.example.demo.Model.Flight;
import com.example.demo.Repository.FlightRepository;
import com.example.demo.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    public List<FlightDTO> Search(FlightSearchDTO details){
        LocalDateTime dateTime = details.getDate().atStartOfDay();

       List<Flight>flights= flightRepository.findByBeginIsBetweenAndDestinationIsContainingIgnoreCaseAndStartingPlaceIsContainingIgnoreCaseAndFreeSeatsLessThan
                (dateTime,dateTime.plusDays(1),details.getDestination(),details.getStartingLocation(),details.getNumberOfPeople() );
        return flightToDTO(flights,details.getNumberOfPeople());
    }
    public List<FlightDTO> flightToDTO(List<Flight> flights, Integer numberOfPeople){
        List<FlightDTO> flightsDTO=new ArrayList<>();
        for (Flight flight :flights) {
            flightsDTO.add(new FlightDTO(flight,numberOfPeople));
        }
        return flightsDTO;
    }
}
