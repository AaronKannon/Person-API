package kannon.aaron.personadminapi.utils;

import kannon.aaron.personadminapi.dto.request.CourseDTO;
import kannon.aaron.personadminapi.entity.Course;
import kannon.aaron.personadminapi.enums.CourseType;

import java.util.Collections;

public class CourseUtils {

    private static final String NAME = "Computer Engineering";
    private static final String DESCRIPTION = "A course to created Embedded system";
    private static final CourseType COURSE_TYPE = CourseType.FORMAL;
    private static final long COURSE_ID = 1L;

    public static CourseDTO createFakeDTO() {
        return CourseDTO.builder()
                .name(NAME)
                .description(DESCRIPTION)
                .courseType(COURSE_TYPE)
                .disciplines(Collections.singletonList(DisciplineUtils.createFakeDTO()))
                .build();
    }

    public static Course createFakeEntity() {
        return Course.builder()
                .id(COURSE_ID)
                .name(NAME)
                .description(DESCRIPTION)
                .courseType(COURSE_TYPE)
                .disciplines(Collections.singletonList(DisciplineUtils.createFakeEntity()))
                .build();
    }
}
