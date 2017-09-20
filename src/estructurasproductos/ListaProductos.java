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
public class ListaProductos extends base.Lista {
    private Producto base;

    public void agregar(Producto nuevo) throws Exception {
        if (this.base == null) {
            this.base = nuevo;
        }
        else {
            String codigoNuevo = nuevo.getCodigo();
            Producto ultimo = verificarCodigo(codigoNuevo);
            if (ultimo != null) { //el codigo no existe
                ultimo.setSiguiente(nuevo);
                ++cantidad;
            }
            else {
                throw new Exception("El codigo ya existe en la lista!");
            }
        }
    }
    
    public Producto verificarCodigo(String codigo){
        boolean positivo = false;
        Producto puntero = base;
        while (puntero.getSiguiente() != null) {
            positivo = (puntero.getCodigo().equals(codigo));
            if (positivo) {
                break;
            }
            else {
                puntero = puntero.getSiguiente();
            }
        }
        
        if (positivo) { //si existe, impedimos obtener un producto-nodo y devolvemos null
            return null;
        }
        else { //si no existe, simplemente devolvemos el ultimo producto-nodo de la lista
            return puntero;
        }
    }
    
    
}
