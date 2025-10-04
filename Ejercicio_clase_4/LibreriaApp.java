import java.util.HashSet;
import java.util.Set;

public class LibreriaApp {
    public static void main(String[] args) {
        Libro l1 = new Libro("El Quijote", 50000, "Cervantes", 1200);
        Libro l2 = new Libro("Clean Code", 150000, "Robert C. Martin", 464);
        Revista r1 = new Revista("National Geographic", 20000, 350);

        Producto p1 = l1; 
        Producto p2 = r1;

        Carrito carrito = new Carrito();
        carrito.agregarProducto(p1);
        carrito.agregarProducto(p2);
        carrito.agregarProducto(l2);

        System.out.println("=== Productos en carrito ===");
        System.out.println(carrito);
        System.out.println("Total a pagar: $" + carrito.calcularTotal());

        Set<Producto> inventario = new HashSet<>();
        inventario.add(l1);
        inventario.add(l2);
        inventario.add(new Libro("El Quijote", 50000, "Cervantes", 1200)); // duplicado

        System.out.println("\n=== Inventario (sin duplicados por equals/hashCode) ===");
        for(Producto p : inventario) {
            System.out.println(p);
        }

        System.out.println("\nProductos creados: " + Producto.getContador());
    }
}
