package com.example.backendfight.services;

import com.example.backendfight.dtos.PeopleDto;
import com.example.backendfight.entities.People;
import com.example.backendfight.exceptions.AppInvalidRequestException;
import com.example.backendfight.exceptions.PeopleNotFoundExcpetion;
import com.example.backendfight.providers.UlidProvider;
import com.example.backendfight.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository repository;

    @Autowired
    private UlidProvider ulidProvider;


    public People create(PeopleDto peopleDto) throws AppInvalidRequestException {
        if(!this.findBySurName(peopleDto.getSurName()).isEmpty()) {
            throw new AppInvalidRequestException("Surname in use", 422);
        }
        People people = new People(
                ulidProvider.getUlid(),
                peopleDto.getName(),
                peopleDto.getSurName(),
                peopleDto.getBirth(),
                peopleDto.getStack()
        );
        repository.save(people);
        return people;
    }

    private List<People> findBySurName(String surName) {
        return repository.findBySurName(surName);
    }

    public People getById(String id) throws PeopleNotFoundExcpetion {
        Optional<People> people = repository.findById(id);
        if (people.isEmpty()) {
            throw  new PeopleNotFoundExcpetion("People not found", 404);
        }
        return people.get();
    }


    public int countPeoples() {
        return repository.findAll().size();
    }

    public List<People> listAll() {
        return  repository.findAll().stream().toList();
    }

    public List<People> listAllBySlice(String slice) {
        return repository
                .findAll()
                .stream()
                .filter(people -> people.getName().toLowerCase().contains(slice) | people.getSurName().toLowerCase().contains(slice) | people.getStack().contains(slice))
                .toList();
    }


}
