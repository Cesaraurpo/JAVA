package com.sena.transporte.tipo_vehiculo_api.service;

import com.sena.transporte.tipo_vehiculo_api.domain.TipoVehiculo;
import com.sena.transporte.tipo_vehiculo_api.dto.TipoVehiculoDto;
import com.sena.transporte.tipo_vehiculo_api.repo.TipoVehiculoRepository;
import com.sena.transporte.tipo_vehiculo_api.web.error.NotFoundException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoVehiculoService {
    private final TipoVehiculoRepository repo;
    public TipoVehiculoService(TipoVehiculoRepository repo) {this.repo=repo;}

public Page<TipoVehiculoDto> listar(String q, Pageable pageable){
    Page<TipoVehiculo> page = (q==null || q.isBlank()) ? repo.findAll(pageable)
            : repo.findAll(Example.of(new TipoVehiculo(q),
            ExampleMatcher.matching().withMatcher("nombre",
                    ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())), pageable);
    return page.map(tv -> new TipoVehiculoDto(tv.getId(), tv.getNombre()));
}

public TipoVehiculoDto crear(TipoVehiculoDto dto){
    if (repo.existsByNombreIgnoreCase(dto.nombre()))
        throw new IllegalArgumentException("Ya existe un tipo_vehiculo con ese nombre");
    TipoVehiculo tv = repo.save(new TipoVehiculo(dto.nombre()));
    return new TipoVehiculoDto(tv.getId(), tv.getNombre());
}

public TipoVehiculoDto obtener(Long id){
    TipoVehiculo tv = repo.findById(id).orElseThrow(() -> new NotFoundException("TipoVehiculo no encontrado"));
    return new TipoVehiculoDto(tv.getId(), tv.getNombre());
}

public TipoVehiculoDto actualizar(Long id, TipoVehiculoDto dto){
    TipoVehiculo tv = repo.findById(id).orElseThrow(() -> new NotFoundException("TipoVehiculo no encontrado"));
    if (!tv.getNombre().equalsIgnoreCase(dto.nombre()) && repo.existsByNombreIgnoreCase(dto.nombre()))
        throw new IllegalArgumentException("Nombre ya en uso");
    tv.setNombre(dto.nombre());
    return new TipoVehiculoDto(tv.getId(), tv.getNombre());
}

public void eliminar(Long id){
    if (!repo.existsById(id))
        throw new NotFoundException("TipoVehiculo no encontrado");
    repo.deleteById(id);
    }
}