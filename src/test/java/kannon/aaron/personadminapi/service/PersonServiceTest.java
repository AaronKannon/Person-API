package kannon.aaron.personadminapi.service;

import kannon.aaron.personadminapi.dto.request.PersonDTO;
import kannon.aaron.personadminapi.dto.response.MessageResponseDTO;
import kannon.aaron.personadminapi.entity.Person;
import kannon.aaron.personadminapi.exception.PersonNotFoundException;
import kannon.aaron.personadminapi.mapper.PersonMapper;
import kannon.aaron.personadminapi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static kannon.aaron.personadminapi.utils.PersonUtils.createFakeDTO;
import static kannon.aaron.personadminapi.utils.PersonUtils.createFakeEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId(), "creating person with ID ");
        MessageResponseDTO successMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    @Test
    void testGivenPersonThenReturnNothingOnDelete() throws PersonNotFoundException {
        Person expected = createFakeEntity();

        when(personRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(expected));

        personService.deleteById(expected.getId());
        verify(personRepository).deleteById(expected.getId());
    }

    @Test
    void testGivenPersonDTOThenReturnSavedMassageOnUpdate() throws PersonNotFoundException {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        personDTO.setId(1L);
        personDTO.setLastName("Milão");

        when(personRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(expectedSavedPerson));
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId(), "updating person with ID ");
        MessageResponseDTO successMessage = personService.updateById(personDTO.getId(),personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    @Test
    void testFindPersonDTOByIdThenReturnPerson() throws PersonNotFoundException {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        personDTO.setId(1L);
        personDTO.getAddress().setId(1L);
        personDTO.getPhones().get(0).setId(1L);
        personDTO.setBirthDate("1986-06-20");

        when(personRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(expectedSavedPerson));

        PersonDTO personDTOFinded = personService.findById(personDTO.getId());

        assertEquals(personDTO, personDTOFinded);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id, String s) {
        return MessageResponseDTO.builder().message("Success in "+ s + id).build();
    }

}
