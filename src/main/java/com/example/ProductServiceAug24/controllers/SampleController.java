package com.example.ProductServiceAug24.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    //Endpoint name: GET /hello
    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }

    //Endpoint name: GET /hello/{name}
    @GetMapping("/hello/{name}")
    public String helloWithName(@PathVariable("name") String name){

        return "Hello " + name;
    }

    // GET /show/{showId}/seat/{seatId}
    @GetMapping("/show/{showId}/seat/{seatId}")
    public String bmsExample(@PathVariable("showId") String showId, @PathVariable("seatId") int seatId){
        return "Hello " + showId + " " + seatId;
    }
    // Break till 10.15 PM
}