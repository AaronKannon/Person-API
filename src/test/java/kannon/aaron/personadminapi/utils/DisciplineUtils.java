package kannon.aaron.personadminapi.utils;

import kannon.aaron.personadminapi.dto.request.DisciplineDTO;
import kannon.aaron.personadminapi.entity.Discipline;

public class DisciplineUtils {

    private static final String NAME = "Physics I";
    private static final String DESCRIPTION = "Study about mechanics";
    private static final long DISCIPLINE_ID = 1L;

    public static DisciplineDTO createFakeDTO() {
        return DisciplineDTO.builder()
                .name(NAME)
                .description(DESCRIPTION)
                .build();
    }

    public static Discipline createFakeEntity() {
        return Discipline.builder()
                .id(DISCIPLINE_ID)
                .name(NAME)
                .description(DESCRIPTION)
                .build();
    }
}
