/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obyhat.vista.paneles;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.obyhat.resources.fonts.fontComun;

/** @author Jeis */
public class PanelAsignacionesObras extends javax.swing.JPanel {

  DefaultTableModel modeloTabla;
  String[][] datos = {};
  String column[] = {"Fecha de Asignacion","Obra", "Encargado", "T. Materiales Asignados"};

  public static final Color btnColor = new Color(108, 122, 137);

  public PanelAsignacionesObras() {
    initComponents();
    Creandotabla();
    // Control();

  }

  public void Creandotabla() {

    modeloTabla = new DefaultTableModel(datos, column);
    tablaObras.setModel(modeloTabla);
  }

  /*
   * public void Control(){
   *
   * ControladorObra CO = new ControladorObra(this);
   * btnAgregar.addActionListener(CO); btnModificar.addActionListener(CO);
   * btnEliminar.addActionListener(CO); }
   */

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    panelContenedor = new javax.swing.JPanel();
    labelTitulo2 = new javax.swing.JLabel();
    scrollTabla2 = new javax.swing.JScrollPane();
    tablaObras = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    btnEliminar = new javax.swing.JButton();

    setLayout(new java.awt.GridLayout(1, 0));

    panelContenedor.setBackground(new java.awt.Color(46, 64, 83));

    labelTitulo2.setFont(fontComun.fontTit);
    labelTitulo2.setForeground(new java.awt.Color(255, 255, 255));
    labelTitulo2.setText("Historial de materiales asignados a la obra");

    tablaObras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tablaObras.setModel(
        new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] {}));

    tablaObras.setRowHeight(19);
    scrollTabla2.setViewportView(tablaObras);

    jPanel1.setOpaque(false);

    btnEliminar.setBackground(btnColor);
    btnEliminar.setFont(fontComun.fontBtn);
    btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
    btnEliminar.setText("ATRAS");
    btnEliminar.setBorder(new javax.swing.border.LineBorder(btnColor, 2, true));
    btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnEliminar.setFocusPainted(false);
    btnEliminar.setMargin(new java.awt.Insets(6, 14, 6, 14));
    btnEliminar.setMaximumSize(new java.awt.Dimension(85, 25));
    btnEliminar.setMinimumSize(new java.awt.Dimension(85, 25));
    btnEliminar.setPreferredSize(new java.awt.Dimension(85, 35));
    btnEliminar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnEliminarActionPerformed(evt);
          }
        });
    jPanel1.add(btnEliminar);

    javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
    panelContenedor.setLayout(panelContenedorLayout);
    panelContenedorLayout.setHorizontalGroup(
        panelContenedorLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                panelContenedorLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        panelContenedorLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollTabla2)
                            .addGroup(
                                panelContenedorLayout
                                    .createSequentialGroup()
                                    .addComponent(
                                        labelTitulo2,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        870,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 157, Short.MAX_VALUE))
                            .addComponent(
                                jPanel1,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))
                    .addContainerGap()));
    panelContenedorLayout.setVerticalGroup(
        panelContenedorLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                panelContenedorLayout
                    .createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(
                        labelTitulo2,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        26,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35)
                    .addComponent(
                        scrollTabla2,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        257,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(
                        jPanel1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        50,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(113, Short.MAX_VALUE)));

    add(panelContenedor);
  } // </editor-fold>//GEN-END:initComponents

  private void btnEliminarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnEliminarActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_btnEliminarActionPerformed

  public DefaultTableModel getModeloTabla() {
    return modeloTabla;
  }

  public void setModeloTabla(DefaultTableModel modeloTabla) {
    this.modeloTabla = modeloTabla;
  }

  public JTable getTablaObras() {
    return tablaObras;
  }

  public void setTablaObras(JTable tablaObras) {
    this.tablaObras = tablaObras;
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnEliminar;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JLabel labelTitulo2;
  private javax.swing.JPanel panelContenedor;
  private javax.swing.JScrollPane scrollTabla2;
  private javax.swing.JTable tablaObras;
  // End of variables declaration//GEN-END:variables

//  public static void main(String args[]) {
//
//    PanelAsignacionesObras PA = new PanelAsignacionesObras();
//
//    JFrame frame = new JFrame("Probando panel individual...");
//    frame.setLayout(new GridLayout());
//    frame.add(PA);
//    frame.setSize(1300, 650);
//    frame.setBackground(Color.WHITE);
//    frame.setLocationRelativeTo(null);
//    frame.getContentPane().setBackground(Color.WHITE);
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.setVisible(true);
//  }
}
