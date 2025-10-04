package com.ctma.transporte.tipo_vehiculo_api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tipo_vehiculo", uniqueConstraints = {
        @UniqueConstraint(name = "uk_tipo_vehiculo_nombre", columnNames = "nombre")
})
public class TipoVehiculo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(max = 255)
    @Column(nullable = false, length = 255)
    private String nombre;

    public TipoVehiculo() {}

    public TipoVehiculo(String nombre){this.nombre=nombre;}

    public Long getId(){return id;}

    public String getNombre(){return nombre;}

    public void setNombre(String nombre){this.nombre=nombre;}
}
