package com.ctma.transporte.tipo_vehiculo_api.service;

import com.ctma.transporte.tipo_vehiculo_api.domain.TipoVehiculo;
import com.ctma.transporte.tipo_vehiculo_api.dto.TipoVehiculoDto;
import com.ctma.transporte.tipo_vehiculo_api.repo.TipoVehiculoRepository;
import com.ctma.transporte.tipo_vehiculo_api.web.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoVehiculoService {

    @Autowired
    private TipoVehiculoRepository repository;

    public List<TipoVehiculoDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public TipoVehiculoDto findById(Long id) {
        TipoVehiculo tipoVehiculo = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tipo de vehículo no encontrado con ID: " + id));
        return toDto(tipoVehiculo);
    }

    public TipoVehiculoDto save(TipoVehiculoDto dto) {
        if (repository.existsByNombreIgnoreCase(dto.nombre())) {
            throw new IllegalArgumentException("Ya existe un tipo de vehículo con ese nombre");
        }
        TipoVehiculo tipoVehiculo = new TipoVehiculo(dto.nombre());
        TipoVehiculo saved = repository.save(tipoVehiculo);
        return toDto(saved);
    }

    public TipoVehiculoDto update(Long id, TipoVehiculoDto dto) {
        TipoVehiculo existing = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tipo de vehículo no encontrado con ID: " + id));

        if (!existing.getNombre().equalsIgnoreCase(dto.nombre()) &&
            repository.existsByNombreIgnoreCase(dto.nombre())) {
            throw new IllegalArgumentException("Ya existe un tipo de vehículo con ese nombre");
        }

        existing.setNombre(dto.nombre());
        TipoVehiculo updated = repository.save(existing);
        return toDto(updated);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Tipo de vehículo no encontrado con ID: " + id);
        }
        repository.deleteById(id);
    }

    private TipoVehiculoDto toDto(TipoVehiculo entity) {
        return new TipoVehiculoDto(entity.getId(), entity.getNombre());
    }
}
