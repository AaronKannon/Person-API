package kannon.aaron.personadminapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResidenceType {

    HOUSE("House"),
    APARTMENT("Apartment");

    private final String description;

}
