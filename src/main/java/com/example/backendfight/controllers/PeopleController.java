package com.example.backendfight.controllers;

import com.example.backendfight.dtos.PeopleDto;
import com.example.backendfight.entities.People;
import com.example.backendfight.exceptions.AppInvalidRequestException;
import com.example.backendfight.exceptions.PeopleNotFoundExcpetion;
import com.example.backendfight.services.PeopleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class PeopleController {


    @Autowired
    private PeopleService service;

    @PostMapping("/peoples")
    public ResponseEntity<Object> fetchAllPeoples(@Valid @RequestBody PeopleDto peopleDto) throws AppInvalidRequestException {
        System.out.println(peopleDto.getSurName() instanceof String);

        People people = service.create(peopleDto);
        return ResponseEntity.created(URI.create("/peoples/" + people.getId())).build();
    }

    @GetMapping("/peoples/{id}")
    public ResponseEntity<People> fetchPeopleById(@PathVariable String id) throws PeopleNotFoundExcpetion {
        People people = service.getById(id);

        return ResponseEntity.ok(people);
    }

    @GetMapping("/peoples")
    public ResponseEntity<List<People>> fetchPeoples(@RequestParam(name = "t") Optional<String> term) {
        List<People> peoples;

        if(term.isEmpty()) {
            peoples =  service.listAll();
        } else {
            peoples = service.listAllBySlice(term.orElseThrow().toLowerCase());
        }

        return ResponseEntity.ok(peoples);
    }

    @GetMapping("/count-peoples")
    public ResponseEntity<Integer> countPeoples() {
        return  ResponseEntity.ok(service.countPeoples());
    }

}
