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

    public void setCantidad(int cantidad) throws Exception {
        if (cantidad > 0) {
            this.cantidad = cantidad;
        }
        else {
            throw new Exception("Debe existir stock.");
        }
    }

    public void setPrecio(int precio) throws Exception {
        if (precio > 0) {
            this.precio = precio;
        }
        else {
            throw new Exception("El precio de este producto no puede ser 0.");
        }
    }

    public void setStockCritico(int stockCritico) throws Exception {
        if (stockCritico > 0) {
            this.stockCritico = stockCritico;
        }
        else {
            throw new Exception("El stock critico tiene que ser mayor a 0.");
        }
    }
    
    
}
