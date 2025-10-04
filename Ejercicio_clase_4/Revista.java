public class Revista extends Producto implements Vendible {
    private int numeroEdicion;

    public Revista(String nombre, double precio, int numeroEdicion) {
        super(nombre, precio);
        this.numeroEdicion = numeroEdicion;
    }

    public int getNumeroEdicion() { return numeroEdicion; }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio() * (1 + IVA / 2);
    }

    @Override
    public String toString() {
        return "Revista: " + getNombre() + " (Edición " + numeroEdicion + ")";
    }
}
