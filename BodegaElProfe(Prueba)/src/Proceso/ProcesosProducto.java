package Proceso;

import Modelo.*;
import Vista.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProcesosProducto{
    static public ArrayList<Producto> lisProd = new ArrayList<>();
    static DefaultTableModel modeloProd;
    static Producto prodSel = null;
    public static String productoSeleccionado = null;
    
    public static void CargarCombo(FrmBodega fm) {
        fm.cbxcategoriaPro.removeAllItems();
        fm.cbxcategoriaPro.addItem("-Seleccione Categoria-");
        for (Categoria cat : ProcesosCategoria.lisCate) {
            fm.cbxcategoriaPro.addItem(cat.getCategoria());
        }
        
        if (ProcesosCategoria.cateSeleccionada != null) {
            fm.cbxcategoriaPro.setSelectedItem(ProcesosCategoria.cateSeleccionada);
            ProcesosCategoria.cateSeleccionada = null; 
        }
    }
    
    public static DefaultTableModel carModeloProd(FrmBodega fm){
        String tituloProd[] = {"N°", "Código", "Nombre", "Categoría", "Precio", "Stock", "Stock mín."};
        modeloProd = new DefaultTableModel(null, tituloProd);
        fm.tblmostrarPro.setModel(modeloProd);
        fm.tblmostrarPro.setDefaultEditor(Object.class, null);
        MostrarProductos(lisProd);
        return modeloProd;
    }
    
    public static DefaultTableModel carModeloProd(FrmBuscarProducto fm){
        String tituloProd[] = {"N°", "Código", "Nombre", "Categoría", "Precio", "Stock", "Stock mín."};
        modeloProd = new DefaultTableModel(null, tituloProd);
        fm.tblTodosProductos.setModel(modeloProd);
        fm.tblTodosProductos.setDefaultEditor(Object.class, null);
        MostrarProductos(lisProd);
        return modeloProd;
    }
    
    public static void Presentacion(FrmBodega fm){
        fm.setTitle("SISTEMA DE VENTAS - Bodega El Profe");
        fm.setLocationRelativeTo(null);
        fm.setVisible(true);
    }
    
    public static void LimpiarProducto(FrmBodega fm) {
        fm.txtcodigo.setText("");
        fm.txtnombrePro.setText("");
        fm.cbxcategoriaPro.setSelectedIndex(0);
        fm.txtprecioPro.setText("");
        fm.txtstockPro.setText("");
        fm.txtminPro.setText("");
        fm.txtstockPro.setEnabled(ProcesosUsuario.EsAdministrador());
        prodSel = null;
        fm.tblmostrarPro.clearSelection();
        MostrarProductos(lisProd);
        fm.txtnombrePro.requestFocus();
    }

    public static void CargarComboVentas(FrmBodega fm) {
        fm.cbxproductoVen.removeAllItems();       
        fm.cbxproductoVen.addItem("-Seleccione Producto-");
        for (Producto p : lisProd) {
            fm.cbxproductoVen.addItem(p.getCodigo() + " - " + p.getNombre() + " (stock " + p.getStock() + ")");
        }
        
        if (productoSeleccionado != null) {
            for (int i = 0; i < fm.cbxproductoVen.getItemCount(); i++) {
                // Obtenemos el texto del elemento actual del combo (ej: "Laptop Lenovo - Stock: 15")
                String itemCombo = fm.cbxproductoVen.getItemAt(i);

                // Comparamos si el texto del combo CONTIENE el nombre que seleccionaste
                if (itemCombo.toLowerCase().contains(productoSeleccionado)) {
                    // Si coincide, lo seleccionamos por su índice y salimos del bucle
                    fm.cbxproductoVen.setSelectedIndex(i);
                    break;
                }
            }
            productoSeleccionado = null; 
        }
    }
    
    public static void MostrarProductos(ArrayList<Producto> lista) {
        modeloProd.setRowCount(0);   
        int num = 1;
        for (Producto p : lista) {
            modeloProd.addRow(p.RegistrarDatos(num));
            num++;
        }
    }
    
    public static Producto BuscarPorCodigo(String codigo) {
        for (Producto p : lisProd) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) return p;
        }
        return null;
    }

    public static ArrayList<Producto> BuscarProductos(String texto) {
        ArrayList<Producto> resultado = new ArrayList<>();
        String t = texto.trim().toLowerCase();
        for (Producto p : lisProd) {
            if (p.getCodigo().toLowerCase().contains(t)
                    || p.getNombre().toLowerCase().contains(t)) {
                resultado.add(p);
            }
        }
        return resultado;
    }
    
    public static ArrayList<Producto> BuscarStockMin() {
        ArrayList<Producto> resultado = new ArrayList<>();
        for (Producto p : lisProd) {
            if (p.getStock() < p.getStockMin()){
                resultado.add(p);
            }
        }
        return resultado;
    }
    
    public static void ReingresarDatos(FrmBodega fm) {                                           
        int fila = fm.tblmostrarPro.getSelectedRow();
        if (fila >= 0) {
            prodSel = BuscarPorCodigo(modeloProd.getValueAt(fila, 1).toString());
            if (prodSel != null) {
                fm.txtnombrePro.setText(prodSel.getNombre());
                fm.cbxcategoriaPro.setSelectedItem(prodSel.getCategoria());
                fm.txtprecioPro.setText(String.valueOf(prodSel.getPrecio()));
                fm.txtstockPro.setText(String.valueOf(prodSel.getStock()));
                fm.txtminPro.setText(String.valueOf(prodSel.getStockMin()));
            }
        }
    }      
    
    public static void RegistrarOActualizarProducto(FrmBodega fm){
        if (!ProcesosUsuario.VerificarAdministrador()) return;
        try {
            String codigo = fm.txtcodigo.getText().trim();
            String nombre = fm.txtnombrePro.getText().trim();
            if (fm.cbxcategoriaPro.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Seleccione una Categoria Válida");
                return;
            }
            String categoria = fm.cbxcategoriaPro.getSelectedItem().toString();
            double precio = Double.parseDouble(fm.txtprecioPro.getText().trim());
            int stock = Integer.parseInt(fm.txtstockPro.getText().trim());
            int min = Integer.parseInt(fm.txtminPro.getText().trim());
            ArrayList<Producto> encontrado = BuscarProductos(codigo);
            if (!encontrado.isEmpty()){
                int resp;
                resp = JOptionPane.showConfirmDialog(null, "¿El Producto Ya Existe."
                        + " Desea Actualizarlo?",
                        "Actualizar", JOptionPane.YES_NO_OPTION);
                if (resp == JOptionPane.YES_OPTION) {
                    Producto proActu = encontrado.get(0);
                    proActu.actualizar(codigo, nombre, categoria, precio, stock, min);
                    MostrarProductos(lisProd);
                    CargarComboVentas(fm);     
                    JOptionPane.showMessageDialog(null, "Producto Actualizado Correctamente");
                    LimpiarProducto(fm);
                }
                return;
            }
            Producto p = new Producto(codigo, nombre, categoria, precio, stock, min);
            lisProd.add(p);
            MostrarProductos(lisProd);          
            CargarComboVentas(fm);      
            JOptionPane.showMessageDialog(null, "Producto Registrado Correctamente");
            LimpiarProducto(fm);
            fm.lblTotalPro.setText("Total de Productos: " + lisProd.size());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El Precio y los Stocks"
                    + " Deben Ser Números Válidos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void EliminarProducto(FrmBodega fm){
        if (!ProcesosUsuario.VerificarAdministrador()) return;
        if (prodSel == null) {
            JOptionPane.showMessageDialog(null, "Selecciona un Producto de la Tabla", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int fila, resp;
        fila = fm.tblmostrarPro.getSelectedRow();
        if (fila >= 0) {
            resp = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el Registro?",
                    "Eliminar", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane. YES_OPTION) {
                lisProd.remove(fila);
                modeloProd.removeRow(fila);
                fm.lblTotalPro.setText("Total de Productos: " + lisProd.size());
                MostrarProductos(lisProd);
                CargarComboVentas(fm);
                JOptionPane.showMessageDialog(null, "Producto Eliminado Correctamente");
            }
        }
    }
    
    public static void SeleccionarProducto(FrmBuscarProducto fm, Producto productoSel){
        if (productoSel == null) {
        JOptionPane.showMessageDialog(null, "Selecciona una Categoría de la Tabla para Editar", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
        }
        productoSeleccionado = productoSel.getNombre();
        fm.dispose();
    }
}
