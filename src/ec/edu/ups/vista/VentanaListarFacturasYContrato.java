/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorContratos;
import ec.edu.ups.controlador.ControladorFacturas;
import ec.edu.ups.modelo.Contratos;
import ec.edu.ups.modelo.Facturas;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NANCY
 */
public class VentanaListarFacturasYContrato extends javax.swing.JInternalFrame {

    private ControladorFacturas controladorFactura;
    private ControladorContratos controladorContrato;
    /**
     * Creates new form VentanaListarFacturasYContrato
     * @param controladorContrato
     * @param controladorFactura
     */
    public VentanaListarFacturasYContrato(ControladorContratos controladorContrato,ControladorFacturas controladorFactura) {
        initComponents();
        
        this.controladorContrato=controladorContrato;
        this.controladorFactura=controladorFactura;
    }
    
    public void cargarDatosFactura() {
       DefaultTableModel modeloTabla = (DefaultTableModel) tblListar.getModel();

        modeloTabla.setRowCount(0);
        for (Facturas factura : controladorFactura.findAll()) {
            Object[] rowData = {factura.getId(),factura.getFechaYHoraDeIngreso().getTime(),
                factura.getFechaYHoraDeSalida().getTime(),factura.getClientes().getNombre().concat(factura.getClientes().getApellido()),
                factura.getSitios().getId(),factura.getEstado(),factura.getTotal()};
            modeloTabla.addRow(rowData);
        }
        tblListar.setModel(modeloTabla);
    }
    
    public void cargarDatosContrato() {
       DefaultTableModel modeloTabla = (DefaultTableModel) tblListar.getModel();

        modeloTabla.setRowCount(0);
        for (Contratos contrato : controladorContrato.findAll()) {
            Object[] rowData = {contrato.getId(),contrato.getFechaYHoraDeIngreso().getTime(),
                contrato.getFechaYHoraDeSalida().getTime(),contrato.getClientes().getNombre().concat(contrato.getClientes().getApellido()),
                contrato.getSitios().getId(),contrato.getEstado(),contrato.getTotal()};
            modeloTabla.addRow(rowData);
        }
        tblListar.setModel(modeloTabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnListarFacturas = new javax.swing.JButton();
        btnListarContratos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListar = new javax.swing.JTable();
        txtTipoLista = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        btnListarFacturas.setText("Listar Facturas");
        btnListarFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarFacturasActionPerformed(evt);
            }
        });

        btnListarContratos.setText("Listar Contratos");
        btnListarContratos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarContratosActionPerformed(evt);
            }
        });

        tblListar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero", "Fecha Y Hora Ingreso", "Fecha Y Hora Salida", "Cliente", "Sito", "Estado", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblListar);

        txtTipoLista.setEditable(false);
        txtTipoLista.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Listar Facturas y Contratos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnListarFacturas)
                        .addGap(207, 207, 207)
                        .addComponent(btnListarContratos)
                        .addGap(211, 211, 211))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(402, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTipoLista))
                .addGap(324, 324, 324))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtTipoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarFacturas)
                    .addComponent(btnListarContratos))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarFacturasActionPerformed
        cargarDatosFactura();
        txtTipoLista.setText("Lista de Facturas Cargada");
    }//GEN-LAST:event_btnListarFacturasActionPerformed

    private void btnListarContratosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarContratosActionPerformed
        cargarDatosContrato();
        txtTipoLista.setText("Lista de Contratos Cargada");
    }//GEN-LAST:event_btnListarContratosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListarContratos;
    private javax.swing.JButton btnListarFacturas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListar;
    private javax.swing.JTextField txtTipoLista;
    // End of variables declaration//GEN-END:variables
}
