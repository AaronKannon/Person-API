package kannon.aaron.personadminapi.service;

import kannon.aaron.personadminapi.dto.request.PersonDTO;
import kannon.aaron.personadminapi.dto.response.MessageResponseDTO;
import kannon.aaron.personadminapi.entity.Person;
import kannon.aaron.personadminapi.exception.PersonNotFoundException;
import kannon.aaron.personadminapi.mapper.PersonMapper;
import kannon.aaron.personadminapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService (PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder().message("Person with ID " + savedPerson.getId() + " with success").build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }
    
    public PersonDTO findById (Long id) throws PersonNotFoundException {
        Person person= personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        return personMapper.toDTO(person);
    }
}
