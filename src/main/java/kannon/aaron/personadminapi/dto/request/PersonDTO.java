package kannon.aaron.personadminapi.dto.request;

import kannon.aaron.personadminapi.entity.Address;
import kannon.aaron.personadminapi.entity.Course;
import kannon.aaron.personadminapi.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min=2, max=100)
    private String firstName;

    @NotEmpty
    @Size(min=2, max=100)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    private String birthDate;

    @Valid
    @NotNull
    private AddressDTO address;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;

    @Valid
    @NotNull
    private CourseDTO course;
}
