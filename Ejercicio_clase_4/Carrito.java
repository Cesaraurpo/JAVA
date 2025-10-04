import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos;

    public Carrito() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public double calcularTotal() {
        double total = 0;
        for(Producto p : productos) {
            total += p.calcularPrecioFinal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Carrito con " + productos.size() + " productos: " + productos;
    }
}
