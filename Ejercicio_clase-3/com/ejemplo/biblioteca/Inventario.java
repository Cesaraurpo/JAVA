package com.ejemplo.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<MaterialBibliografico> materiales;

    public Inventario() {
        this.materiales = new ArrayList<>();
    }

    public void agregarMaterial(MaterialBibliografico material) {
        materiales.add(material);
        System.out.println(material.getTipoMaterial() + " '" + material.getTitulo() + "' agregado al inventario.");
    }

    public MaterialBibliografico buscarMaterial(String titulo) {
        for (MaterialBibliografico m : materiales) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                return m;
            }
        }
        return null;
    }

    public void imprimirInventario() {
        System.out.println("\n--- Inventario de la Biblioteca ---");
        for (MaterialBibliografico material : materiales) {
            System.out.println(material.toString());
        }
        System.out.println("Total de materiales en el inventario: " + MaterialBibliografico.getContadorMateriales());
        System.out.println("------------------------------------");
    }
}