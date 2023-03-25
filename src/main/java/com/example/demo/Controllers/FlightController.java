package com.example.demo.Controllers;

import com.example.demo.Model.Flight;
import com.example.demo.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping(value="/search")
    public List<Flight> search(){
        return flightService.Search();
    }

}
