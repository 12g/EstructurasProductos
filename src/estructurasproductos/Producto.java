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

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSiguiente(Producto siguiente) {
        super.setSiguiente(siguiente); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto getSiguiente() {
        return this.siguiente;
    }

    public void setCantidad(int cantidad) throws Exception {
        if (cantidad <= 0) {
            throw new Exception("Debe existir stock.");
        }
        else {
            this.cantidad = cantidad;
        }
    }

    public void setPrecio(int precio) throws Exception {
        if (precio > 20000) {
            throw new Exception("El precio de todo producto no debe superar los $20000.");
        }
        else if (precio <= 0) {
            throw new Exception("El precio de este producto no puede ser $0.");
        }
        else {
            this.precio = precio;
        }
    }

    public void setStockCritico(int stockCritico) throws Exception {
        if (stockCritico <= 0) {
            throw new Exception("El stock critico tiene que ser mayor a 0.");
        }
        else if (stockCritico >= this.cantidad) {
            throw new Exception("El stock critico no debe superar el stock actual.");
        }
        else {
            this.stockCritico = stockCritico;
        }
    }    
    
}
