import java.util.Objects;

public abstract class Producto {
    private String nombre;
    private double precio;

    public static final double IVA = 0.19;
    private static int contador = 0;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        contador++;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { 
        if(nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre; 
    }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { 
        if(precio < 0) throw new IllegalArgumentException("Precio inválido");
        this.precio = precio; 
    }

    public static int getContador() { return contador; }

    public abstract double calcularPrecioFinal();

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Producto)) return false;
        Producto otro = (Producto) obj;
        return Objects.equals(this.nombre, otro.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    String nom1 = String.valueOf(hashCode("Francisco Gomez"));
    String nom2 = String.valueOf(hashCode("Francisco Gomez"));


}
