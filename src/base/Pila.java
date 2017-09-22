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
package base;

/**
 *
 * @author blamadrid
 */
public class Pila {
    private Nodo cima;
    protected int cantidad;

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
        ++cantidad;
    }
    
    public void escupir(){
        if (cima != null) {
            System.out.println( cima.toString() );
            this.cima = this.cima.getSiguiente();
            --cantidad;
        }
        else {
            System.out.println("La pila no posee elementos!");
        }
    }
    
    public Nodo getCima(){
        return cima;
    }
}
