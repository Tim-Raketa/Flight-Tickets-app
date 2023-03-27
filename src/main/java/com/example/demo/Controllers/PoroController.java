package com.example.demo.Controllers;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping(value = "/MID", produces = MediaType.APPLICATION_JSON_VALUE)
public class PoroController {
    @Autowired
    private UserRepository repository;
    @GetMapping("/addBook")
    public ResponseEntity<String> AddBook() {
        User user = new User("moc", "123","Bo", "Moc", "1231231231233");
        repository.save(user);
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
