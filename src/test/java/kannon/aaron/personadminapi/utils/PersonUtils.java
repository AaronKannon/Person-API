package kannon.aaron.personadminapi.utils;

import kannon.aaron.personadminapi.dto.request.PersonDTO;
import kannon.aaron.personadminapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRST_NAME = "Andre";
    private static final String LAST_NAME = "Gomes";
    private static final String CPF_NUMBER = "868.884.791-61";
    private static final long PERSON_ID = 1L;
    private static final LocalDate BIRTH_DATE = LocalDate.of(1986,06,20);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("20-06-1986")
                .address(AddressUtils.createFakeDTO())
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .address(AddressUtils.createFakeEntity())
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
