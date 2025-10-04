package com.sena.transporte.tipo_vehiculo_api.web;

import com.sena.transporte.tipo_vehiculo_api.dto.TipoVehiculoDto;
import com.sena.transporte.tipo_vehiculo_api.service.TipoVehiculoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tipos-vehiculo")
public class TipoVehiculoController {
    private final TipoVehiculoService service;
    public TipoVehiculoController(TipoVehiculoService service) {
        this.service = service;
    }

    @GetMapping
    public Page<TipoVehiculoDto> listar(@RequestParam(required=false) String q, Pageable pageable) {
        return service.listar(q, pageable);
    }

    @GetMapping("/{id}")
    public TipoVehiculoDto obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PostMapping
    public TipoVehiculoDto crear(@Valid @RequestBody TipoVehiculoDto dto) {
        return service.crear(dto);
    }
    @PutMapping("/{id}")
    public TipoVehiculoDto actualizar(@PathVariable Long id, @Valid @RequestBody TipoVehiculoDto dto) {
    return service.actualizar(id, dto);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
