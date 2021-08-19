package kannon.aaron.personadminapi.dto.request;

import kannon.aaron.personadminapi.entity.Discipline;
import kannon.aaron.personadminapi.enums.CourseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Long id;

    @NotEmpty
    @Size(min=2, max=100)
    private String name;

    @NotEmpty
    @Size(min=2, max=300)
    private String description;

    @Enumerated(EnumType.STRING)
    private CourseType courseType;

    @Valid
    @NotEmpty
    private List<DisciplineDTO> disciplines;

}
