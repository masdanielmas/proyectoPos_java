import java.util.ArrayList;
import java.util.List;

public class Factura {
    private List<ItemFactura> items;

    public Factura() {
        this.items = new ArrayList<>();
    }

    public void agregarItem(Producto producto, int cantidad) {
        this.items.add(new ItemFactura(producto, cantidad));
    }

    public double calcularTotal() {
        double suma = 0;
        for(ItemFactura item : items) {
            suma = item.getPrecio();
        }
        return suma;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }
}