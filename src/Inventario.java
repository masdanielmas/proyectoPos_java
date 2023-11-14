import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private Map<String, Integer> stock;

    public Inventario() {
        this.stock = new HashMap<>();
    }

    public void agregarProducto(Producto producto) {
        this.stock.put(producto.getPlu(), producto.getCantidad());
    }

    public Map<String, Integer> getStock() {
        return stock;
    }

    public void setStock(Map<String, Integer> stock) {
        this.stock = stock;
    }
}
