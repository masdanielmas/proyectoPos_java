public class Producto {
    private String nombre;
    private int cantidad;
    private double precio;
    private String plu;

    public Producto(String nombre, double precio, int cantidad, String plu) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.plu = plu;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s, Cantidad: %d, Precio: $%.2f, Código: %s",
                this.nombre, this.cantidad, this.precio, this.plu);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPlu() {
        return plu;
    }

    public void setPlu(String plu) {
        this.plu = plu;
    }
}
