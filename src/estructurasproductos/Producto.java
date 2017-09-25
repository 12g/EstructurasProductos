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
 * La clase Producto provee abstracciones para poder trabajar como un Nodo de la
 * clase ListaProductos. Nótese que para trabajar con PilaProductos se usa
 * ProductoPila, pues los atributos que esa clase posee no son los mismos que
 * Producto.
 *
 * @author blamadrid
 */
public final class Producto extends base.Nodo {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * El código que identifica al Producto. Se debe respetar como único.
     */
    private String codigo;
    /**
     * El nombre del Producto.
     */
    private String nombre;
    /**
     * La descripción del Producto. Campo opcional.
     */
    private String descripcion;
    /**
     * El stock actual del Producto. En el momento de creación, debe ser mayor a
     * 0.
     */
    private int cantidad;
    /**
     * El precio del Producto en duro.
     */
    private int precio;
    /**
     * El stock que se considera "crítico" para el Producto.
     */
    private int stockCritico;
    /**
     * Un objeto Producto que "sigue" al Producto actual.
     */
    private Producto siguiente;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea un nuevo Producto utilizando el constructor predeterminado de la
     * clase Nodo; dejando el atributo "siguiente" como null, abierto a recibir
     * un valor en el futuro.
     *
     * @param codigo El código identificador
     * @param nombre El nombre del Producto
     * @param descripcion La descripción de éste
     * @param cantidad La cantidad de stock actual
     * @param precio El precio del mismo
     * @param stockCritico El stock que se considera "crítico"
     */
    public Producto(String codigo, String nombre, String descripcion, int cantidad, int precio, int stockCritico) {
        super();
        setCodigo(codigo);
        setNombre(nombre);
        this.descripcion = descripcion;
        setCantidad(cantidad);
        setPrecio(precio);
        setStockCritico(stockCritico);
    }

    /**
     * Crea un nuevo Producto utilizando el constructor extendido de la clase
     * Nodo; asignando un objeto al atributo "siguiente", haciendo referencia a
     * éste para seguir la secuencia de Nodos.
     *
     * @param codigo El código identificador
     * @param nombre El nombre del Producto
     * @param descripcion La descripción de éste
     * @param cantidad La cantidad de stock actual
     * @param precio El precio del mismo
     * @param stockCritico El stock que se considera "crítico"
     * @param siguiente El objeto Producto que sigue al creado en este
     * constructor
     */
    public Producto(String codigo, String nombre, String descripcion, int cantidad, int precio, int stockCritico, Producto siguiente) {
        super(siguiente);
        setCodigo(codigo);
        setNombre(nombre);
        this.descripcion = descripcion;
        setCantidad(cantidad);
        setPrecio(precio);
        setStockCritico(stockCritico);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Recupera el atributo código.
     *
     * @return El código identificador del Producto.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Recupera el atributo nombre.
     *
     * @return El nombre que se dio al Producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Recupera el atributo descripcion.
     *
     * @return La descripción del Producto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Recupera el atributo cantidad.
     *
     * @return La cantidad de stock del Producto.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Recupera el atributo precio.
     *
     * @return El precio del Producto.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Recupera el atributo cantidad.
     *
     * @return La cantidad de stock del Producto.
     */
    public int getStockCritico() {
        return stockCritico;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setters">
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
//</editor-fold>

    @Override
    public Producto getSiguiente() {
        return this.siguiente;
    }

    @Override
    public String toString() {
        String cantSustantivo = "unidad" + ((cantidad == 1) ? "" : "es");
        return "Código: " + codigo + "\n"
                + "Nombre: " + nombre + "\n"
                + "Descripción: " + descripcion + "\n"
                + "Precio: $" + precio + "\n"
                + "Stock actual: " + cantidad + " " + cantSustantivo + "\n"
                + "Stock crítico: " + stockCritico + " " + cantSustantivo;
    }
}
