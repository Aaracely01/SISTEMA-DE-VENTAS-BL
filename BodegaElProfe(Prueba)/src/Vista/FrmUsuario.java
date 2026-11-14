
package Vista;
import Proceso.ProcesosUsuario;
public class FrmUsuario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmUsuario.class.getName());

    public FrmUsuario() {
        initComponents();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ProcesosUsuario.carModeloUsuarios(this);
        ProcesosUsuario.CargarComboRol(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtusuDni = new javax.swing.JTextField();
        txtusuNomb = new javax.swing.JTextField();
        txtusuApell = new javax.swing.JTextField();
        txtusuTel = new javax.swing.JTextField();
        txtusuUsuario = new javax.swing.JTextField();
        pwdusuClave = new javax.swing.JPasswordField();
        pwdusuConfirmar = new javax.swing.JPasswordField();
        cbxusuRol = new javax.swing.JComboBox<>();
        btnRegisUsu = new javax.swing.JButton();
        btnCerrarUsu = new javax.swing.JButton();
        btnLimpiarUsu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmostrarUsu = new javax.swing.JTable();
        lblTotalUsu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRAR USUARIOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtusuDni.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DNI:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(txtusuDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 230, 60));

        txtusuNomb.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombres:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(txtusuNomb, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 230, 60));

        txtusuApell.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellidos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(txtusuApell, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 230, 60));

        txtusuTel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefono:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(txtusuTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 230, 60));

        txtusuUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(txtusuUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 230, 60));

        pwdusuClave.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contraseña:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(pwdusuClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 210, 60));

        pwdusuConfirmar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Confirmar Contraseña:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(pwdusuConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 210, 60));

        cbxusuRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxusuRol.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rol:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14)))); // NOI18N
        jPanel1.add(cbxusuRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 180, 60));

        btnRegisUsu.setText("REGISTRAR");
        btnRegisUsu.addActionListener(this::btnRegisUsuActionPerformed);
        jPanel1.add(btnRegisUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 140, 60));

        btnCerrarUsu.setText("CERRAR");
        btnCerrarUsu.addActionListener(this::btnCerrarUsuActionPerformed);
        jPanel1.add(btnCerrarUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, 120, 60));

        btnLimpiarUsu.setText("LIMPIAR TODO");
        btnLimpiarUsu.addActionListener(this::btnLimpiarUsuActionPerformed);
        jPanel1.add(btnLimpiarUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 130, 60));

        tblmostrarUsu.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblmostrarUsu);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 550, 320));

        lblTotalUsu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalUsu.setText("Total Usuarios:");
        jPanel1.add(lblTotalUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 180, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 900, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisUsuActionPerformed
        ProcesosUsuario.RegistrarUsuario(this);
    }//GEN-LAST:event_btnRegisUsuActionPerformed

    private void btnCerrarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarUsuActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarUsuActionPerformed

    private void btnLimpiarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarUsuActionPerformed
        ProcesosUsuario.LimpiarUsuario(this);
    }//GEN-LAST:event_btnLimpiarUsuActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
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
//        java.awt.EventQueue.invokeLater(() -> new FrmUsuario().setVisible(true));
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarUsu;
    private javax.swing.JButton btnLimpiarUsu;
    private javax.swing.JButton btnRegisUsu;
    public javax.swing.JComboBox<String> cbxusuRol;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblTotalUsu;
    public javax.swing.JPasswordField pwdusuClave;
    public javax.swing.JPasswordField pwdusuConfirmar;
    public javax.swing.JTable tblmostrarUsu;
    public javax.swing.JTextField txtusuApell;
    public javax.swing.JTextField txtusuDni;
    public javax.swing.JTextField txtusuNomb;
    public javax.swing.JTextField txtusuTel;
    public javax.swing.JTextField txtusuUsuario;
    // End of variables declaration//GEN-END:variables
}
