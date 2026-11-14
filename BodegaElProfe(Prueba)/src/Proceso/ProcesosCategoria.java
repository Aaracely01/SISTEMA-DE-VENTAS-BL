
package Proceso;

import Modelo.Categoria;
import Modelo.Producto;
import Vista.FrmCategoria;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProcesosCategoria {
    static public ArrayList<Categoria> lisCate = new ArrayList<>();
    static DefaultTableModel modeloCate;
    public static String cateSeleccionada = null;
    
    public static DefaultTableModel carModeloCategoria(FrmCategoria fm){
        String tituloCate[] = {"N°", "Categoría"};
        modeloCate = new DefaultTableModel(null, tituloCate);
        fm.tblMostrarCate.setModel(modeloCate);
        fm.tblMostrarCate.setDefaultEditor(Object.class, null);
        mostrarCategorias(lisCate);
        fm.lblTotalCate.setText("Total de Categorias: " + lisCate.size());
        return modeloCate;
    }
    
    public static void cargarCategoria(FrmCategoria fm){
        String categoria = fm.txtCategoria.getText().trim();
        
        if (categoria.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un Nombre en el Campo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (Categoria c : lisCate) {
            if (c.getCategoria().equalsIgnoreCase(categoria)) {
                JOptionPane.showMessageDialog(null, "Ya Existe esa Categoria", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        Categoria cat = new Categoria();
        cat.setCategoria(fm.txtCategoria.getText().trim());
        lisCate.add(cat);
        mostrarCategorias(lisCate);
        JOptionPane.showMessageDialog(null, "Categoría Registrada Correctamente");
        fm.lblTotalCate.setText("Total de Categorias: " + lisCate.size());
        LimpiarCategoria(fm);
    }
    
    public static void LimpiarCategoria(FrmCategoria fm) {
        fm.txtCategoria.setText("");
        fm.txtbuscarCate.setText("");
        fm.tblMostrarCate.clearSelection();
        mostrarCategorias(lisCate);
    }
    
    public static void mostrarCategorias(ArrayList<Categoria> lista) {
        modeloCate.setRowCount(0);   
        int num = 1;
        for (Categoria c : lista) {
            modeloCate.addRow(c.obtenerFila(num));
            num++;
        }
    }

    public static ArrayList<Categoria> buscarCategoria(String texto) {
        ArrayList<Categoria> resultado = new ArrayList<>();
        String t = texto.trim().toLowerCase();
        for (Categoria c : lisCate) {
            if (c.getCategoria().toLowerCase().contains(t)) {
                resultado.add(c);
            }
        }
        return resultado;
    }
    
    public static void eliminarCategoria(FrmCategoria fm){
        int fila = fm.tblMostrarCate.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona una Categoría de la Tabla", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar la Categoría?",
                "Eliminar", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            lisCate.remove(fila);
            modeloCate.removeRow(fila);
            mostrarCategorias(lisCate);
            fm.lblTotalCate.setText("Total de Categorías: " + lisCate.size());
            JOptionPane.showMessageDialog(null, "Categoría Eliminada Correctamente");
            LimpiarCategoria(fm);
        }
    }
    
    public static void editarCategoria(FrmCategoria fm, Categoria catSel){
        if (catSel == null) {
        JOptionPane.showMessageDialog(null, "Selecciona una Categoría de la Tabla para Editar", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
        }
        String nomAntigCate = catSel.getCategoria();
        String categoriaEdit = fm.txtCategoria.getText().trim();

        if (categoriaEdit.isEmpty() || categoriaEdit.equals(catSel.getCategoria())) {
            JOptionPane.showMessageDialog(null, "Ingrese un Nombre Diferente en el Campo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (Categoria c : lisCate) {
            if (c != catSel && c.getCategoria().equalsIgnoreCase(categoriaEdit)) {
                JOptionPane.showMessageDialog(null, "Ya Existe esa Categoria", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea Editar la Categoría?",
                "Editar", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            catSel.actualizar(categoriaEdit);
            for (Producto p : ProcesosProducto.lisProd) {
                if (p.getCategoria().equalsIgnoreCase(nomAntigCate)) {
                    p.setCategoria(categoriaEdit);
                }
            }
            mostrarCategorias(lisCate);
            fm.txtCategoria.setText("");
            JOptionPane.showMessageDialog(null, "Categoría actualizada correctamente");
            LimpiarCategoria(fm);
        }
    }
    
    public static void SeleccionarCategoria(FrmCategoria fm, Categoria catSel){
        if (catSel == null) {
        JOptionPane.showMessageDialog(null, "Selecciona una Categoría de la Tabla para Editar", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
        }
        cateSeleccionada = catSel.getCategoria();
        fm.dispose();
    }
}
