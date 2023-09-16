package com.example.backendfight.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "peoples")
@Entity
@Getter
@Setter
@AllArgsConstructor
public class People {
    @Id
    @NotNull
    @Column(name = "id")
    private String id;
    @NotNull
    @Column(name = "name")
    @Size(max = 100)
    private String name;
    @NotNull
    @Size(max = 32)
    @Column(name = "surname")
    private String surName;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "birth")
    private String birth;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "people_stack", joinColumns = @JoinColumn(referencedColumnName = "id"))
    @Column(name = "stack_item", length = 32)
    private List<String> stack;

    public People() {

    }
}