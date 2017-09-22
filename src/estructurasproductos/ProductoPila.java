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
public final class ProductoPila extends base.Nodo {
    private String codigo;
    private String nombre;
    private int precio;
    private ProductoPila siguiente;

    public ProductoPila(String codigo, String nombre, String descripcion, int cantidad, int precio, int stockCritico)  {
        super();
        setCodigo(codigo);
        setNombre(nombre);
        setPrecio(precio);
    }
    
    public ProductoPila(String codigo, String nombre, String descripcion, int cantidad, int precio, int stockCritico, Producto siguiente)  {
        super(siguiente);
        setCodigo(codigo);
        setNombre(nombre);
        setPrecio(precio);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public boolean setCodigo(String codigo) {
        this.codigo = codigo;
        return true;
    }

    public boolean setNombre(String nombre) {
        this.nombre = nombre;
        return true;
    }
    
    public boolean setSiguiente(Producto siguiente) {
        super.setSiguiente(siguiente);
        return true;
    }

    public boolean setPrecio(int precio) {
        if (precio > 0 & precio < 20000) {
            this.precio = precio;
            return true;
        }
        return false;
    }
    
    @Override
    public ProductoPila getSiguiente() {
        return this.siguiente;
    }
}