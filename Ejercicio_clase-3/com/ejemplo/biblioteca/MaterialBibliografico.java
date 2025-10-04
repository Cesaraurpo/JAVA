package com.ejemplo.biblioteca;

import java.util.Objects;

public abstract class MaterialBibliografico {
    private String titulo;
    private String autor;
    private int anioPublicacion;

    public static final String LUGAR_BIBLIOTECA = "Sección Principal";
    private static int contadorMateriales = 0;

    public MaterialBibliografico(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        contadorMateriales++;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }

    public static int getContadorMateriales() { return contadorMateriales; }

    public abstract String getTipoMaterial();

    @Override
    public String toString() {
        return "Título: '" + titulo + '\'' + ", Autor: '" + autor + '\'' + ", Año de Publicación: " + anioPublicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialBibliografico that = (MaterialBibliografico) o;
        return anioPublicacion == that.anioPublicacion &&
               Objects.equals(titulo, that.titulo) &&
               Objects.equals(autor, that.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, anioPublicacion);
    }
}