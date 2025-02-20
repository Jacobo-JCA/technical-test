package com.tata.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tata.entity.MovementType;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovementDTO {
    private Integer idMovement;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime date;
    @NotNull(message = "Movement type (DEPOSIT, WITHDRAWAL, TRANSFER")
    private MovementType movementType;
    @DecimalMin(value = "-1000.0", message = "Value must be at least -1000.0")
    @DecimalMax(value = "1000.0", message = "Value must be at most 1000.0")
    private Double value;
    @DecimalMin(value = "0.0", message = "Balance must be zero or positive")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double balance;
}
