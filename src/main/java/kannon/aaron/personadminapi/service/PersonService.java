package kannon.aaron.personadminapi.service;

import kannon.aaron.personadminapi.dto.response.MessageResponseDTO;
import kannon.aaron.personadminapi.entity.Person;
import kannon.aaron.personadminapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService (PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO.builder().message("Person with ID " + savedPerson.getId() + " with success").build();
    }

}
