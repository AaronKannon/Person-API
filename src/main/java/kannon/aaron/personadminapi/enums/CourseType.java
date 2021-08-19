package kannon.aaron.personadminapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CourseType {

    NATURAL("Natural"),
    SOCIAL("Social"),
    FORMAL("Formal");

    private final String description;

}
