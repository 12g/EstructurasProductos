/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasproductos;

import base.Nodo;

/**
 *
 * @author blamadrid
 */
public class Producto extends base.Nodo {
    private String codigo;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private int precio;
    private int stockCritico;
    private Producto siguiente;

    public Producto(String codigo, String nombre, String descripcion, int cantidad, int precio, int stockCritico)  {
        super();
        try {
            setCodigo(codigo);
            setNombre(nombre);
            this.descripcion = descripcion;
            setCantidad(cantidad);
            setPrecio(precio);
            setStockCritico(stockCritico);
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
    
    public Producto(String codigo, String nombre, String descripcion, int cantidad, int precio, int stockCritico, Producto siguiente)  {
        super(siguiente);
        try {
            setCodigo(codigo);
            setNombre(nombre);
            this.descripcion = descripcion;
            setCantidad(cantidad);
            setPrecio(precio);
            setStockCritico(stockCritico);
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
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
        super.setSiguiente(siguiente);
        return true;
    }

    public boolean setCantidad(int cantidad) {
        if (cantidad > 0) {
            this.cantidad = cantidad;
            return true;
        }
        return false;
    }

    public boolean setPrecio(int precio) {
        if (precio > 0 & precio < 20000) {
            this.precio = precio;
            return true;
        }
        return false;
    }

    public boolean setStockCritico(int stockCritico) {
        if (stockCritico > 0 && stockCritico < this.cantidad) {
            this.stockCritico = stockCritico;
            return true;
        }
        return false;
    }    
    
    @Override
    public Producto getSiguiente() {
        return this.siguiente;
    }
}
