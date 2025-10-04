package com.ejemplo.biblioteca;

public class Biblioteca {

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Este programa no requiere argumentos.");
            return;
        }

        MaterialBibliografico libro1 = new Libro("El Señor de los Anillos", "J.R.R. Tolkien", 1954, "978-0-618-05326-7");
        MaterialBibliografico revista1 = new Revista("National Geographic", "Varios", 2023, 123);
        
        Inventario inventario = new Inventario();
        inventario.agregarMaterial(libro1);
        inventario.agregarMaterial(revista1);
        inventario.agregarMaterial(new Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967));
        
        inventario.imprimirInventario();
        
        MaterialBibliografico encontrado = inventario.buscarMaterial("Cien Años de Soledad");
        if (encontrado != null) {
            System.out.println("\nMaterial encontrado: " + encontrado.toString());
            if (encontrado instanceof Libro) {
                Libro libroEncontrado = (Libro) encontrado;
                libroEncontrado.prestar();
                libroEncontrado.estaDisponible();
            }
        } else {
            System.out.println("\nMaterial no encontrado.");
        }
        
        Libro libro2 = new Libro("El Señor de los Anillos", "J.R.R. Tolkien", 1954, "978-0-618-05326-7");
        System.out.println("\n¿El libro 1 es igual al libro 2? " + libro1.equals(libro2));
    }
}