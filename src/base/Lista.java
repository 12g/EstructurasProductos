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

    public Lista() {
        this.base = null;
        this.cantidad = 0;
    }
    
    public void agregar(Nodo nuevo) {
        if (base == null) {
            this.base = nuevo;
        }
        else {
            if (cantidad == 1) {
                base.setSiguiente(nuevo);
            }
            else {
                Nodo puntero = base;
                while (puntero.getSiguiente() != null){
                    puntero = puntero.getSiguiente();
                };
                puntero.setSiguiente(nuevo);
            }
        }
        ++cantidad;
    }
    
    public void mostrar(){
        if (base != null) {
            Nodo puntero = base;
            do {
                System.out.println( puntero.toString() );
                puntero = puntero.getSiguiente();
            }
            while (puntero != null);
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
