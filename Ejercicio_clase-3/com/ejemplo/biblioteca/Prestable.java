package com.ejemplo.biblioteca;

public interface Prestable {
    void prestar();
    void devolver();
    default boolean estaDisponible() {
        System.out.println("Método default: Verificando disponibilidad...");
        return true;
    }
}