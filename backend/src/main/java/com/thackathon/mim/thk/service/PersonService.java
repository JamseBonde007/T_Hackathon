package com.thackathon.mim.thk.service;

import com.thackathon.mim.thk.entity.Person;
import com.thackathon.mim.thk.entity.QPerson;
import com.thackathon.mim.thk.exception.CustomException;
import com.thackathon.mim.thk.repository.PersonRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(@NonNull final PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person getPerson(Long id) {
        return personRepository.findOne(QPerson.person.id.eq(id)).orElseThrow(() -> new CustomException("Nenasla sa osoba s danym id."));
    }
}
