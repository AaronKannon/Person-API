package kannon.aaron.personadminapi.dto.request;

import kannon.aaron.personadminapi.enums.ResidenceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;

    @NotEmpty
    @Size(min=2, max=50)
    private String city;

    @NotEmpty
    @Size(min=2, max=60)
    private String neighborhood;

    @NotEmpty
    @Size(min=2, max=100)
    private String street;

    @NotEmpty
    @Size(min=2, max=5)
    private String number;

    private String complement;

    @Enumerated(EnumType.STRING)
    private ResidenceType residenceType;

}
