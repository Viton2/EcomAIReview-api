package com.vitor.oliveira.ecomaireviewapi.DTO;

import com.vitor.oliveira.ecomaireviewapi.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private UUID id;

    @NotNull
    private BigDecimal totalPrice;

    @NotNull
    private UserDTO user;
}
