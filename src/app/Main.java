/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

            option = inputScanner.nextInt();
            inputScanner.nextLine();
            switch (option) {
                case 1:
                    Producto nuevo = crearProducto();
                    if (listaMain.agregar(nuevo)) {
                        System.out.println("\nProducto agregado con éxito.\n\n");
                    }
                    else {
                        System.out.println("Este código ya existe.");
                    }
                    break;
                case 2:
                    Producto objetivo = encontrarProducto();
                    if (objetivo != null) {
                        editarProducto(objetivo);
                    }
                    break;
                case 3:
                    //mostrar lista
                    break;
                case 4:
                    //llenar pila
                    break;
                case 5:
                    //eliminar elemento
                    break;
                case 6:
                    //mostrar pila
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
            } 
            else {
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

}
