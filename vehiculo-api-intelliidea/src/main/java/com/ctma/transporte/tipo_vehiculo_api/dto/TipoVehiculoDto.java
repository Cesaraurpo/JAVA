package com.ctma.transporte.tipo_vehiculo_api.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TipoVehiculoDto(
        Long id,
        @NotBlank @Size(max = 255) String nombre
) {}
