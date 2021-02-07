/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorAdministradors;
import ec.edu.ups.controlador.ControladorUsuarios;
import ec.edu.ups.modelo.Administrador;
import ec.edu.ups.modelo.Usuarios;
import javax.swing.JOptionPane;

/**
 *
 * @author NANCY
 */
public class VentanaIniciarSesion extends javax.swing.JInternalFrame {

    private ControladorAdministradors controladorAdministrador;
    private ControladorUsuarios controladorUsuario;
    private VentanaPrincipals ventanaPrincipal;
    private String KeyUnlock;
    //private String KeyUnlock;
    /**
     * Creates new form VentanaIniciarSesion
     * @param controladorAdministrador
     * @param ventanaPrincipal
     * @param controladorUsuarios
     * @param keyUnlock
     */
    public VentanaIniciarSesion(ControladorAdministradors controladorAdministrador,VentanaPrincipals ventanaPrincipal, ControladorUsuarios controladorUsuarios,String keyUnlock) {
        initComponents();
        
        this.controladorAdministrador=controladorAdministrador;
        this.ventanaPrincipal=ventanaPrincipal;
        this.controladorUsuario=controladorUsuarios;
        this.KeyUnlock=keyUnlock;
        
    }

    public void limpiar() {
        txtCorreo.setText("");
        txtContra.setText("");
        cbxOpcion.setSelectedIndex(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxOpcion = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtContra = new javax.swing.JPasswordField();
        btnIniciarSesion = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Iniciar Sesion");

        jLabel2.setText("Administrador o Usuario");

        cbxOpcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Administrador", "Usuario" }));

        jLabel3.setText("Correo");

        jLabel4.setText("Contraseña");

        btnIniciarSesion.setBackground(new java.awt.Color(0, 0, 0));
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 0));
        btnIniciarSesion.setText("Iniciar Sesion");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxOpcion, 0, 200, Short.MAX_VALUE)
                            .addComponent(txtCorreo)
                            .addComponent(txtContra)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(btnIniciarSesion)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnIniciarSesion)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        String correo = txtCorreo.getText();
        char[] contra = txtContra.getPassword();
        String password = String.valueOf(contra);
        String opcion = cbxOpcion.getSelectedItem().toString();

        if(correo.isEmpty()||password.isEmpty()||opcion.equalsIgnoreCase("Seleccione")){
            JOptionPane.showMessageDialog(this, "Llene todos los campos solicitados");
        }else{
            if (opcion.equals("Administrador")) {
                Administrador admin = controladorAdministrador.iniciarSesion(correo, password);
                if (admin != null) {
                    JOptionPane.showMessageDialog(this, "¡Sesion iniciada con exito! Bienvenido Administrador:"+admin.getNombre());
                    ventanaPrincipal.getMenuItemCerrarSesion().setVisible(true);
                    ventanaPrincipal.getMenuItemCobrar().setVisible(true);
                    ventanaPrincipal.getMenuItemContrato().setVisible(true);
                    ventanaPrincipal.getMenuItemGestionVehiculos().setVisible(true);
                    ventanaPrincipal.getMenuItemSitios().setVisible(true);
                    ventanaPrincipal.getMenuItemCrearUsuarios().setVisible(true);
                    ventanaPrincipal.getMenuItemCrearCliente().setVisible(true);
                    ventanaPrincipal.getMenuItemListarFacturasYContratos().setVisible(true);
                    ventanaPrincipal.getMenuItemAbrirSitios().setVisible(true);
                    limpiar();
                    ventanaPrincipal.getMenuItemIniciarSesion().setVisible(false);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(this, "Usuario no encontrado. Intentelo otra vez");
                }
            }else{
                Usuarios usuario= controladorUsuario.iniciarSesion(correo, password,KeyUnlock);
                if (usuario != null) {
                    System.out.println(usuario);
                    JOptionPane.showMessageDialog(this, "¡Sesion iniciada con exito! Bienvenido Usuario:"+usuario.getApellido());
                    ventanaPrincipal.getMenuItemCerrarSesion().setVisible(true);
                    ventanaPrincipal.getMenuItemCobrar().setVisible(true);
                    ventanaPrincipal.getMenuItemContrato().setVisible(true);
                    ventanaPrincipal.getMenuItemGestionVehiculos().setVisible(true);
                    ventanaPrincipal.getMenuItemSitios().setVisible(true);
                    ventanaPrincipal.getMenuItemCrearCliente().setVisible(true);
                    ventanaPrincipal.getMenuItemListarFacturasYContratos().setVisible(true);
                    limpiar();
                    ventanaPrincipal.getMenuItemIniciarSesion().setVisible(false);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario no encontrado. Intentelo otra vez");
                }
            }
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JComboBox<String> cbxOpcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
