package com.thackathon.mim.thk.controller;

import com.thackathon.mim.thk.entity.Person;
import com.thackathon.mim.thk.service.PersonService;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(@NonNull final PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        return ResponseEntity.ok(personService.getPerson(id));
    }
}
