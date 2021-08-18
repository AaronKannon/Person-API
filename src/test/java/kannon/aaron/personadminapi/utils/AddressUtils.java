package kannon.aaron.personadminapi.utils;

import kannon.aaron.personadminapi.dto.request.AddressDTO;
import kannon.aaron.personadminapi.entity.Address;
import kannon.aaron.personadminapi.enums.PhoneType;
import kannon.aaron.personadminapi.enums.ResidenceType;

public class AddressUtils {

    private static final String CITY = "Rio de Janeiro";
    private static final String NEIGHBORHOOD = "Realengo";
    private static final String STREET = "Rua Limites";
    private static final String NUMBER = "1069";
    private static final String COMPLEMENT = "Em frente ao Emporio Vasco para Sempre";
    private static final ResidenceType RESIDENCE_TYPE = ResidenceType.HOUSE;
    private static final long ADDRESS_ID = 1L;

    public static AddressDTO createFakeDTO() {
        return AddressDTO.builder()
                .city(CITY)
                .neighborhood(NEIGHBORHOOD)
                .street(STREET)
                .number(NUMBER)
                .complement(COMPLEMENT)
                .residenceType(RESIDENCE_TYPE)
                .build();
    }

    public static Address createFakeEntity() {
        return Address.builder()
                .id(ADDRESS_ID)
                .city(CITY)
                .neighborhood(NEIGHBORHOOD)
                .street(STREET)
                .number(NUMBER)
                .complement(COMPLEMENT)
                .residenceType(RESIDENCE_TYPE)
                .build();
    }
}
