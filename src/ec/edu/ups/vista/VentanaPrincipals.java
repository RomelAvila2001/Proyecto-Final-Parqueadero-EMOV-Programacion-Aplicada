/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorAdministradors;
import ec.edu.ups.controlador.ControladorClientes;
import ec.edu.ups.controlador.ControladorContratos;
import ec.edu.ups.controlador.ControladorFacturas;
import ec.edu.ups.controlador.ControladorSitios;
import ec.edu.ups.controlador.ControladorUsuarios;
import ec.edu.ups.controlador.ControladorVehiculos;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;

/**
 *
 * @author NANCY
 */
public class VentanaPrincipals extends javax.swing.JFrame {

    private ControladorClientes controladorCliente;
    private ControladorAdministradors controladorAdministrador;
    private ControladorVehiculos controladorVehiculos;
    private ControladorSitios controladorSitios;
    private ControladorFacturas controladorFacturas;
    private ControladorContratos controladorContratos;
    private ControladorUsuarios controladorUsuarios;
    
    private VentanaCrearClientes ventanaCrearCliente;
    private VentanaGestionVehiculos ventanaGestionVehiculos;
    private VentanaSitios ventanaSitios;
    private VentanaTiketIngresos ventanaTiketIngresos;
    private VentanaCobros ventanaCobros;
    private VentanaAbrirSitios ventanaAbrirSitios;
    private VentanaContratos ventanaContratos;
    private VentanaCrearUsuarios ventanaCrearUsuarios;
    private VentanaListarFacturasYContrato ventanaListarFacturasYContrato;
    private VentanaIniciarSesion ventanaIniciarSesion;
    
