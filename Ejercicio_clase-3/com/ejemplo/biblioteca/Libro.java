package com.ejemplo.biblioteca;

public class Libro extends MaterialBibliografico implements Prestable {
    private String isbn;
    private boolean prestado = false;

    public Libro(String titulo, String autor, int anioPublicacion, String isbn) {
        super(titulo, autor, anioPublicacion);
        this.isbn = isbn;
    }

    public Libro(String titulo, String autor, int anioPublicacion) {
        this(titulo, autor, anioPublicacion, "Sin ISBN");
    }

    @Override
    public String getTipoMaterial() {
        return "Libro";
    }

    @Override
    public void prestar() {
        if (!prestado) {
            System.out.println("El libro '" + getTitulo() + "' ha sido prestado.");
            this.prestado = true;
        } else {
            System.out.println("El libro '" + getTitulo() + "' ya está prestado.");
        }
    }

    @Override
    public void devolver() {
        if (prestado) {
            System.out.println("El libro '" + getTitulo() + "' ha sido devuelto.");
            this.prestado = false;
        } else {
            System.out.println("El libro '" + getTitulo() + "' no estaba prestado.");
        }
    }

    @Override
    public String toString() {
        return "Libro -> " + super.toString() + ", ISBN: " + isbn;
    }
}