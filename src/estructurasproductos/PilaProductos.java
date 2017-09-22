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

import base.Nodo;

/**
 *
 * @author blamadrid
 */
public final class PilaProductos extends base.Pila {

    private ProductoPila cima;

    @Override
    public ProductoPila getCima() {
        return cima;
    }

    /**
     * Busca entre todos los Productos de la Pila, alguno cuyo código sea
     * idéntico al ingresado.
     *
     * @param codigo El código a comparar.
     * @return true si el código es encontrado en otro Producto, false si no es
     * así.
     */
    public boolean existeCodigo(String codigo) {
        ProductoPila puntero = cima;
        do {
            if (codigo.equals(puntero.getCodigo())) {
                return true;
            } else {
                puntero = puntero.getSiguiente();
            }
        } while (puntero != null);
        return false;
    }

    /**
     * Busca todos los Productos de la Lista ingresada, cuyos precios sean
     * mayores a 5000 y menores a 7000, y evitando duplicados por código, los
     * agrega a la Pila.
     *
     * @param lista La Lista desde donde se buscarán esos Productos.
     */
    public void llenar(ListaProductos lista) {
        Producto base = lista.getBase();
        Producto puntero = base;
        do {
            int precio = puntero.getPrecio();
            if (precio > 5000 && precio < 7000 && !existeCodigo(puntero.getCodigo())) {
                agregar(puntero);
            }
            puntero = puntero.getSiguiente();
        } while (puntero != null);
    }

    public void agregar(Producto ingreso) {
        String codigo = ingreso.getNombre();
        String nombre = ingreso.getNombre();
        int precio = ingreso.getPrecio();
        ProductoPila nuevo = new ProductoPila(codigo, nombre, precio);
        if (cima == null) {
            cima = nuevo;
        } else {
            nuevo.setSiguiente(cima);
            this.cima = nuevo;
        }
        ++cantidad;
    }

}
