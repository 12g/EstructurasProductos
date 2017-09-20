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
public class Pila {
    private Nodo cima;

    public Pila() {
    }
    
    public void agregar(Nodo nuevo){
        if (cima == null) {
            cima = nuevo;
        }
        else {
            nuevo.setSiguiente(cima);
            this.cima = nuevo;
        }
    }
    
    public void escupir(){
        if (cima != null) {
            System.out.println( cima.toString() );
        }
        else {
            System.out.println("La pila no posee elementos!");
        }
    }
}
