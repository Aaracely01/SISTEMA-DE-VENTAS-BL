
package Proceso;
//libreria
import Modelo.*;
import Vista.FrmBodega;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class ProcesosVenta {
    static ArrayList<Venta> lisVentas = new ArrayList<>();
    static DefaultTableModel modeloCarrito;
 
    static Venta ventaActual = new Venta();
    
    public static DefaultTableModel carModeloCarrito(FrmBodega fm){
        String tituloDeCar[] = {"N°", "Código", "Producto", "Cantidad", "Precio unit.", "Subtotal"};
        modeloCarrito = new DefaultTableModel(null, tituloDeCar);
        fm.tblcarrito.setModel(modeloCarrito);
        fm.tblcarrito.setDefaultEditor(Object.class, null);
        fm.spcantidadVen.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
        return modeloCarrito;
    }
    
    public static void MostrarCarrito(FrmBodega fm) {
        modeloCarrito.setRowCount(0);
        int num = 1;
        for (DetalleVenta d : ventaActual.getDetalles()) {
            modeloCarrito.addRow(d.RegistrarDatos(num));
            num++;
        }
        fm.lbltotalVen.setText("TOTAL: S/ " + ventaActual.calcularTotal());
    }

    public static void LimpiarVenta(FrmBodega fm) {
        fm.cbxclienteVen.setSelectedIndex(0);
        fm.spcantidadVen.setValue(1);
        ventaActual = new Venta();
        MostrarCarrito(fm);
    }
    
    public static void AgregarVenta(FrmBodega fm) {                                                
        int pos = fm.cbxproductoVen.getSelectedIndex();
        
        if (pos == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona un Producto para Continuar", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (pos < 0) {
            JOptionPane.showMessageDialog(null, "No hay Productos Disponibles", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Producto p = ProcesosProducto.lisProd.get(pos - 1);
            int cant = Integer.parseInt(fm.spcantidadVen.getValue().toString());
            ventaActual.agregarProducto(p, cant);
            MostrarCarrito(fm);
            fm.spcantidadVen.setValue(1);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                               

     public static void ConfirmarVenta(FrmBodega fm) {                                                  
        try {
            String Dni = fm.cbxclienteVen.getSelectedItem().toString();
            if(fm.cbxclienteVen.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Seleccione un Cliente para Continuar");
                return;
            }
            Cliente cli = ProcesosCliente.BuscarPorDni(Dni);
            ventaActual.confirmar(cli);
            lisVentas.add(ventaActual);

            javax.swing.JTextArea area = new javax.swing.JTextArea(ventaActual.generarBoleta());
            area.setEditable(false);
            area.setFont(new java.awt.Font("Monospaced", 0, 13));
            JOptionPane.showMessageDialog(null, area, "Venta registrada", JOptionPane.INFORMATION_MESSAGE);

            LimpiarVenta(fm);
            ProcesosProducto.CargarComboVentas(fm);
            ProcesosProducto.MostrarProductos(ProcesosProducto.lisProd);
            ProcesosHistorial.mostrarHistorial(lisVentas);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     
    public static void QuitarVenta(FrmBodega fm) {                                               
        int fila = fm.tblcarrito.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona una Fila del Carrito", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ventaActual.quitarDetalle(fila);
        MostrarCarrito(fm);
    }
}
