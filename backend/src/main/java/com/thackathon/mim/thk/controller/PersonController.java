package com.thackathon.mim.thk.controller;

import com.thackathon.mim.thk.entity.Person;
import com.thackathon.mim.thk.service.PersonService;
import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(@NonNull final PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/login")
    public ResponseEntity<Person> login(@RequestParam String email, @RequestParam String password){
        return ResponseEntity.ok(personService.login(email, password));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        return ResponseEntity.ok(personService.getPerson(id));
    }

    @GetMapping("/findExperts")
    public ResponseEntity<List<Person>> findExperts(Pageable pageable, @RequestParam List<String> skills){
        return ResponseEntity.ok(personService.findExperts(pageable, skills));
    }
}
