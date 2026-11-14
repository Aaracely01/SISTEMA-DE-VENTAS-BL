
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venta implements Calcular{
    
    private String codigo;
    private LocalDate fecha;
    private ArrayList<DetalleVenta> detalles = new ArrayList<>();
    static int contador = 0;
    private Cliente cliente;

    public void agregarProducto(Producto p, int cantidad) {
        if (p == null)
            throw new IllegalArgumentException("Selecciona un producto.");
        if (cantidad <= 0)
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");

        DetalleVenta existente = buscarDetalle(p);
        int yaEnVenta = 0;
        if (existente != null) yaEnVenta = existente.getCantidad();

        if (yaEnVenta + cantidad > p.getStock())
            throw new IllegalArgumentException("Stock insuficiente de " + p.getNombre()
                    + ". Disponible: " + p.getStock() + ", ya en la venta: " + yaEnVenta);

        if (existente != null)
            existente.setCantidad(yaEnVenta + cantidad);
        else
            detalles.add(new DetalleVenta(p, cantidad));
    }

    private DetalleVenta buscarDetalle(Producto p) {
        for (DetalleVenta d : detalles) {
            if (d.getProducto() == p) return d;
        }
        return null;
    }

    public void quitarDetalle(int posicion) {
        detalles.remove(posicion);
    }

    public void confirmar(Cliente c) {
        if (c == null)
            throw new IllegalArgumentException("Falta el cliente.");
        if (detalles.isEmpty())
            throw new IllegalArgumentException("La venta no tiene productos.");

        for (DetalleVenta d : detalles) {
            if (d.getCantidad() > d.getProducto().getStock())
                throw new IllegalArgumentException("Stock insuficiente de " + d.getProducto().getNombre());
        }
        for (DetalleVenta d : detalles) {
            Producto p = d.getProducto();
            p.setStock(p.getStock() - d.getCantidad());
        }
        cliente = c;
        contador++;
        codigo = "V" + String.format("%05d", contador);
        fecha = LocalDate.now();
    }

    @Override
    public double calcularTotal() {
        double suma = 0;
        for (DetalleVenta d : detalles) {
            suma += d.calcularTotal();
        }
        return Math.round(suma * 100.0) / 100.0;
    }

    public Object[] RegistrarDatos(int num) {
        Object fila[] = {num, codigo, fecha, cliente.getDni(), cliente.getNombres() + " " + cliente.getApellidos(),
                         detalles.size(), calcularTotal()};
        return fila;
    }

    public String generarBoleta() {
        String t = "BOLETA " + codigo + "\n";
        t += "Fecha: " + fecha + "\n";
        t += "DNI: " + cliente.getDni() + "\n";
        t += "Cliente: " + cliente.getNombres() + "\n";
        t += "----------------------------------------\n";
        for (DetalleVenta d : detalles) {
            t += d.getProducto().getNombre() + "\n";
            t += "    " + d.getCantidad() + " x S/ " + d.getPrecioUnit()
                 + " = S/ " + d.calcularTotal() + "\n";
        }
        t += "----------------------------------------\n";
        t += "TOTAL: S/ " + calcularTotal();
        return t;
    }

    public String getCodigo() {return codigo;}
    public LocalDate getFecha() {return fecha;}
    public Cliente getCliente() {return cliente;}
    public ArrayList<DetalleVenta> getDetalles() {return detalles;}



}
