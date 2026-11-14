
package Proceso;

import Modelo.*;
import Vista.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProcesosCliente {
    static public ArrayList<Cliente> lisCliente = new ArrayList<>();
    static DefaultTableModel modeloCliente;
    static Cliente clienteSel = null;
    public static String clienteSeleccionado = null;
    
    public static DefaultTableModel carModeloCliente(FrmBodega fm){
        String tituloCliente[] = {"N°", "DNI", "Nombres", "Apellidos", "Telefono"};
        modeloCliente = new DefaultTableModel(null, tituloCliente);
        fm.tblmostrarClientes.setModel(modeloCliente);
        fm.tblmostrarClientes.setDefaultEditor(Object.class, null);
        mostrarClientes(lisCliente);
        return modeloCliente;
    }
    
    public static DefaultTableModel carModeloCliente(FrmBuscarCliente fm){
        String tituloCliente[] = {"N°", "DNI", "Nombres", "Apellidos", "Telefono"};
        modeloCliente = new DefaultTableModel(null, tituloCliente);
        fm.tblTodosClientes.setModel(modeloCliente);
        fm.tblTodosClientes.setDefaultEditor(Object.class, null);
        mostrarClientes(lisCliente);
        return modeloCliente;
    }
    
    public static void CargarComboClienteVentas(FrmBodega fm) {
        fm.cbxclienteVen.removeAllItems();
        fm.cbxclienteVen.addItem("-Seleccione Cliente-");
        for (Cliente c : lisCliente) {
            fm.cbxclienteVen.addItem(c.getDni());
        }
        
        if (clienteSeleccionado != null) {
            fm.cbxclienteVen.setSelectedItem(clienteSeleccionado);
            clienteSeleccionado = null; 
        }
    }
    
    public static void MostrarDatosCliente(FrmBodega fm){    
        fm.txtclienteDatos.setText(" ");
        
        if(fm.cbxclienteVen.getSelectedIndex() == 0){
            fm.txtclienteDatos.setText("-Elija un Cliente-");
        }

        if (fm.cbxclienteVen.getSelectedIndex() > 0){
            String Dni = fm.cbxclienteVen.getSelectedItem().toString();
            Cliente cli = ProcesosCliente.BuscarPorDni(Dni);
            fm.txtclienteDatos.setText(cli.getNombres() + " " + cli.getApellidos() + " - " + cli.getTelefono());
        } 
    }
    
    public static void mostrarClientes(ArrayList<Cliente> lista) {
        modeloCliente.setRowCount(0);   
        int num = 1;
        for (Cliente c : lista) {
            modeloCliente.addRow(c.obtenerClientes(num));
            num++;
        }
    }
    
    public static void Limpiar(FrmBodega fm) {
        fm.txtclienteDni.setText("");
        fm.txtclienteNomb.setText("");
        fm.txtclienteApell.setText("");
        fm.txtclienteTel.setText("");
        mostrarClientes(lisCliente);
        fm.txtclienteDni.requestFocus();
    }
    
    public static Cliente BuscarPorDni(String dni) {
        for (Cliente c : lisCliente) {
            if (c.getDni().equalsIgnoreCase(dni)) return c;
        }
        return null;
    }
    
    public static void ReingresarDatos(FrmBodega fm) {                                           
        int fila = fm.tblmostrarClientes.getSelectedRow();
        if (fila >= 0) {
            clienteSel = BuscarPorDni(modeloCliente.getValueAt(fila, 1).toString());
            if (clienteSel != null) {
                fm.txtclienteDni.setText(clienteSel.getDni());
                fm.txtclienteNomb.setText(clienteSel.getNombres());
                fm.txtclienteApell.setText(clienteSel.getApellidos());
                fm.txtclienteTel.setText(clienteSel.getTelefono());
            }
        }
    }
    
    public static void RegistrarCliente(FrmBodega fm){
        try {
            String dni = fm.txtclienteDni.getText().trim();
            String nombres = fm.txtclienteNomb.getText().trim();
            String apellidos = fm.txtclienteApell.getText().trim();
            String telefono = fm.txtclienteTel.getText().trim();
            ArrayList<Cliente> encontrado = BuscarClientes(dni);
            if (!encontrado.isEmpty()){
                JOptionPane.showMessageDialog(null, "Este DNI Ya Existe. Ingrese Otro Diferente.");
                return;
            }
            Cliente c = new Cliente(dni, nombres, apellidos, telefono);
            lisCliente.add(c);
            mostrarClientes(lisCliente);          
            CargarComboClienteVentas(fm);      
            JOptionPane.showMessageDialog(null, "Cliente Registrado Correctamente");
            Limpiar(fm);
            fm.lblTotalCliente.setText("Total de Clientes: " + lisCliente.size());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static ArrayList<Cliente> BuscarClientes(String texto) {
        ArrayList<Cliente> resultado = new ArrayList<>();
        String t = texto.trim();
        for (Cliente c : lisCliente) {
            if (c.getDni().toLowerCase().contains(t)
                    || c.getNombres().toLowerCase().contains(t)
                    || c.getApellidos().toLowerCase().contains(t)) {
                resultado.add(c);
            }
        }
        return resultado;
    }
    
    public static void editarCliente(FrmBodega fm){
        if (clienteSel == null) {
            JOptionPane.showMessageDialog(null, "Selecciona un Cliente de la Tabla", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            String dniEdit = fm.txtclienteDni.getText().trim();
            String nombresEdit = fm.txtclienteNomb.getText().trim();
            String apellidosEdit = fm.txtclienteApell.getText().trim();
            String telefonoEdit = fm.txtclienteTel.getText().trim();
            int resp = JOptionPane.showConfirmDialog(null, "¿Desea Editar al Cliente?",
                    "Editar", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                clienteSel.actualizar(dniEdit, nombresEdit, apellidosEdit, telefonoEdit);
                
                mostrarClientes(lisCliente);
                CargarComboClienteVentas(fm);
                JOptionPane.showMessageDialog(null, "Cliente Actualizado Correctamente");
                Limpiar(fm);
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void EliminarCliente(FrmBodega fm){
        if (!ProcesosUsuario.VerificarAdministrador()) return;
        if (clienteSel == null) {
            JOptionPane.showMessageDialog(null, "Selecciona un Cliente de la Tabla", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int fila, resp;
        fila = fm.tblmostrarClientes.getSelectedRow();
        if (fila >= 0) {
            resp = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar al Cliente?",
                    "Eliminar", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane. YES_OPTION) {
                lisCliente.remove(fila);
                modeloCliente.removeRow(fila);
                fm.lblTotalCliente.setText("Total de Clientes: " + lisCliente.size());
                mostrarClientes(lisCliente);
                CargarComboClienteVentas(fm);
                JOptionPane.showMessageDialog(null, "Cliente Eliminado Correctamente");
            }
        }
    }
    
    public static void SeleccionarCliente(FrmBuscarCliente fm, Cliente clienteSel){
        if (clienteSel == null) {
        JOptionPane.showMessageDialog(null, "Selecciona una Categoría de la Tabla para Editar", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
        }
        clienteSeleccionado = clienteSel.getDni();
        fm.dispose();
    }
}
