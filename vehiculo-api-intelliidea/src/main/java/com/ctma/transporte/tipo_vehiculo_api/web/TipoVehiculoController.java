package com.ctma.transporte.tipo_vehiculo_api.web;

import com.ctma.transporte.tipo_vehiculo_api.dto.TipoVehiculoDto;
import com.ctma.transporte.tipo_vehiculo_api.service.TipoVehiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-vehiculo")
@CrossOrigin(origins = "*")
public class TipoVehiculoController {

    private final TipoVehiculoService service;

    @Autowired
    public TipoVehiculoController(TipoVehiculoService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TipoVehiculoDto>> findAll() {
        List<TipoVehiculoDto> tipos = service.findAll();
        return ResponseEntity.ok(tipos);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoVehiculoDto> findById(@PathVariable Long id) {
        TipoVehiculoDto tipo = service.findById(id);
        return ResponseEntity.ok(tipo);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoVehiculoDto> create(@Valid @RequestBody TipoVehiculoDto dto) {
        TipoVehiculoDto created = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoVehiculoDto> update(@PathVariable Long id, @Valid @RequestBody TipoVehiculoDto dto) {
        TipoVehiculoDto updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
