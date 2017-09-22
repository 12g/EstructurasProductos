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
public final class Producto extends base.Nodo {

    private String codigo;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private int precio;
    private int stockCritico;
    private Producto siguiente;

    public Producto(String codigo, String nombre, String descripcion, int cantidad, int precio, int stockCritico) {
        super();
        setCodigo(codigo);
        setNombre(nombre);
        this.descripcion = descripcion;
        setCantidad(cantidad);
        setPrecio(precio);
        setStockCritico(stockCritico);
    }

    public Producto(String codigo, String nombre, String descripcion, int cantidad, int precio, int stockCritico, Producto siguiente) {
        super(siguiente);
        setCodigo(codigo);
        setNombre(nombre);
        this.descripcion = descripcion;
        setCantidad(cantidad);
        setPrecio(precio);
        setStockCritico(stockCritico);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStockCritico() {
        return stockCritico;
    }

    public boolean setCodigo(String codigo) {
        this.codigo = codigo;
        return true;
    }

    public boolean setNombre(String nombre) {
        this.nombre = nombre;
        return true;
    }

    public boolean setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return true;
    }

    public boolean setSiguiente(Producto siguiente) {
        this.siguiente = siguiente;
        return true;
    }

    public boolean setCantidad(int cantidad) {
        if (cantidad < 2) {
            System.out.println("Deben haber al menos 2 unidades de cualquier producto; se ha establecido en 2. ");
            this.cantidad = 2;
        } else {
            this.cantidad = cantidad;
            return true;
        }
        return false;
    }

    public boolean setPrecio(int precio) {
        if (precio < 1) {
            System.out.print("El precio no puede ser $0 o menos; se ha establecido en $1. ");
            this.precio = 1;
        } else if (precio > 20000) {
            System.out.print("El precio del producto no debe superar el límite de $20000; su valor se ha cambiado por éste. ");
            this.precio = 20000;
        } else {
            this.precio = precio;
            return true;
        }
        return false;
    }

    public boolean setStockCritico(int stockCritico) {
        if (stockCritico < 1) {
            System.out.print("El stock crítico no puede 0 o menos; se ha establecido en 1. ");
            this.stockCritico = 1;
        } else if (stockCritico >= this.cantidad) {
            int nuevoStockCritico = this.cantidad - 1;
            System.out.print("El stock crítico no puede ser igual o mayor a la cantidad. Se ha dejado en " + nuevoStockCritico + ". ");
            this.stockCritico = nuevoStockCritico;
        } else {
            this.stockCritico = stockCritico;
            return true;
        }
        return false;
    }

    @Override
    public Producto getSiguiente() {
        return this.siguiente;
    }

    @Override
    public String toString() {
        String cantSustantivo = "unidad" + ((cantidad == 1) ? "" : "es");
        return "-------------------\n"
                + "Código: " + codigo + "\n"
                + "Nombre: " + nombre + "\n"
                + "Descripción: " + descripcion + "\n"
                + "Precio: $" + precio + "\n"
                + "Stock actual: " + cantidad + " " + cantSustantivo + "\n"
                + "Stock crítico: " + stockCritico + " " + cantSustantivo;
    }

}
