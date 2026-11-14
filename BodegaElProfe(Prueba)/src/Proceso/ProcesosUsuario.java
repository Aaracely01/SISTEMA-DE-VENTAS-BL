
package Proceso;

import Modelo.*;
import Vista.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProcesosUsuario {
    static public ArrayList<Usuario> lisUsuarios = new ArrayList<>();
    static DefaultTableModel modeloUsuarios;
    static int intentos = 0;
    public static Usuario usuarioActual = null;   // quién inició sesión

    // ================= LOGIN =================
    public static void CargarUsuarios() {
        if (lisUsuarios.isEmpty()) {
            lisUsuarios.add(new Administrador("70000001", "Carlos", "Villasol", "900000001",
                    "Elprofe", "1234567"));
            lisUsuarios.add(new Empleado("70000002", "Antoni", "Herrera", "900000002",
                    "Antoni01", "contraseña"));
        }
    }

    public static void Presentacion(FormLogin fl) {
        fl.setTitle("INICIO DE SESIÓN");
        fl.setLocationRelativeTo(null);
        fl.setVisible(true);
    }

    public static Usuario ValidarUsuario(String usuario, String clave) {
        for (Usuario u : lisUsuarios) {
            if (u.credencialesCorrectas(usuario, clave)) return u;
        }
        return null;
    }

    static void FalloCredenciales(FormLogin fl) {
        intentos++;
        if (intentos >= 3) {
            JOptionPane.showMessageDialog(null, "Demasiados Intentos Fallidos. El Sistema se Cerrará.",
                    "Acceso Denegado", JOptionPane.ERROR_MESSAGE);
            fl.dispose();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Usuario o Contraseña Incorrectos. Intentos Restantes: " + (3 - intentos),
                    "Error", JOptionPane.ERROR_MESSAGE);
            fl.pwdclave.setText("");
            fl.pwdclave.requestFocus();
        }
    }

    public static void Ingresar(FormLogin fl) {
        String usuario = fl.txtusuario.getText().trim();
        String clave = new String(fl.pwdclave.getPassword());

        if (usuario.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa Usuario y Contraseña", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Usuario u = ValidarUsuario(usuario, clave);
        if (u != null) {
            usuarioActual = u;
            intentos = 0;
            JOptionPane.showMessageDialog(null, "Bienvenido, " + u.getNombreCompleto()
                    + " (" + u.getRol() + ")");
            FrmBodega fm = new FrmBodega();
            ProcesosProducto.Presentacion(fm);
            fm.setTitle(fm.getTitle() + " | " + u.getNombreCompleto() + " (" + u.getRol() + ")");
            AplicarPermisos(fm);
            fl.dispose();
        } else {
            FalloCredenciales(fl);
        }
    }

    // Solo un administrador autenticado puede abrir el registro de usuarios
    public static void AbrirAgregarUsuario(FormLogin fl) {
        String usuario = fl.txtusuario.getText().trim();
        String clave = new String(fl.pwdclave.getPassword());

        if (usuario.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Para agregar usuarios, ingresa tu usuario y contraseña de Administrador"
                    + " y presiona este botón nuevamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Usuario u = ValidarUsuario(usuario, clave);
        if (u == null) {
            FalloCredenciales(fl);
            return;
        }
        if (!u.puedeAdministrar()) {
            JOptionPane.showMessageDialog(null, "Solo el Administrador puede Agregar Usuarios",
                    "Acceso Denegado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        fl.pwdclave.setText("");
        FrmUsuario fu = new FrmUsuario();
        fu.setLocationRelativeTo(null);
        fu.setVisible(true);
    }

    // ================= PERMISOS =================
    public static boolean EsAdministrador() {
        return usuarioActual != null && usuarioActual.puedeAdministrar();
    }

    // Segunda barrera: aunque se active un botón, la acción no se ejecuta
    public static boolean VerificarAdministrador() {
        if (!EsAdministrador()) {
            JOptionPane.showMessageDialog(null, "Esta Acción es Solo para el Administrador",
                    "Acceso Denegado", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    // Primera barrera: desactiva lo que el empleado no puede usar
    public static void AplicarPermisos(FrmBodega fm) {
        boolean admin = EsAdministrador();

        // PRODUCTO: el empleado solo consulta
        fm.txtcodigo.setEnabled(admin);
        fm.txtnombrePro.setEnabled(admin);
        fm.cbxcategoriaPro.setEnabled(admin);
        fm.txtprecioPro.setEnabled(admin);
        fm.txtstockPro.setEnabled(admin);
        fm.txtminPro.setEnabled(admin);
        fm.btnRegisActualiPro.setEnabled(admin);
        fm.btnEliminarProd.setEnabled(admin);
        fm.btnAgregarCate.setEnabled(admin);

        // CLIENTE: el empleado registra, pero no edita ni elimina
        fm.btnEditarCliente.setEnabled(admin);
        fm.btnEliminarCliente.setEnabled(admin);

        // HISTORIAL: el empleado consulta, pero no elimina ventas
        fm.btnEliminarHistorial.setEnabled(admin);
    }

    public static void CerrarSesion(FrmBodega fm) {
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea Cerrar Sesión?",
                "Cerrar Sesión", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            usuarioActual = null;
            intentos = 0;
            ProcesosVenta.ventaActual = new Venta();   // descarta una venta a medias
            FormLogin fl = new FormLogin();
            Presentacion(fl);
            fm.dispose();
        }
    }

    // ================= FORMULARIO DE USUARIOS =================
    public static DefaultTableModel carModeloUsuarios(FrmUsuario fm) {
        String tituloUsu[] = {"N°", "DNI", "Nombre Completo", "Usuario", "Rol"};
        modeloUsuarios = new DefaultTableModel(null, tituloUsu);
        fm.tblmostrarUsu.setModel(modeloUsuarios);
        fm.tblmostrarUsu.setDefaultEditor(Object.class, null);
        mostrarUsuarios(fm);
        return modeloUsuarios;
    }

    public static void CargarComboRol(FrmUsuario fm) {
        fm.cbxusuRol.removeAllItems();
        fm.cbxusuRol.addItem("-Seleccione Rol-");
        fm.cbxusuRol.addItem("Administrador");
        fm.cbxusuRol.addItem("Empleado");
    }

    public static void mostrarUsuarios(FrmUsuario fm) {
        modeloUsuarios.setRowCount(0);
        int num = 1;
        for (Usuario u : lisUsuarios) {
            modeloUsuarios.addRow(u.obtenerUsuarios(num));
            num++;
        }
        fm.lblTotalUsu.setText("Total de Usuarios: " + lisUsuarios.size());
    }

    public static void LimpiarUsuario(FrmUsuario fm) {
        fm.txtusuDni.setText("");
        fm.txtusuNomb.setText("");
        fm.txtusuApell.setText("");
        fm.txtusuTel.setText("");
        fm.txtusuUsuario.setText("");
        fm.pwdusuClave.setText("");
        fm.pwdusuConfirmar.setText("");
        fm.cbxusuRol.setSelectedIndex(0);
        fm.txtusuDni.requestFocus();
    }

    public static void RegistrarUsuario(FrmUsuario fm) {
        try {
            String dni = fm.txtusuDni.getText().trim();
            String nombres = fm.txtusuNomb.getText().trim();
            String apellidos = fm.txtusuApell.getText().trim();
            String telefono = fm.txtusuTel.getText().trim();
            String usuario = fm.txtusuUsuario.getText().trim();
            String clave = new String(fm.pwdusuClave.getPassword());
            String confirmar = new String(fm.pwdusuConfirmar.getPassword());
            int rol = fm.cbxusuRol.getSelectedIndex();

            if (rol == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione un Rol Válido");
                return;
            }
            if (usuario.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese un Nombre de Usuario", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (clave.length() < 4) {
                JOptionPane.showMessageDialog(null, "La Contraseña debe Tener al Menos 4 Caracteres", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!clave.equals(confirmar)) {
                JOptionPane.showMessageDialog(null, "Las Contraseñas no Coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (Usuario u : lisUsuarios) {
                if (u.getUsuario().equalsIgnoreCase(usuario)) {
                    JOptionPane.showMessageDialog(null, "Ese Nombre de Usuario Ya Existe", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (u.getDni().equals(dni)) {
                    JOptionPane.showMessageDialog(null, "Ya Existe un Usuario con ese DNI", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Persona valida DNI (8 dígitos), teléfono (9 dígitos) y nombres
            Usuario nuevo;
            if (rol == 1) {
                nuevo = new Administrador(dni, nombres, apellidos, telefono, usuario, clave);
            } else {
                nuevo = new Empleado(dni, nombres, apellidos, telefono, usuario, clave);
            }
            lisUsuarios.add(nuevo);
            mostrarUsuarios(fm);
            JOptionPane.showMessageDialog(null, "Usuario Registrado Correctamente");
            LimpiarUsuario(fm);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
