package com.ctma.transporte.tipo_vehiculo_api.web.error;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
