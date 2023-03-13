package com.example.demo;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping(value = "/MID", produces = MediaType.APPLICATION_JSON_VALUE)
public class PoroController {
    @GetMapping(value="/")
    public ResponseEntity<String> MID(){
        return new ResponseEntity<String>("mid",HttpStatus.OK);
    }
}
