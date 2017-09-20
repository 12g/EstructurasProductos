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
public class Nodo {
    private String valor;
    private Nodo siguiente;

    public Nodo() {
        siguiente = null;
    }

    public Nodo(Nodo siguiente) {
        setSiguiente(siguiente);
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    @Override
    public String toString() {
        return valor;
    }
    
}
