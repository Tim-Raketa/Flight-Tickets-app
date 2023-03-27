package com.example.demo.Controllers;
import com.example.demo.Model.Flight;
import com.example.demo.Model.User;
import com.example.demo.Repository.FlightRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping(value = "/MID", produces = MediaType.APPLICATION_JSON_VALUE)
public class PoroController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private FlightRepository flightRepository;
    @GetMapping("/addBook")
    public ResponseEntity<String> AddBook() {
        User user = new User("moc", "123","Bo", "Moc", "1231231231233");
        repository.save(user);

        Flight flight1=new Flight(1, LocalDateTime.now(),LocalDateTime.now().plusDays(2), "Belgrade","Split",100,6000);
        Flight flight2=new Flight(2, LocalDateTime.now(),LocalDateTime.now().plusDays(2), "Belgrade","Split",100,6000);

        repository.save(user);
        flightRepository.save(flight1);
        flightRepository.save(flight2);

        return new ResponseEntity<String>("Ok",HttpStatus.OK);
    }
    @GetMapping(value="/")
    public List<User> MID(){

        return repository.findAll();
    }
    @GetMapping(value="/xyz")
    public User Moc(){
        return repository.findBy("dsa");
    }

}
