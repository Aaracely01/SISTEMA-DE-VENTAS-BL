
package Proceso;

import Modelo.DetalleVenta;
import Modelo.Venta;
import Vista.FrmBodega;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProcesosHistorial {
    static DefaultTableModel modeloHist, modeloDetHist;
    
    public static DefaultTableModel carModeloHist(FrmBodega fm){
        String tituloHist[] = {"N°", "Código", "Fecha", "DNI", "Cliente", "Ítems", "Total (S/)"};
        modeloHist = new DefaultTableModel(null, tituloHist);
        fm.tblhistorial.setModel(modeloHist);
        fm.tblhistorial.setDefaultEditor(Object.class, null);
        return modeloHist;
    }
    
    public static DefaultTableModel carModeloDetalleHist(FrmBodega fm){
        String tituloDetVent[] = {"N°", "Código", "Producto", "Cantidad", "Precio unit.", "Subtotal"};
        modeloDetHist = new DefaultTableModel(null, tituloDetVent);
        fm.tbldetalleHist.setModel(modeloDetHist);
        fm.tbldetalleHist.setDefaultEditor(Object.class, null);
        return modeloDetHist;
    }
    
    public static void LimpiarHistorial(FrmBodega fm) {
        fm.txtHistorialCodigo.setText("");
        fm.txtHistorialCliente.setText("");
        fm.txtHistorialFecha.setText("");
        mostrarHistorial(ProcesosVenta.lisVentas);
        carModeloDetalleHist(fm).setRowCount(0);
    }
    
    public static void mostrarHistorial(ArrayList<Venta> lista) {
        modeloHist.setRowCount(0);
        int num = 1;
        for (Venta v : lista) {
            modeloHist.addRow(v.RegistrarDatos(num));
            num++;
        }
    }
    
    public static void DetallesVenta(FrmBodega fm, int fila){
        if (fila >= 0) {
            Venta v = ProcesosVenta.lisVentas.get(fila);

            DefaultTableModel modelo = carModeloDetalleHist(fm);
            modelo.setRowCount(0);
            int num = 1;
            for (DetalleVenta d : v.getDetalles()) {
                modelo.addRow(d.RegistrarDatos(num));
                num++;
            }
        }
    }
    
    public static ArrayList<Venta> BuscarVentas(String codigo, String textoCliente, String fecha) {
        ArrayList<Venta> resultado = new ArrayList<>();
        String cod = codigo.trim().toLowerCase();
        String cli = textoCliente.trim().toLowerCase();
        String fec = fecha.trim().toLowerCase();

        for (Venta v : ProcesosVenta.lisVentas) {
            boolean cumpleCodigo = cod.isEmpty() || v.getCodigo().toLowerCase().contains(cod);

            boolean cumpleCliente = true;
            if (!cli.isEmpty()) {
                if (v.getCliente() != null) {
                    String datosCliente = (v.getCliente().getNombres() + " " + v.getCliente().getApellidos() + " " +
                            v.getCliente().getDni()).toLowerCase();
                    cumpleCliente = datosCliente.contains(cli);
                } else {
                    cumpleCliente = false;
                }
            }

            boolean cumpleFecha = fec.isEmpty() || v.getFecha().toString().toLowerCase().contains(fec);
            if (cumpleCodigo && cumpleCliente && cumpleFecha) {
                resultado.add(v);
            }
        }
        return resultado;
    }
    
    public static void eliminarHistorial(FrmBodega fm){
        if (!ProcesosUsuario.VerificarAdministrador()) return;
        int fila = fm.tblhistorial.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona una Venta de la Tabla", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar la Venta?",
                "Eliminar", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            ProcesosVenta.lisVentas.remove(fila);
            modeloHist.removeRow(fila);
            JOptionPane.showMessageDialog(null, "Venta Eliminada Correctamente");
            LimpiarHistorial(fm);
        }
    }
}
