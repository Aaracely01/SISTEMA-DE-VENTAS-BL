package Vista;
//librerias
import Proceso.*;
import javax.swing.JOptionPane;

public class FrmBodega extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmBodega.class.getName());

    public FrmBodega() {
        initComponents();
        ProcesosProducto.carModeloProd(this);
        ProcesosProducto.CargarCombo(this);
        ProcesosProducto.CargarComboVentas(this);
        ProcesosVenta.carModeloCarrito(this);
        ProcesosHistorial.carModeloHist(this);
        ProcesosHistorial.carModeloDetalleHist(this);
        ProcesosCliente.carModeloCliente(this);
        ProcesosCliente.CargarComboClienteVentas(this);
        ProcesosCliente.MostrarDatosCliente(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        txtnombrePro = new javax.swing.JTextField();
        txtprecioPro = new javax.swing.JTextField();
        cbxcategoriaPro = new javax.swing.JComboBox<>();
        btnRegisActualiPro = new javax.swing.JButton();
        txtstockPro = new javax.swing.JTextField();
        txtminPro = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtbuscarPro = new javax.swing.JTextField();
        btnBuscarPro = new javax.swing.JButton();
        btnNecStock = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmostrarPro = new javax.swing.JTable();
        btnRestablecer = new javax.swing.JButton();
        txtcodigo = new javax.swing.JTextField();
        lblTotalPro = new javax.swing.JLabel();
        btnEliminarProd = new javax.swing.JButton();
        btnAgregarCate = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        txtclienteNomb = new javax.swing.JTextField();
        txtclienteDni = new javax.swing.JTextField();
        txtclienteTel = new javax.swing.JTextField();
        btnRegisCliente = new javax.swing.JButton();
        btnRestablecer1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        txtbuscarCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        txtclienteApell = new javax.swing.JTextField();
        lblTotalCliente = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblmostrarClientes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblcarrito = new javax.swing.JTable();
        btnConfirmarVenta = new javax.swing.JButton();
        btnCancelarVenta = new javax.swing.JButton();
        lbltotalVen = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cbxproductoVen = new javax.swing.JComboBox<>();
        btnAgregarVenta = new javax.swing.JButton();
        spcantidadVen = new javax.swing.JSpinner();
        btnQuitarVenta = new javax.swing.JButton();
        txtclienteDatos = new javax.swing.JTextField();
        cbxclienteVen = new javax.swing.JComboBox<>();
        btnBuscarProVenta = new javax.swing.JButton();
        btnBuscarClienteVenta = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblhistorial = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbldetalleHist = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        txtHistorialCliente = new javax.swing.JTextField();
        txtHistorialFecha = new javax.swing.JTextField();
        txtHistorialCodigo = new javax.swing.JTextField();
        btnBuscarHistorial = new javax.swing.JButton();
        btnLimpiarHistorial = new javax.swing.JButton();
        btnEliminarHistorial = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(860, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtnombrePro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.add(txtnombrePro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 200, 50));

        txtprecioPro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Precio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.add(txtprecioPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 120, 50));

        cbxcategoriaPro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categoria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.add(cbxcategoriaPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 190, -1));

        btnRegisActualiPro.setText("<html>Registrar /<br>Actualizar</html>\n");
        btnRegisActualiPro.addActionListener(this::btnRegisActualiProActionPerformed);
        jPanel4.add(btnRegisActualiPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 130, 50));

        txtstockPro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stock", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.add(txtstockPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 120, 50));

        txtminPro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stock Minimo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.add(txtminPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 120, 50));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Buscar:"), "Buscar:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbuscarPro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Código o Nombre:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel3.add(txtbuscarPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 50));

        btnBuscarPro.setText("Buscar");
        btnBuscarPro.addActionListener(this::btnBuscarProActionPerformed);
        jPanel3.add(btnBuscarPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 110, 50));

        btnNecStock.setText("Se Necesita Stock");
        btnNecStock.addActionListener(this::btnNecStockActionPerformed);
        jPanel3.add(btnNecStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 280, 40));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 310, 130));

        tblmostrarPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblmostrarPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmostrarProMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblmostrarPro);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 780, 310));

        btnRestablecer.setText("Limpiar Todo");
        btnRestablecer.setActionCommand("Restablecer Todo");
        btnRestablecer.addActionListener(this::btnRestablecerActionPerformed);
        jPanel4.add(btnRestablecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 130, 50));

        txtcodigo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Código", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 110, 50));

        lblTotalPro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalPro.setText("Total de Productos:");
        jPanel4.add(lblTotalPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 530, -1, -1));

        btnEliminarProd.setText("Eliminar Producto");
        btnEliminarProd.addActionListener(this::btnEliminarProdActionPerformed);
        jPanel4.add(btnEliminarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 130, 50));

        btnAgregarCate.setText("<html>Agregar/Elegir<br>Categoria</html>");
        btnAgregarCate.addActionListener(this::btnAgregarCateActionPerformed);
        jPanel4.add(btnAgregarCate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 130, 50));

        jTabbedPane2.addTab("PRODUCTO", jPanel4);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRAR CLIENTES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtclienteNomb.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombres:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel10.add(txtclienteNomb, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 190, 50));

        txtclienteDni.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DNI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel10.add(txtclienteDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, 50));

        txtclienteTel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefono:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel10.add(txtclienteTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 130, 50));

        btnRegisCliente.setText("Registrar");
        btnRegisCliente.addActionListener(this::btnRegisClienteActionPerformed);
        jPanel10.add(btnRegisCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 140, 50));

        btnRestablecer1.setText("Limpiar Todo");
        btnRestablecer1.setActionCommand("Restablecer Todo");
        btnRestablecer1.addActionListener(this::btnRestablecer1ActionPerformed);
        jPanel10.add(btnRestablecer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 140, 50));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Buscar:"), "Buscar:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbuscarCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DNI o Nombre/Apellido:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel9.add(txtbuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 280, 50));

        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(this::btnBuscarClienteActionPerformed);
        jPanel9.add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 280, 40));

        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.addActionListener(this::btnEliminarClienteActionPerformed);
        jPanel9.add(btnEliminarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 130, 60));

        btnEditarCliente.setText("Editar");
        btnEditarCliente.addActionListener(this::btnEditarClienteActionPerformed);
        jPanel9.add(btnEditarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, 60));

        jPanel10.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 320, 210));

        txtclienteApell.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellidos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel10.add(txtclienteApell, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 190, 50));

        lblTotalCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalCliente.setText("Total de Clientes:");
        jPanel10.add(lblTotalCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 510, -1, -1));

        tblmostrarClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblmostrarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmostrarClientesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblmostrarClientes);

        jPanel10.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 410, 450));

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 800, 550));

        jTabbedPane2.addTab("CLIENTE", jPanel8);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblcarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblcarrito);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 440, 470));

        btnConfirmarVenta.setText("Confirmar");
        btnConfirmarVenta.addActionListener(this::btnConfirmarVentaActionPerformed);
        jPanel1.add(btnConfirmarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 130, 40));

        btnCancelarVenta.setText("Cancelar");
        btnCancelarVenta.addActionListener(this::btnCancelarVentaActionPerformed);
        jPanel1.add(btnCancelarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 510, 130, 40));

        lbltotalVen.setText("TOTAL:");
        jPanel1.add(lbltotalVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, 140, 20));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar Venta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxproductoVen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel5.add(cbxproductoVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 320, 60));

        btnAgregarVenta.setText("Agregar");
        btnAgregarVenta.addActionListener(this::btnAgregarVentaActionPerformed);
        jPanel5.add(btnAgregarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 130, 50));

        spcantidadVen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cantidad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel5.add(spcantidadVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 130, 60));

        btnQuitarVenta.setText("Quitar");
        btnQuitarVenta.addActionListener(this::btnQuitarVentaActionPerformed);
        jPanel5.add(btnQuitarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 130, 50));

        txtclienteDatos.setEditable(false);
        txtclienteDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel5.add(txtclienteDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 320, 60));

        cbxclienteVen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente (DNI):", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        cbxclienteVen.addItemListener(this::cbxclienteVenItemStateChanged);
        jPanel5.add(cbxclienteVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 160, 60));

        btnBuscarProVenta.setText("Buscar Producto");
        btnBuscarProVenta.addActionListener(this::btnBuscarProVentaActionPerformed);
        jPanel5.add(btnBuscarProVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 130, 60));

        btnBuscarClienteVenta.setText("Buscar Cliente");
        btnBuscarClienteVenta.addActionListener(this::btnBuscarClienteVentaActionPerformed);
        jPanel5.add(btnBuscarClienteVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 130, 60));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 340, 410));

        jTabbedPane2.addTab("VENTAS", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Ventas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblhistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblhistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhistorialMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblhistorial);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 770, 230));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 790, 270));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles de la Venta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbldetalleHist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tbldetalleHist);

        jPanel7.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 770, 120));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 790, 160));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Buscar:"), "Buscar Por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHistorialCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DNI o Nombre/Apellido:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel11.add(txtHistorialCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 210, 50));

        txtHistorialFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha (Día-Mes-Año):", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel11.add(txtHistorialFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 200, 50));

        txtHistorialCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Codigo de Venta:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel11.add(txtHistorialCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 50));

        btnBuscarHistorial.setText("Buscar Venta");
        btnBuscarHistorial.addActionListener(this::btnBuscarHistorialActionPerformed);
        jPanel11.add(btnBuscarHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 200, 40));

        btnLimpiarHistorial.setText("Limpiar Todo");
        btnLimpiarHistorial.addActionListener(this::btnLimpiarHistorialActionPerformed);
        jPanel11.add(btnLimpiarHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 210, 40));

        btnEliminarHistorial.setText("Eliminar");
        btnEliminarHistorial.addActionListener(this::btnEliminarHistorialActionPerformed);
        jPanel11.add(btnEliminarHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 200, 40));

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 790, 130));

        jTabbedPane2.addTab("HISTORIAL", jPanel2);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 820, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("BODEGA \"EL PROFE\"");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        btnCerrarSesion.setText("CERRAR SESION");
        btnCerrarSesion.addActionListener(this::btnCerrarSesionActionPerformed);
        getContentPane().add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 160, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisActualiProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisActualiProActionPerformed
        ProcesosProducto.RegistrarOActualizarProducto(this);
    }//GEN-LAST:event_btnRegisActualiProActionPerformed

    private void btnBuscarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProActionPerformed
        if (ProcesosProducto.BuscarProductos(txtbuscarPro.getText()) != null){
            ProcesosProducto.MostrarProductos(ProcesosProducto.BuscarProductos(txtbuscarPro.getText()));
        } else{
            JOptionPane.showMessageDialog(null, "Producto No Encontrado. Ingrese un Producto Existente.");
        }
    }//GEN-LAST:event_btnBuscarProActionPerformed

    private void btnRestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerActionPerformed
        ProcesosProducto.LimpiarProducto(this);
    }//GEN-LAST:event_btnRestablecerActionPerformed

    private void btnConfirmarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarVentaActionPerformed
        ProcesosVenta.ConfirmarVenta(this);
    }//GEN-LAST:event_btnConfirmarVentaActionPerformed

    private void btnCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVentaActionPerformed
        ProcesosVenta.LimpiarVenta(this);
    }//GEN-LAST:event_btnCancelarVentaActionPerformed

    private void btnAgregarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVentaActionPerformed
        ProcesosVenta.AgregarVenta(this);
    }//GEN-LAST:event_btnAgregarVentaActionPerformed

    private void btnQuitarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarVentaActionPerformed
        ProcesosVenta.QuitarVenta(this);
    }//GEN-LAST:event_btnQuitarVentaActionPerformed

    private void tblhistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhistorialMouseClicked
        int fila = tblhistorial.getSelectedRow();
        ProcesosHistorial.DetallesVenta(this, fila);
    }//GEN-LAST:event_tblhistorialMouseClicked

    private void tblmostrarProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmostrarProMouseClicked
        ProcesosProducto.ReingresarDatos(this);
    }//GEN-LAST:event_tblmostrarProMouseClicked

    private void btnNecStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNecStockActionPerformed
        ProcesosProducto.MostrarProductos(ProcesosProducto.BuscarStockMin());
    }//GEN-LAST:event_btnNecStockActionPerformed

    private void btnEliminarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProdActionPerformed
        ProcesosProducto.EliminarProducto(this);
    }//GEN-LAST:event_btnEliminarProdActionPerformed

    private void btnAgregarCateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCateActionPerformed
        FrmCategoria fmCategoria = new FrmCategoria();
        fmCategoria.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                ProcesosProducto.CargarCombo(FrmBodega.this);
                ProcesosProducto.carModeloProd(FrmBodega.this);
            }
        });
        fmCategoria.setVisible(true);
        fmCategoria.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAgregarCateActionPerformed

    private void btnRegisClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisClienteActionPerformed
        ProcesosCliente.RegistrarCliente(this);
    }//GEN-LAST:event_btnRegisClienteActionPerformed

    private void btnRestablecer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecer1ActionPerformed
        ProcesosCliente.Limpiar(this);
    }//GEN-LAST:event_btnRestablecer1ActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        if (ProcesosCliente.BuscarClientes(txtbuscarCliente.getText()) != null){
            ProcesosCliente.mostrarClientes(ProcesosCliente.BuscarClientes(txtbuscarCliente.getText()));
        } else{
            JOptionPane.showMessageDialog(null, "Cliente No Encontrado. Ingrese un Cliente Existente.");
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        ProcesosCliente.EliminarCliente(this);
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        ProcesosCliente.editarCliente(this);
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void tblmostrarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmostrarClientesMouseClicked
        ProcesosCliente.ReingresarDatos(this);
    }//GEN-LAST:event_tblmostrarClientesMouseClicked

    private void cbxclienteVenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxclienteVenItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            ProcesosCliente.MostrarDatosCliente(this);
        }
    }//GEN-LAST:event_cbxclienteVenItemStateChanged

    private void btnBuscarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHistorialActionPerformed
        if (ProcesosHistorial.BuscarVentas(txtHistorialCodigo.getText(), txtHistorialCliente.getText(),
                txtHistorialFecha.getText()) != null){
            ProcesosHistorial.mostrarHistorial(ProcesosHistorial.BuscarVentas(txtHistorialCodigo.getText(),
                    txtHistorialCliente.getText(), txtHistorialFecha.getText()));
        } else{
            JOptionPane.showMessageDialog(null, "Producto No Encontrado. Ingrese un Producto Existente.");
        }
    }//GEN-LAST:event_btnBuscarHistorialActionPerformed

    private void btnLimpiarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarHistorialActionPerformed
        ProcesosHistorial.LimpiarHistorial(this);
    }//GEN-LAST:event_btnLimpiarHistorialActionPerformed

    private void btnEliminarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarHistorialActionPerformed
        ProcesosHistorial.eliminarHistorial(this);
    }//GEN-LAST:event_btnEliminarHistorialActionPerformed

    private void btnBuscarProVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProVentaActionPerformed
        FrmBuscarProducto fmBuscoPro = new FrmBuscarProducto();
        fmBuscoPro.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                ProcesosProducto.CargarComboVentas(FrmBodega.this);
                ProcesosProducto.carModeloProd(FrmBodega.this);
            }
        });
        fmBuscoPro.setVisible(true);
        fmBuscoPro.setLocationRelativeTo(null);    
    }//GEN-LAST:event_btnBuscarProVentaActionPerformed

    private void btnBuscarClienteVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteVentaActionPerformed
        FrmBuscarCliente fmBuscoCli = new FrmBuscarCliente();
        fmBuscoCli.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                ProcesosCliente.CargarComboClienteVentas(FrmBodega.this);
                ProcesosCliente.carModeloCliente(FrmBodega.this);
            }
        });
        fmBuscoCli.setVisible(true);
        fmBuscoCli.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnBuscarClienteVentaActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        ProcesosUsuario.CerrarSesion(this);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalbtnRegistrarProductondFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
