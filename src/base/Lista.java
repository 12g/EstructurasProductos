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

    public Lista() {
        this.base = null;
    }
    
    public void agregar(Nodo nuevo) {
        if (base == null) {
            this.base = nuevo;
        }
        else {
            base.setSiguiente(nuevo);
        }
    }
    
    public void mostrar(){
        if (base != null) {
            Nodo puntero = base;
            do {
                System.out.println( puntero.toString() );
                puntero = puntero.getSiguiente();
            }
            while (base != null);
            System.out.println("");
        }
    }
}
