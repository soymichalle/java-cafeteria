// Taller: Sistema de cafeteria
// Generation JAVA 15
// Michalle Daniela Muñoz

// Para el ejercicio 5: Se importa clase Scanner

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Ejercicio 1:

        // Se definen las variables del producto
        String nombreProducto = "Cafe Colombiano";
        double precioUnitario = 8500;
        int cantidadInventario = 25;
        boolean disponibleHoy = false;
        char codigoProducto = 'C';

        // Se imprime cada variable
        System.out.println(String.format("Nombre del produto: %s", nombreProducto));
        System.out.println(String.format("Precio del produto: $%.2f", precioUnitario));
        System.out.println(String.format("Cantidad disponible: %d", cantidadInventario));
        System.out.println(String.format("Disponible hoy: %b", disponibleHoy));
        System.out.println(String.format("Codigo del producto: %c", codigoProducto));

        System.out.print("=========================\n");

        // Ejercicio 2:

        // Se definen variables de la compra
        double descuento = 0;
        boolean aplicaDescuento = false;
        double subtotal = 42500;
        double montoMinimo = 30000;

        // Valida si aplica descuento
        if (subtotal >= montoMinimo) {

            aplicaDescuento = true;
            descuento = subtotal * 0.13;
        }

        // Resta el descuento a la factura
        double total = subtotal - descuento;

        //Se imprimen resultados
        System.out.println(String.format("El valor del descuento es: $%.2f", descuento));
        System.out.println(String.format("El valor a pagar es: $%.2f", total));
        System.out.println(String.format("¿La compra tiene descuento del 0.13 aplicado? %b", aplicaDescuento));

        System.out.print("=========================\n");

        // Ejercicio 3:

        // Se define caso prueba donde el codigo es P de postre
        codigoProducto = 'P';

        // Switch
        switch (codigoProducto) {

            // bebidaCaliente
            case 'B':
                System.out.println("Caso de bebida caliente");
                System.out.println("IVA: 0%");
                break;

            // bebidaFria
            case 'F':
                System.out.println("Caso de bebida fría");
                System.out.println("IVA: 5%");
                break;

            // comida
            case 'C':
                System.out.println("Caso de comida");
                System.out.println("IVA: 8%");
                break;

            // postre
            case 'P':
                System.out.println("Caso de postre");
                System.out.println("IVA: 8%");
                break;

            // Por defecto
            default:
                System.out.println("No se reconoce la categoria del producto.");
        }

        System.out.print("=========================\n");

        // Ejercicio 4:

        // Se define inventario inicial y no. de consumo por pedido
        int inventarioCafeMolido = 50;
        int consumoPedido = 3;

        // Se define ciclo de pedidos
        while (inventarioCafeMolido > 10) {

            inventarioCafeMolido = inventarioCafeMolido - consumoPedido;
            System.out.println(String.format("Inventario restante: %d", inventarioCafeMolido));

        }

        System.out.print("=========================\n");

        // Ejercicio 5:

        Scanner sca = new Scanner(System.in);
        double montoInicial = 0;

        System.out.print("===== INICIO DE TURNO =====");

        do {

            System.out.print("\nDigita el monto de apertura de caja: ");

            if (sca.hasNextDouble()) {

                montoInicial = sca.nextDouble();

                if (montoInicial <= 0) {

                    System.out.println("Oh-uh! El monto digitado no es válido. Verifica que sea mayor a 0.");
                }

            } else {

                System.out.print("Oh-uh! Debes digitar un número válido");
                sca.next();
            }
        }
        while (montoInicial == 0);

        System.out.print(String.format("Monto de apertura registrado es: $%.2f", montoInicial));

        sca.close();

        System.out.print("\n=========================");

        // Ejercicio 6:

        String[] productos = {"Café americano", "Capuchino", "Jugo de naranja", "Tostada",
                "Brownie"};
        double[] precios = {3500, 5000, 4000, 4500, 6000};
        double preciosPromedio = 0;
        int longitud = precios.length;

        for (int i = 0; i<longitud; i++){
            System.out.print(String.format("\nProducto: %s. Precio: $%.2f", productos[i], precios[i]));
            preciosPromedio = preciosPromedio + precios[i];
        }

        preciosPromedio = preciosPromedio/longitud;
        System.out.print(String.format("\nEl precio promedio del menú es: $%.2f", preciosPromedio));
        System.out.print("\n=========================\n");
    }
}
