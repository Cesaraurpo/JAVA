public interface Vendible {
    double calcularPrecioFinal();

    default void mostrarInfo() {
        System.out.println("Producto disponible para la venta.");
    }
}
