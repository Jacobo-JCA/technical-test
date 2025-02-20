package com.tata.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Integer idCustomer;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String name;
    @NotNull
    @NotEmpty
    private String genre;
    @Min(value = 1, message = "La edad debe ser mayor a 0.")
    @Max(value = 120, message = "La edad debe ser menor o igual a 120.")
    private int age;
    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String ci;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String address;
    @NotNull
    @NotEmpty
    @Pattern(regexp="[0-9]+")
    private String telephone;
    @NotNull
    @NotEmpty
    @Size(min = 10, max = 80)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
