package com.example.backendfight.repositories;

import com.example.backendfight.entities.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, String> {

    public List<People> findBySurName(String surName);
}
