package kannon.aaron.personadminapi.controller;


import kannon.aaron.personadminapi.dto.response.MessageResponseDTO;
import kannon.aaron.personadminapi.entity.Person;
import kannon.aaron.personadminapi.repository.PersonRepository;
import kannon.aaron.personadminapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController (PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
}
