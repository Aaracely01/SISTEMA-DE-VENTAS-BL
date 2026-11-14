
package Modelo;


public class DetalleVenta implements Calcular {
    private Producto producto;
    private int cantidad;
    private double precioUnit;   

    public DetalleVenta(Producto p, int cant) {
        producto = p;
        cantidad = cant;
        precioUnit = p.getPrecio();
    }

    @Override
    public double calcularTotal() {
        return Math.round(precioUnit * cantidad * 100.0) / 100.0;
    }

    public Object[] RegistrarDatos(int num) {
        Object fila[] = {num, producto.getCodigo(), producto.getNombre(),
                         cantidad, precioUnit, calcularTotal()};
        return fila;
    }

    // get y set
    public Producto getProducto() {return producto;}
    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}
    public double getPrecioUnit() {return precioUnit;}


}
