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
package estructurasproductos;

/**
 *
 * @author blamadrid
 */
public final class ListaProductos extends base.Lista {
    private Producto base;

    public boolean agregar(Producto nuevo) {
        if (this.base == null) {
            this.base = nuevo;
        }
        else {
            String codigoNuevo = nuevo.getCodigo();
            Producto ultimo = verificarCodigo(codigoNuevo);
            if (ultimo != null) { //el codigo no existe
                return ultimo.setSiguiente(nuevo);
            }
            else {
                return false;
            }
        }
        ++cantidad;
        return true;
    }
    
    public Producto verificarCodigo(String codigo){
        boolean existe = false;
        Producto puntero = base;
        do {
            existe = (codigo.equals(puntero.getCodigo()));
            if (!existe && puntero.getSiguiente() != null) {
                puntero = puntero.getSiguiente();
            }
            else {
                break;
            }
        } while (true);
        
        if (existe) { //si existe devolvemos null
            return null;
        }
        else { //si no existe, simplemente devolvemos el ultimo producto-nodo de la lista
            return puntero;
        }
    }

    @Override
    public Producto getBase() {
        return base;
    }

    @Override
    public void mostrar() {
        if (getBase() == null) {
            System.out.println("La lista actual no posee elementos.");
        }
        else {
            Producto puntero = getBase();
            do {
                System.out.println("-------------------");
                System.out.println(puntero.toString());
                puntero = puntero.getSiguiente();
            }
            while (puntero != null);
            System.out.println("-------------------\n");
        }
    }
    
    
}
