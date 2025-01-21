package com.vitor.oliveira.ecomaireviewapi.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String id;

    @NotNull
    private String email;

    @Size(max = 255)
    @NotNull
    private String firstName;

    @Size(max = 255)
    @NotNull
    private String lastName;
}