//            logger.log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> new FrmBodega().setVisible(true));
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarCate;
    public javax.swing.JButton btnAgregarVenta;
    public javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarClienteVenta;
    public javax.swing.JButton btnBuscarHistorial;
    public javax.swing.JButton btnBuscarPro;
    private javax.swing.JButton btnBuscarProVenta;
    public javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnCerrarSesion;
    public javax.swing.JButton btnConfirmarVenta;
    public javax.swing.JButton btnEditarCliente;
    public javax.swing.JButton btnEliminarCliente;
    public javax.swing.JButton btnEliminarHistorial;
    public javax.swing.JButton btnEliminarProd;
    public javax.swing.JButton btnLimpiarHistorial;
    private javax.swing.JButton btnNecStock;
    public javax.swing.JButton btnQuitarVenta;
    public javax.swing.JButton btnRegisActualiPro;
    public javax.swing.JButton btnRegisCliente;
    public javax.swing.JButton btnRestablecer;
    public javax.swing.JButton btnRestablecer1;
    public javax.swing.JComboBox<String> cbxcategoriaPro;
    public javax.swing.JComboBox<String> cbxclienteVen;
    public javax.swing.JComboBox<String> cbxproductoVen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane2;
    public javax.swing.JLabel lblTotalCliente;
    public javax.swing.JLabel lblTotalPro;
    public javax.swing.JLabel lbltotalVen;
    public javax.swing.JSpinner spcantidadVen;
    public javax.swing.JTable tblcarrito;
    public javax.swing.JTable tbldetalleHist;
    public javax.swing.JTable tblhistorial;
    public javax.swing.JTable tblmostrarClientes;
    public javax.swing.JTable tblmostrarPro;
    public javax.swing.JTextField txtHistorialCliente;
    public javax.swing.JTextField txtHistorialCodigo;
    public javax.swing.JTextField txtHistorialFecha;
    public javax.swing.JTextField txtbuscarCliente;
    public javax.swing.JTextField txtbuscarPro;
    public javax.swing.JTextField txtclienteApell;
    public javax.swing.JTextField txtclienteDatos;
    public javax.swing.JTextField txtclienteDni;
    public javax.swing.JTextField txtclienteNomb;
    public javax.swing.JTextField txtclienteTel;
    public javax.swing.JTextField txtcodigo;
    public javax.swing.JTextField txtminPro;
    public javax.swing.JTextField txtnombrePro;
    public javax.swing.JTextField txtprecioPro;
    public javax.swing.JTextField txtstockPro;
    // End of variables declaration//GEN-END:variables
}

