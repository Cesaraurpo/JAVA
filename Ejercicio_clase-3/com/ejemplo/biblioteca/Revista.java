package com.ejemplo.biblioteca;

public class Revista extends MaterialBibliografico {
    private int numeroEdicion;

    public Revista(String titulo, String autor, int anioPublicacion, int numeroEdicion) {
        super(titulo, autor, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
    }

    @Override
    public String getTipoMaterial() {
        return "Revista";
    }

    @Override
    public String toString() {
        return "Revista -> " + super.toString() + ", Edición: " + numeroEdicion;
    }
}