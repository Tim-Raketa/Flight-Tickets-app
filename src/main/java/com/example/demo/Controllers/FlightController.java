package com.example.demo.Controllers;

import com.example.demo.DTO.FlightSearchDTO;
import com.example.demo.Model.Flight;
import com.example.demo.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Flights", produces = MediaType.APPLICATION_JSON_VALUE)
public class FlightController {
    @Autowired
    private FlightService flightService;
    @GetMapping(value="/")
    public List<Flight> GetAll(){
        return flightService.GetAll();
    }
    @PostMapping(value="/search",consumes = "application/json")
    public List<Flight> search(@RequestBody FlightSearchDTO details){
        return flightService.Search(details);
    }

}
