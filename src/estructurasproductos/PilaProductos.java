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
public class PilaProductos extends base.Pila {
    private Producto cima;
    
    @Override
    public Producto getCima(){
        return cima;
    }
    
    public boolean existeCodigo(String codigo){
        Producto puntero = cima;
        do {
            if (puntero.getCodigo().equals(codigo)) {
                return true;
            }
            else {
                puntero = puntero.getSiguiente();
            }
        } while (puntero != null);
        return false;
    }
    
    public void llenar(ListaProductos lista){
        Producto base = lista.getBase();
        Producto puntero = base;
        do {
            int precio = puntero.getPrecio();
            if ( precio > 5000 && precio < 7000 ) {
                agregar(puntero);
            }
            puntero = puntero.getSiguiente();
        } while (puntero != null);
    }
}