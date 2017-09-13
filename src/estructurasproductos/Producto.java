/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasproductos;

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

    public Producto(String codigo, String nombre, String descripcion, int cantidad, int precio, int stockCritico, Producto siguiente)  {
        super(siguiente);
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.stockCritico = stockCritico;
    }
    
    
}
