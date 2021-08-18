package kannon.aaron.personadminapi.utils;

import kannon.aaron.personadminapi.dto.request.PhoneDTO;
import kannon.aaron.personadminapi.entity.Phone;
import kannon.aaron.personadminapi.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "91984569812";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder().id(PHONE_ID).number(PHONE_NUMBER).type(PHONE_TYPE).build();
    }
}
