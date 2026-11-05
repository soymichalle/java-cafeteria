public class SistemaCafeteria {

    public static void main(String[] args) {
        String[] nombres = {"Café americano", "Capuchino", "Jugo naranja", "Tostada",
                "Brownie"};
        double[] precios = {3500, 5000, 4000, 4500, 6000};
        char[] categorias = {'B', 'B', 'F', 'C', 'P'}; // B=Bebida caliente, F=Fría, C=Comida, P = Postre
        int[] pedidoProducto = {0, 2, 1, 4, 0, 3}; // índice del producto en cada pedido
        int[] pedidoCantidad = {2, 1, 3, 1, 1, 2}; // unidades por pedido

        int inventarioBrownie = 10;
        double montoApertura = 0;
        double totalRecaudo = 0;
        double precioMayor = 0;
        int numPedidoMayor = 0;

        do {

            System.out.println("Validando apertura de caja...");

            if (montoApertura <= 0) {
                System.out.println("Monto inválido. Intente nuevamente.");

                montoApertura = 50000;
            }

        } while (montoApertura <= 0);

        System.out.println("Caja abierta con: $" + montoApertura);

        for (int i = 0; i < pedidoProducto.length; i++) {

            // Se inicializan en cada recorrido
            boolean aplicoDescuento = false;
            double descuento = 0;

            // Se obtiene el indice del producto
            int indiceProducto = pedidoProducto[i];

            // Se imprime numero de pedido
            System.out.println(String.format("Pedido número, %d", i + 1));

            // Se imprime nombre del producto
            System.out.println(String.format("Nombre del producto, %s", nombres[indiceProducto]));

            // Se imprime cantidad del producto
            System.out.println(String.format("Cantidad del producto, %d", pedidoCantidad[i]));

            if (indiceProducto == 4) {

                if (inventarioBrownie >= pedidoCantidad[i]) {

                    inventarioBrownie -= pedidoCantidad[i];
                    System.out.println(String.format("Se están alistando %d unidades de Brownie", pedidoCantidad[i]));

                } else {

                    System.out.println("Producto agotado. No se puede gestionar la venta");
                    continue;

                }
            }

            // Switch
            switch (categorias[indiceProducto]) {

                // bebidaCaliente
                case 'B':
                    System.out.println("Caso de bebida caliente");
                    break;

                // bebidaFria
                case 'F':
                    System.out.println("Caso de bebida fría");
                    break;

                // comida
                case 'C':
                    System.out.println("Caso de comida");
                    break;

                // postre
                case 'P':
                    System.out.println("Caso de postre");
                    break;

                // Por defecto
                default:
                    System.out.println("No se reconoce la categoria del producto.");
            }

            // Se calcula subtotal
            double subtotal = precios[indiceProducto] * pedidoCantidad[i];

            // Se imprime subtotal
            System.out.println(String.format("Subtotal, $%.2f", subtotal));

            if (subtotal > 12000) {
                descuento = 0.1;
                aplicoDescuento = true;
            }

            double total = subtotal - (subtotal * descuento);
            totalRecaudo += total;

            if (total > precioMayor) {
                precioMayor = total;
                numPedidoMayor = i + 1;
            }

            System.out.print(String.format("Total a pagar: %.2f", total));
            System.out.println(String.format("Se aplicó descuento? %b", aplicoDescuento));

        }

        System.out.print("\nFin del turno");
        System.out.print(String.format("\nTotal de pedidos procesados: %d", pedidoProducto.length));
        System.out.print(String.format("\nTotal recaudado en turno: $%.2f", totalRecaudo));
        System.out.print(String.format("\nEl pedido con mayor valor fue el numero %d con %.2f", numPedidoMayor, precioMayor));

    }
}
