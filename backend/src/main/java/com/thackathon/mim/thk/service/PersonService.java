package com.thackathon.mim.thk.service;

import com.querydsl.core.BooleanBuilder;
import com.thackathon.mim.thk.entity.Person;
import com.thackathon.mim.thk.entity.QPerson;
import com.thackathon.mim.thk.enums.PersonTypeEnum;
import com.thackathon.mim.thk.enums.SkillsEnum;
import com.thackathon.mim.thk.exception.CustomException;
import com.thackathon.mim.thk.repository.PersonRepository;
import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(@NonNull final PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person savePerson(Person person){
        return personRepository.save(person);
    }
    public Person getPerson(Long id) {
        return personRepository.findOne(QPerson.person.id.eq(id)).orElseThrow(() -> new CustomException("Person with id not found!"));
    }

    public Person login(String email, String password) {
        return personRepository
                .findOne(QPerson.person.email.eq(email).and(QPerson.person.password.eq(password)))
                .orElseThrow(() -> new CustomException("User not found!"));
    }

    public List<Person> findExperts(Pageable pageable, List<String> skills) {
        List<SkillsEnum> skillsEnums = new ArrayList<>();
        skills.forEach(s -> {
            for (SkillsEnum value : SkillsEnum.values()) {
                if (value.value().equals(s)){
                    skillsEnums.add(value);
                }
            }
        });
        BooleanBuilder builder = new BooleanBuilder();
        skillsEnums.forEach(s -> builder.or(QPerson.person.skills.contains(s)));
        builder.and(QPerson.person.type.eq(PersonTypeEnum.EXPERT.value()));
        return personRepository.findAll(builder, pageable).getContent();
    }
}
