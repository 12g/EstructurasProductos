/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

/**
 *
 * @author blamadrid
 */
public class Lista {
    private Nodo base;
    protected int cantidad;

    public Nodo getBase() {
        return base;
    }

    public Lista() {
        this.base = null;
        this.cantidad = 0;
    }
    
    public void agregar(Nodo nuevo) {
        if (getBase() == null) {
            this.base = nuevo;
        }
        else {
            if (cantidad == 1) {
                getBase().setSiguiente(nuevo);
            }
            else {
                Nodo puntero = getBase();
                while (puntero.getSiguiente() != null){
                    puntero = puntero.getSiguiente();
                };
                puntero.setSiguiente(nuevo);
            }
        }
        ++cantidad;
    }
    
    public void mostrar() {
        if (getBase() == null) {
            System.out.println("La lista actual no posee elementos.");
        } else {
            Nodo puntero = getBase();
            do {
                System.out.println("-------------------");
                System.out.println(puntero.toString());
                puntero = puntero.getSiguiente();
            } while (puntero != null);
            System.out.println("-------------------\n");
            System.out.println("");
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
