/*
 * Copyright (C) 2017 blamadrid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package app;

import estructurasproductos.*;
import java.util.Scanner;

/**
 *
 * @author blamadrid
 */
public class Main {

    static ListaProductos listaMain;
    static PilaProductos pilaMain;
    static Scanner inputScanner;
    static int option;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        listaMain = new ListaProductos();
        pilaMain = new PilaProductos();
        inputScanner = new Scanner(System.in);

        do {
            printMenu();

            Producto prod;
            option = inputScanner.nextInt();
            inputScanner.nextLine();
            switch (option) {
                case 1:
                    prod = crearProducto();
                    if (listaMain.agregar(prod)) {
                        System.out.println("\nProducto agregado con éxito.\n\n");
                    } else {
                        System.out.println("Este código ya existe.");
                    }
                    break;
                case 2:
                    prod = encontrarProducto();
                    if (prod != null) {
                        editarProducto(prod);
                    }
                    break;
                case 3:
                    listaMain.mostrar();
                    break;
                case 4:
                    pilaMain.llenar(listaMain);
                    break;
                case 5:
                    prod = encontrarProducto();
                    if (prod != null) {
                        eliminarProducto(prod);
                    }
                    break;
                case 6:
                    mostrarPila();
                    break;
                case 7:
                    break;
                default:
                    option = 0;
                    break;
            }
        } while (option != 7);
    }

    private static void printMenu() {
        System.out.println("Menú principal");
        System.out.println("1. Ingresar producto");
        System.out.println("2. Modificar producto");
        System.out.println("3. Mostrar lista");
        System.out.println("4. Llenar pila");
        System.out.println("5. Eliminar elemento");
        System.out.println("6. Mostrar pila");
        System.out.println("7. Salir");
    }

    private static Producto crearProducto() {
        String codigo = "", nombre = "", descripcion = "";
        int cantidad = 0, precio = 0, stockCritico = 0;

        System.out.println("A continuación se le solicitarán los datos del producto...");

        do {
            System.out.print("Código de producto: ");
            codigo = inputScanner.nextLine();
        } while (codigo.isEmpty());

        do {
            System.out.print("Nombre de producto: ");
            nombre = inputScanner.nextLine();
        } while (nombre.isEmpty());

        do {
            System.out.print("Descripción del producto: ");
            descripcion = inputScanner.nextLine();
        } while (descripcion.isEmpty());

        do {
            System.out.print("Precio del producto: $");
            precio = inputScanner.nextInt();
            inputScanner.nextLine();
        } while (precio <= 0);

        do {
            System.out.print("Cantidad del producto: ");
            cantidad = inputScanner.nextInt();
            inputScanner.nextLine();
        } while (cantidad <= 2);

        do {
            System.out.print("Stock crítico del producto: ");
            stockCritico = inputScanner.nextInt();
            inputScanner.nextLine();
        } while (stockCritico <= 0 && stockCritico < cantidad);

        return new Producto(codigo, nombre, descripcion, cantidad, precio, stockCritico);
    }

    private static Producto encontrarProducto() {
        if (listaMain.getCantidad() == 0) {
            System.out.println("La lista actual no posee elementos.\n");
            return null;
        }

        String codigo;
        Producto objetivo;

        do {
            codigo = "";
            objetivo = null;
            Producto puntero = listaMain.getBase();

            do {
                System.out.println("Ingrese el código del producto a editar: ");
                codigo = inputScanner.nextLine();
                System.out.println("\n");
            } while (codigo.isEmpty());

            do {
                if (puntero.getCodigo().equals(codigo)) {
                    objetivo = puntero;
                    break;
                } else {
                    puntero = puntero.getSiguiente();
                }
            } while (puntero != null);

            if (objetivo != null) {
                System.out.println("PRODUCTO '" + codigo + "' ENCONTRADO\n"
                        + "Nombre: " + objetivo.getNombre() + "\n"
                        + "Precio: " + objetivo.getPrecio() + "\n"
                        + "Stock: " + objetivo.getCantidad() + "\n"
                        + "Stock critico: " + objetivo.getStockCritico() + "\n"
                        + "Está seguro de editarlo? [S/n] "
                );
            } else {
                System.out.println("El producto especificado no existe.\n"
                        + "Quiere volver a intentarlo? [S/n] ");
            }
            if (inputScanner.nextLine().equals("n")) {
                return null;
            }
            System.out.println("\n");
        } while (objetivo == null);

        return objetivo;
    }

    private static void editarProducto(Producto objetivo) {
        boolean todoOK;

        do {
            System.out.print("Código: ");
            todoOK = objetivo.setCodigo(inputScanner.nextLine());
            System.out.println("\n");
        } while (todoOK);

        do {
            System.out.print("Nombre: ");
            todoOK = objetivo.setNombre(inputScanner.nextLine());
            System.out.println("\n");
        } while (todoOK);

        do {
            System.out.print("Descripción: ");
            todoOK = objetivo.setDescripcion(inputScanner.nextLine());
            System.out.println("\n");
        } while (todoOK);

        do {
            System.out.print("Precio: ");
            todoOK = objetivo.setPrecio(inputScanner.nextInt());
            inputScanner.nextLine();
            System.out.println("\n");
        } while (todoOK);

        do {
            System.out.print("Cantidad: ");
            todoOK = objetivo.setCantidad(inputScanner.nextInt());
            inputScanner.nextLine();
            System.out.println("\n");
        } while (todoOK);

        do {
            System.out.print("Stock Crítico: ");
            todoOK = objetivo.setStockCritico(inputScanner.nextInt());
            inputScanner.nextLine();
            System.out.println("\n");
        } while (todoOK);
    }

    private static void eliminarProducto(Producto prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void mostrarPila() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
