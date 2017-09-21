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
public class PilaProductos extends base.Pila {
    private Producto cima;
    
    @Override
    public Producto getCima(){
        return cima;
    }
}
