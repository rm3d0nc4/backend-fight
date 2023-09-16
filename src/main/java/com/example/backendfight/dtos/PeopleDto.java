package com.example.backendfight.dtos;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter

public class PeopleDto {
    @Valid
    private String name;
    @Valid
    private String surName;
    @Valid
    private String birth;
    private List<String> stack;
}
