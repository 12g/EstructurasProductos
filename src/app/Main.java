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
                    prod = encontrarProducto(false);
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
                    prod = encontrarProducto(true); //el true nos permite obtener el producto que referencia a aquel que realmente buscamos
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

    /**
     * Una rutina-formulario, en la que al usuario se le solicitan todos los
     * datos necesarios para crear un nuevo producto. Todos deben ser ingresados
     * correctamente antes de poder proceder o salir de esta rutina.
     * @return Un objeto Producto resultante.
     */
    private static Producto crearProducto() {
        String codigo = "", nombre = "", descripcion = "";
        int cantidad = 0, precio = 0, stockCritico = 0;

        System.out.println("A continuación se le solicitarán los datos del producto...");

        do {
            System.out.print("Código: ");
            codigo = inputScanner.nextLine();
        } while (codigo.isEmpty());

        do {
            System.out.print("Nombre: ");
            nombre = inputScanner.nextLine();
        } while (nombre.isEmpty());

        do {
            System.out.print("Descripción: ");
            descripcion = inputScanner.nextLine();
        } while (descripcion.isEmpty());

        do {
            System.out.print("Precio: $");
            precio = inputScanner.nextInt();
            inputScanner.nextLine();
        } while (precio <= 0);

        do {
            System.out.print("Stock actual: ");
            cantidad = inputScanner.nextInt();
            inputScanner.nextLine();
        } while (cantidad <= 0);

        do {
            System.out.print("Stock crítico: ");
            stockCritico = inputScanner.nextInt();
            inputScanner.nextLine();
            if (stockCritico >= cantidad) {
                System.out.print("\nDebe ser menor que el stock actual.\n");
            }
        } while (stockCritico <= 0 || stockCritico >= cantidad);
        
        System.out.println("");
        
        return new Producto(codigo, nombre, descripcion, cantidad, precio, stockCritico);
    }

    /**
     * Una rutina-formulario, que solicita al usuario un código, con el que 
     * busca un producto. Se pide confirmación si el producto es encontrado.
     * @param buscarAnterior true si se quiere el nodo que referencia a aquél 
     * buscado con el código solicitado. Útil si queremos eliminarlo.
     * @return El objeto Producto encontrado, o null si no se pudo encontrar o 
     * no se confirmó.
     */
    private static Producto encontrarProducto(boolean buscarAnterior) {
        
        if (listaMain.getCantidad() == 0) {
            System.out.println("La lista actual no posee elementos.\n");
            return null;
        }

        String codigo;
        Producto objetivo;

        do {
            codigo = "";
            objetivo = null;
            Producto punteroActual = listaMain.getBase();
            Producto punteroAnterior = null;
            Producto referencial = null;

            do {
                System.out.print("Ingrese el código del producto deseado: ");
                codigo = inputScanner.nextLine();
                System.out.println("\n");
            } while (codigo.isEmpty());

            do {
                if (punteroActual.getCodigo().equals(codigo)) {
                    if (buscarAnterior && punteroAnterior != null) {
                        objetivo = punteroAnterior;
                    }
                    else {
                        objetivo = punteroActual;
                    }
                    referencial = punteroActual;
                    break;
                } else {
                    punteroAnterior = punteroActual;
                    punteroActual = punteroActual.getSiguiente();
                }
            } while (punteroActual != null);

            if (referencial != null) {
                System.out.println("PRODUCTO '" + codigo + "' ENCONTRADO\n"
                        + "Nombre: " + referencial.getNombre() + "\n"
                        + "Precio: $" + referencial.getPrecio() + "\n"
                        + "Stock actual: " + referencial.getCantidad() + "\n"
                        + "Stock crítico: " + referencial.getStockCritico() + "\n"
                        + "Es éste el producto que busca? [S/n] "
                );
            } else {
                System.out.print("No se encontró un producto identificado por el código que ingresó.\n"
                        + "Quiere volver a intentarlo? [S/n] ");
            }
            boolean dijoNo = inputScanner.nextLine().equals("n");
            System.out.println("\n");
            if (dijoNo) {
                return null;
            }
        } while (objetivo == null);

        return objetivo;
    }

    /**
     * Una rutina-formulario, solicitando al usuario todos los datos para 
     * modificar un producto específico.
     * @param objetivo El objeto Producto a modificar.
     */
    private static void editarProducto(Producto objetivo) {
        boolean todoOK;

        do {
            System.out.print("Nombre: ");
            todoOK = objetivo.setNombre(inputScanner.nextLine());
            System.out.println("\n");
        } while (!todoOK);

        do {
            System.out.print("Descripción: ");
            todoOK = objetivo.setDescripcion(inputScanner.nextLine());
            System.out.println("\n");
        } while (!todoOK);

        do {
            System.out.print("Precio: $");
            todoOK = objetivo.setPrecio(inputScanner.nextInt());
            inputScanner.nextLine();
            System.out.println("\n");
        } while (!todoOK);

        do {
            System.out.print("Stock actual: ");
            todoOK = objetivo.setCantidad(inputScanner.nextInt());
            inputScanner.nextLine();
            System.out.println("\n");
        } while (!todoOK);

        do {
            System.out.print("Stock crítico: ");
            todoOK = objetivo.setStockCritico(inputScanner.nextInt());
            inputScanner.nextLine();
            System.out.println("\n");
        } while (!todoOK);
    }

    /**
     * Rompe cualquier enlace, dentro de la lista, a un Producto específico.
     * @param prod El Producto a desenlazar de la lista.
     */
    private static void eliminarProducto(Producto prod) {
        Producto siguienteProducto = prod.getSiguiente();
        if (siguienteProducto != null && siguienteProducto.getSiguiente() != null) {
            prod.setSiguiente(siguienteProducto.getSiguiente());
        }
        else {
            prod.setSiguiente(null);
        }
        listaMain.setCantidad( listaMain.getCantidad() - 1 );
    }

    private static void mostrarPila() {
        
    }

}
