public class Libro extends Producto {
    private String autor;
    private int paginas;

    public Libro(String nombre, double precio, String autor, int paginas) {
        super(nombre, precio);
        this.autor = autor;
        this.paginas = paginas;
    }

    public Libro() {
        super("Título Desconocido", 0.0);
        this.autor = "Desconocido";
        this.paginas = 1200;
    }

    public Libro(String nombre, int paginas) {
        super(nombre, 0.0);
        this.paginas = paginas;
    }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getPaginas() { return paginas; }
    public void setPaginas(int paginas) { this.paginas = paginas; }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio() * (1 + IVA);
    }

    @Override
    public String toString() {
        return "Libro: " + getNombre() + " de " + autor + " (" + paginas + " páginas)";
    }
}
