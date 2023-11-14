import java.util.ArrayList;
import java.util.Scanner;

public class ProgramaPrincipal {
    private ArrayList<Producto> listaDeProductos;
    private Inventario inventario;

    public ProgramaPrincipal() {
        this.listaDeProductos = new ArrayList<>();
        this.inventario = new Inventario();
    }

    public Producto consultarProducto(int codigo) {
        for (Producto producto : listaDeProductos) {
            if (producto.getPlu().equals(""+codigo)) {
                return producto;
            }
        }
        return null;
    }

    public void facturar() {
        Factura factura = new Factura();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingrese el código del artículo a agregar a la factura (0 para salir): ");
            int codigo = scanner.nextInt();

            if (codigo == 0) {
                break;
            }

            Producto producto = consultarProducto(codigo);

            if (producto != null) {
                System.out.print("Ingrese la cantidad de '" + producto.getNombre() + "' a facturar: ");
                int cantidadAFacturar = scanner.nextInt();

                if (cantidadAFacturar <= producto.getCantidad() && cantidadAFacturar > 0) {
                    factura.agregarItem(producto, cantidadAFacturar);
                    System.out.println("Agregado a la factura: " + cantidadAFacturar + " unidades de '" + producto.getNombre() + "'");
                    producto.setCantidad(producto.getCantidad() - cantidadAFacturar);
                    inventario.getStock().put(producto.getPlu(), inventario.getStock().get(producto.getPlu()) - cantidadAFacturar);
                } else {
                    System.out.println("No hay suficientes unidades disponibles de '" + producto.getNombre() + "'.");
                }
            } else {
                System.out.println("Código de artículo no encontrado. Intente nuevamente.");
            }
        }

        double total = factura.calcularTotal();
        System.out.println("\nFactura:");
        for (ItemFactura item : factura.getItems()) {
            Producto producto = item.getProducto();
            int cantidad = item.getCantidad();
            System.out.printf("%d unidades de '%s': $%.3f%n", cantidad, producto.getNombre(), producto.getPrecio() * cantidad);
        }
        System.out.printf("Total: $%.3f%n", total);
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Consultar producto por código");
            System.out.println("2. Facturar");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.next();

            if (opcion.equals("1")) {
                System.out.print("Ingrese el código del artículo a consultar: ");
                int codigo = scanner.nextInt();
                Producto producto = consultarProducto(codigo);

                if (producto != null) {
                    System.out.println("Datos del producto:");
                    System.out.println(producto);
                } else {
                    System.out.println("Código de artículo no encontrado.");
                }
            } else if (opcion.equals("2")) {
                facturar();
            } else if (opcion.equals("3")) {
                break;
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static void main(String[] args) {
        ProgramaPrincipal programa = new ProgramaPrincipal();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingrese el nombre del producto (o '0' para terminar): ");
            String nombre = scanner.next();

            if (nombre.equals("0")) {
                break;
            }

            System.out.print("Ingrese la cantidad de productos: ");
            int cantidad = scanner.nextInt();

            System.out.print("Ingrese el precio del producto: ");
            double precio = scanner.nextDouble();

            System.out.print("Ingrese el código del artículo: ");
            int plu = scanner.nextInt();

            Producto producto = new Producto(nombre, precio, cantidad, ""+plu);
            programa.listaDeProductos.add(producto);
            programa.inventario.getStock().put(""+plu, cantidad);
        }

        programa.ejecutar();
        System.out.println("Gracias por usar el programa.");
    }
}