    private String keyUnlock;
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipals() {
        initComponents();
        
        controladorCliente= new ControladorClientes();
        controladorAdministrador = new ControladorAdministradors();
        controladorVehiculos = new ControladorVehiculos();
        controladorSitios = new ControladorSitios();
        controladorFacturas = new ControladorFacturas();
        controladorContratos = new ControladorContratos();
        controladorUsuarios = new ControladorUsuarios();
        keyUnlock="Proyecto";
        
        ventanaCrearCliente = new VentanaCrearClientes(controladorCliente);
        ventanaGestionVehiculos = new VentanaGestionVehiculos(controladorVehiculos, controladorCliente, this, ventanaCrearCliente);
        ventanaTiketIngresos = new VentanaTiketIngresos(controladorFacturas, controladorSitios, controladorVehiculos, controladorCliente);
        ventanaSitios = new VentanaSitios(controladorSitios, controladorVehiculos, controladorCliente, this, ventanaGestionVehiculos, ventanaTiketIngresos);
        ventanaCobros = new VentanaCobros(controladorFacturas, controladorSitios);
        ventanaAbrirSitios = new VentanaAbrirSitios(ventanaSitios);
        ventanaContratos = new VentanaContratos(controladorContratos, controladorSitios, controladorVehiculos, controladorCliente, this, ventanaGestionVehiculos);
        ventanaCrearUsuarios = new VentanaCrearUsuarios(controladorUsuarios, keyUnlock);
        ventanaListarFacturasYContrato = new VentanaListarFacturasYContrato(controladorContratos, controladorFacturas);
        ventanaIniciarSesion= new VentanaIniciarSesion(controladorAdministrador,this,controladorUsuarios, keyUnlock);
        
        menuItemCerrarSesion.setVisible(false);
        menuItemCobrar.setVisible(false);
        menuItemContrato.setVisible(false);
        menuItemCrearUsuarios.setVisible(false);
        menuItemGestionVehiculos.setVisible(false);
        menuItemSitios.setVisible(false);
        menuItemCrearCliente.setVisible(false);
        menuItemListarFacturasYContratos.setVisible(false);
        menuItemAbrirSitios.setVisible(false);
        desktopPane.add(ventanaTiketIngresos);
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public JMenuItem getMenuItemAbrirSitios() {
        return menuItemAbrirSitios;
    }

    public void setMenuItemAbrirSitios(JMenuItem menuItemAbrirSitios) {
        this.menuItemAbrirSitios = menuItemAbrirSitios;
    }

    public JMenuItem getMenuItemCerrarSesion() {
        return menuItemCerrarSesion;
    }

    public void setMenuItemCerrarSesion(JMenuItem menuItemCerrarSesion) {
        this.menuItemCerrarSesion = menuItemCerrarSesion;
    }

    public JMenuItem getMenuItemCobrar() {
        return menuItemCobrar;
    }

    public void setMenuItemCobrar(JMenuItem menuItemCobrar) {
        this.menuItemCobrar = menuItemCobrar;
    }

    public JMenuItem getMenuItemContrato() {
        return menuItemContrato;
    }

    public void setMenuItemContrato(JMenuItem menuItemContrato) {
        this.menuItemContrato = menuItemContrato;
    }

    public JMenuItem getMenuItemCrearCliente() {
        return menuItemCrearCliente;
    }

    public void setMenuItemCrearCliente(JMenuItem menuItemCrearCliente) {
        this.menuItemCrearCliente = menuItemCrearCliente;
    }

    public JMenuItem getMenuItemCrearUsuarios() {
        return menuItemCrearUsuarios;
    }

    public void setMenuItemCrearUsuarios(JMenuItem menuItemCrearUsuarios) {
        this.menuItemCrearUsuarios = menuItemCrearUsuarios;
    }

    public JMenuItem getMenuItemGestionVehiculos() {
        return menuItemGestionVehiculos;
    }

    public void setMenuItemGestionVehiculos(JMenuItem menuItemGestionVehiculos) {
        this.menuItemGestionVehiculos = menuItemGestionVehiculos;
    }

    public JMenuItem getMenuItemIniciarSesion() {
        return menuItemIniciarSesion;
    }

    public void setMenuItemIniciarSesion(JMenuItem menuItemIniciarSesion) {
        this.menuItemIniciarSesion = menuItemIniciarSesion;
    }

    public JMenuItem getMenuItemSitios() {
        return menuItemSitios;
    }

    public void setMenuItemSitios(JMenuItem menuItemSitios) {
        this.menuItemSitios = menuItemSitios;
    }

    public JMenuItem getMenuItemListarFacturasYContratos() {
        return menuItemListarFacturasYContratos;
    }

    public void setMenuItemListarFacturasYContratos(JMenuItem menuItemListarFacturasYContratos) {
        this.menuItemListarFacturasYContratos = menuItemListarFacturasYContratos;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        menuItemCrearUsuarios = new javax.swing.JMenuItem();
        menuItemCrearCliente = new javax.swing.JMenuItem();
        menuItemIniciarSesion = new javax.swing.JMenuItem();
        menuItemGestionVehiculos = new javax.swing.JMenuItem();
        menuItemSitios = new javax.swing.JMenuItem();
        menuItemAbrirSitios = new javax.swing.JMenuItem();
        menuItemCobrar = new javax.swing.JMenuItem();
        menuItemContrato = new javax.swing.JMenuItem();
        menuItemListarFacturasYContratos = new javax.swing.JMenuItem();
        menuItemCerrarSesion = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        menuItemCrearUsuarios.setText("Crear Usuarios");
        menuItemCrearUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCrearUsuariosActionPerformed(evt);
            }
        });
        fileMenu.add(menuItemCrearUsuarios);

        menuItemCrearCliente.setMnemonic('o');
        menuItemCrearCliente.setText("Crear Cliente");
        menuItemCrearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCrearClienteActionPerformed(evt);
            }
        });
        fileMenu.add(menuItemCrearCliente);

        menuItemIniciarSesion.setMnemonic('s');
        menuItemIniciarSesion.setText("Iniciar Sesion");
        menuItemIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemIniciarSesionActionPerformed(evt);
            }
        });
        fileMenu.add(menuItemIniciarSesion);

        menuItemGestionVehiculos.setMnemonic('a');
        menuItemGestionVehiculos.setText("Gestio Vehiculos");
        menuItemGestionVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGestionVehiculosActionPerformed(evt);
            }
        });
        fileMenu.add(menuItemGestionVehiculos);

        menuItemSitios.setText("Sitios");
        menuItemSitios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSitiosActionPerformed(evt);
            }
        });
        fileMenu.add(menuItemSitios);

        menuItemAbrirSitios.setText("Abrir Sitios");
        menuItemAbrirSitios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAbrirSitiosActionPerformed(evt);
            }
        });
        fileMenu.add(menuItemAbrirSitios);

        menuItemCobrar.setText("Cobrar");
        menuItemCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCobrarActionPerformed(evt);
            }
        });
        fileMenu.add(menuItemCobrar);

        menuItemContrato.setText("Contrato");
        menuItemContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemContratoActionPerformed(evt);
            }
        });
        fileMenu.add(menuItemContrato);

        menuItemListarFacturasYContratos.setText("Listar Facturas y Contratos");
        menuItemListarFacturasYContratos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListarFacturasYContratosActionPerformed(evt);
            }
        });
        fileMenu.add(menuItemListarFacturasYContratos);

        menuItemCerrarSesion.setText("Cerrar Sesion");
        menuItemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCerrarSesionActionPerformed(evt);
            }
        });
        fileMenu.add(menuItemCerrarSesion);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void menuItemCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCrearClienteActionPerformed
        desktopPane.add(ventanaCrearCliente);
        ventanaCrearCliente.setVisible(true);
    }//GEN-LAST:event_menuItemCrearClienteActionPerformed

    private void menuItemIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemIniciarSesionActionPerformed
        desktopPane.add(ventanaIniciarSesion);
        ventanaIniciarSesion.setVisible(true);
    }//GEN-LAST:event_menuItemIniciarSesionActionPerformed

    private void menuItemGestionVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGestionVehiculosActionPerformed
        desktopPane.add(ventanaGestionVehiculos);
        ventanaGestionVehiculos.setVisible(true);
    }//GEN-LAST:event_menuItemGestionVehiculosActionPerformed

    private void menuItemSitiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSitiosActionPerformed
        desktopPane.add(ventanaSitios);
        ventanaSitios.setVisible(true);
    }//GEN-LAST:event_menuItemSitiosActionPerformed

    private void menuItemCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCobrarActionPerformed
        desktopPane.add(ventanaCobros);
        ventanaCobros.setVisible(true);
    }//GEN-LAST:event_menuItemCobrarActionPerformed

    private void menuItemAbrirSitiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAbrirSitiosActionPerformed
        desktopPane.add(ventanaAbrirSitios);
        ventanaAbrirSitios.setVisible(true);
    }//GEN-LAST:event_menuItemAbrirSitiosActionPerformed

    private void menuItemContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemContratoActionPerformed
        desktopPane.add(ventanaContratos);
        ventanaContratos.setVisible(true);
    }//GEN-LAST:event_menuItemContratoActionPerformed

    private void menuItemCrearUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCrearUsuariosActionPerformed
        desktopPane.add(ventanaCrearUsuarios);
        ventanaCrearUsuarios.setVisible(true);
    }//GEN-LAST:event_menuItemCrearUsuariosActionPerformed

    private void menuItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCerrarSesionActionPerformed
        menuItemCerrarSesion.setVisible(false);
        menuItemCobrar.setVisible(false);
        menuItemContrato.setVisible(false);
        menuItemCrearUsuarios.setVisible(false);
        menuItemGestionVehiculos.setVisible(false);
        menuItemSitios.setVisible(false);
        menuItemCrearCliente.setVisible(false);
        menuItemListarFacturasYContratos.setVisible(false);
        menuItemAbrirSitios.setVisible(false);
        menuItemIniciarSesion.setVisible(true);
    }//GEN-LAST:event_menuItemCerrarSesionActionPerformed

    private void menuItemListarFacturasYContratosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListarFacturasYContratosActionPerformed
        desktopPane.add(ventanaListarFacturasYContrato);
        ventanaListarFacturasYContrato.setVisible(true);
    }//GEN-LAST:event_menuItemListarFacturasYContratosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipals().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemAbrirSitios;
    private javax.swing.JMenuItem menuItemCerrarSesion;
    private javax.swing.JMenuItem menuItemCobrar;
    private javax.swing.JMenuItem menuItemContrato;
    private javax.swing.JMenuItem menuItemCrearCliente;
    private javax.swing.JMenuItem menuItemCrearUsuarios;
    private javax.swing.JMenuItem menuItemGestionVehiculos;
    private javax.swing.JMenuItem menuItemIniciarSesion;
    private javax.swing.JMenuItem menuItemListarFacturasYContratos;
    private javax.swing.JMenuItem menuItemSitios;
    // End of variables declaration//GEN-END:variables

}
