package com.sena.transporte.tipo_vehiculo_api.repo;

import com.sena.transporte.tipo_vehiculo_api.domain.TipoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TipoVehiculoRepository extends JpaRepository<TipoVehiculo, Long>
{
    Optional<TipoVehiculo> findByNombreIgnoreCase(String nombre);
    boolean existsByNombreIgnoreCase(String nombre);
}
