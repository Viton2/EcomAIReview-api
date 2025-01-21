package com.vitor.oliveira.ecomaireviewapi.DTO.forms;

import com.vitor.oliveira.ecomaireviewapi.DTO.UserDTO;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm {

    @NotNull
    @DecimalMin("0.01")
    @DecimalMax("9999.99")
    private BigDecimal totalPrice;

    @NotNull
    private UUID userId;
}
