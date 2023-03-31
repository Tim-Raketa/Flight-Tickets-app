package com.example.demo.Controllers;

import com.example.demo.DTO.FlightDTO;
import com.example.demo.DTO.FlightSearchDTO;
import com.example.demo.DTO.FlightShowDTO;
import com.example.demo.DTO.NewTicketDTO;
import com.example.demo.Model.Flight;
import com.example.demo.Model.Ticket;
import com.example.demo.Service.FlightService;
import com.example.demo.Service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.Model.Flight.SEQUENCE_NAME;

@RestController
@RequestMapping(value = "/Flights", produces = MediaType.APPLICATION_JSON_VALUE)
public class FlightController {
    @Autowired
    private FlightService flightService;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping(value="/getAll")
    public ResponseEntity<List<FlightShowDTO>> GetAll(){
        return new ResponseEntity<List<FlightShowDTO>>(flightService.GetAll(), HttpStatus.OK);
    }
    @PostMapping(value="/search",consumes = "application/json")
    public List<FlightDTO> search(@RequestBody FlightSearchDTO details){
        return flightService.Search(details);
    }

    @PostMapping("/addFlight")
    public String createFlight(@RequestBody Flight newFlight){
        newFlight.setId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
        flightService.createFlight(newFlight);
        return "Added flight with id: " + newFlight.getId();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Integer id){
        Flight flight = flightService.findById(id).orElse(null);
        if(flight == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            flightService.deleteFlight(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
