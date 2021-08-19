package kannon.aaron.personadminapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisciplineDTO {

    private Long id;

    @NotEmpty
    @Size(min=2, max=50)
    private String name;

    @NotEmpty
    @Size(min=2, max=500)
    private String description;

}
