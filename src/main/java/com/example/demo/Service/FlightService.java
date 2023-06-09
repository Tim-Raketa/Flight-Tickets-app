package com.example.demo.Service;

import com.example.demo.DTO.FlightDTO;
import com.example.demo.DTO.FlightSearchDTO;
import com.example.demo.DTO.FlightShowDTO;
import com.example.demo.DTO.NewTicketDTO;
import com.example.demo.Model.Flight;
import com.example.demo.Model.Ticket;
import com.example.demo.Repository.FlightRepository;
import com.example.demo.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<FlightShowDTO> GetAll(){
        return convertForShowAll(flightRepository.findAll());
    }

    public Optional<Flight> findById(Integer id){
        return flightRepository.findById(id);
    }

    public Flight createFlight(Flight newFlight){
        return flightRepository.save(newFlight);
    }

    public void deleteFlight(Integer id){
        flightRepository.deleteById(id);
    }

    public List<FlightDTO> Search(FlightSearchDTO details){
        LocalDateTime dateTime = details.getDate().atStartOfDay();

       List<Flight>flights= flightRepository.findByBeginIsBetweenAndDestinationIsContainingIgnoreCaseAndStartingPlaceIsContainingIgnoreCaseAndFreeSeatsGreaterThan
                (dateTime,dateTime.plusDays(1),details.getDestination(),details.getStartingLocation(),details.getNumberOfPeople() );
        return flightToDTO(flights,details.getNumberOfPeople());
    }
    public List<FlightDTO> flightToDTO(List<Flight> flights, Integer numberOfPeople) {
        List<FlightDTO> flightsDTO = new ArrayList<>();
        for (Flight flight : flights) {
            flightsDTO.add(new FlightDTO(flight, numberOfPeople));
        }
        return flightsDTO;
    }
    public List<FlightShowDTO> convertForShowAll(List<Flight> flights) {
        List<FlightShowDTO> flightsDTO = new ArrayList<>();
        for (Flight flight : flights) {
            flightsDTO.add(new FlightShowDTO(flight));
        }
        return flightsDTO;
    }

}
