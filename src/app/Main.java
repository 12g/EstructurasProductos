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
            switch (option) {
                case 1:
                    Producto nuevo = crearProducto();
                    break;
                case 2:
                    //modificar prod
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
                case 7: break;
                default:
                    option = 0;
                    break;
            }
        }
        while (option != 7);
    }

    private static Producto crearProducto() {
        String codigo = "", nombre = "", descripcion = "";
        int cantidad = 0, precio = 0, stockCritico = 0;
        
        System.out.println("Usted ha elegido Ingresar Producto. A continuación se le solicitarán los datos del producto.");
        
        do {
            System.out.print("Codigo de producto: ");
            codigo = inputScanner.nextLine();
            System.out.println("\n");
        }
        while (codigo.isEmpty());
        
        while (nombre.isEmpty()) {
            System.out.print("Nombre de producto: ");
            codigo = inputScanner.nextLine();
            System.out.println("\n");
        }
        
        while (codigo.isEmpty()) {
            System.out.print("Nombre de producto: ");
            codigo = inputScanner.nextLine();
            System.out.println("\n");
        }
        
        return new Producto(codigo, nombre, descripcion, cantidad, precio, stockCritico);
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
    
}