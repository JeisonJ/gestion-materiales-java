/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obyhat.vista.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.obyhat.controlador.obra.TextoObras;
import com.mxrck.autocompleter.TextAutoCompleter;
import com.obyhat.controlador.obra.BotonesObras;
import com.obyhat.modelo.dto.ObrasDTO;
import com.obyhat.resources.components.*;

import java.awt.FlowLayout;

/**
 *
 * @author Jeis
 */
public class PanelObras extends JPanel {

    private DefaultTableModel modeloTabla;
    private String[][] datos = {};
    private String[] column = {"Obra", "Encargado", "Telefono", "Dirección"};
    private JTable tablaObras;

    private JPanel panelCentral, panelIzquierdo, PanelInicio;
    private JScrollPane scrollPane, scrollPane2;

    private labelForm labelCedula, labelEncargado, labelDireccion, labelTelefonoObra,
            buscar;
    private txt txtNombreObra, txtEncargadoObra, txtDireccionObra, txtTelefonoObra,
            txtBuscar, txtCodigo;
    private Separator separatorNom, separatorEnc, separatorDir, separatorTel;
    private labelTitulo labelTitulo1, labelTitulo2;
    private Botones btnAgregar, btnModificar, btnEliminar, btnBuscar, btnAsignaciones, btnCancelar, btnActualizar;

    private TextAutoCompleter autoCompletar;

    private BotonesObras CO = new BotonesObras(this);
    ;
    private TextoObras CT = new TextoObras(this);

    public PanelObras() {

        setLayout(new GridLayout(1, 0, 0, 0));
        scrollPane = new JScrollPane();

        JPanel panelContenedor = new JPanel();
        panelContenedor.setBackground(Color.GRAY);
        panelContenedor.setPreferredSize(new Dimension(950, 600));
        panelContenedor.setLayout(new BorderLayout(0, 0));

        PanelIzquierdo();
        PanelCentral();

        panelContenedor.add(panelIzquierdo, BorderLayout.WEST);
        panelContenedor.add(panelCentral, BorderLayout.CENTER);

        scrollPane.setViewportView(panelContenedor);
        add(scrollPane);

        this.CO.obtenerObras();
    }

    private void PanelIzquierdo() {

        /*---------------------------------------------------------------------*/
 /*-------------------- Contenedor Panel Izquierdo ---------------------*/
        // CONSTANTES
        // Separacion del Borde Izquierdo.
        int SBI = 25;

        panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(new Color(46, 64, 83));
        panelIzquierdo.setLayout(null);
        panelIzquierdo.setBorder(new LineBorder(new Color(42, 59, 80), 3, true));

        labelTitulo1 = new labelTitulo("Registrar Obras");
        labelTitulo1.setBounds(23, 47, 245, 25);
        panelIzquierdo.add(labelTitulo1);
        
        txtCodigo = new txt();
        txtCodigo.setEditable(false);
        txtCodigo.setBounds(25, 80, 291, 28);
        panelIzquierdo.add(txtCodigo);

        labelCedula = new labelForm("Nombre de la obra");
        labelCedula.setBounds(24, 116, 212, 25);
        panelIzquierdo.add(labelCedula);
        txtNombreObra = new txt();
        txtNombreObra.setBounds(25, 144, 291, 28);
        txtNombreObra.addFocusListener(CT);
        panelIzquierdo.add(txtNombreObra);
        separatorNom = new Separator();
        separatorNom.setBounds(25, 179, 290, 14);
        panelIzquierdo.add(separatorNom);

        labelEncargado = new labelForm("Encargado de la obra");
        labelEncargado.setBounds(24, 206, 212, 25);
        panelIzquierdo.add(labelEncargado);
        txtEncargadoObra = new txt();
        txtEncargadoObra.setBounds(25, 235, 291, 28);
        panelIzquierdo.add(txtEncargadoObra);
        separatorEnc = new Separator();
        separatorEnc.setBounds(25, 270, 290, 14);
        panelIzquierdo.add(separatorEnc);

        labelTelefonoObra = new labelForm("Telefono");
        labelTelefonoObra.setBounds(24, 300, 135, 25);
        panelIzquierdo.add(labelTelefonoObra);
        txtTelefonoObra = new txt();
        txtTelefonoObra.addKeyListener(CT);
        txtTelefonoObra.setBounds(25, 326, 291, 28);
        panelIzquierdo.add(txtTelefonoObra);
        separatorTel = new Separator();
        separatorTel.setBounds(25, 361, 290, 14);
        panelIzquierdo.add(separatorTel);

        labelDireccion = new labelForm("Direccion");
        labelDireccion.setBounds(24, 390, 135, 25);
        panelIzquierdo.add(labelDireccion);
        txtDireccionObra = new txt();
        txtDireccionObra.setBounds(25, 419, 291, 28);
        panelIzquierdo.add(txtDireccionObra);
        separatorDir = new Separator();
        separatorDir.setBounds(25, 453, 290, 14);
        panelIzquierdo.add(separatorDir);

        btnAgregar = new Botones("Agregar");
        btnAgregar.setBounds(25, 511, 90, 35);
        btnAgregar.addActionListener(CO);
        panelIzquierdo.add(btnAgregar);

        btnActualizar = new Botones("Actualizar");
        btnActualizar.setEnabled(false);
        btnActualizar.setBounds(126, 511, 90, 35);
        btnActualizar.addActionListener(CO);
        panelIzquierdo.add(btnActualizar);

        btnCancelar = new Botones("Cancelar");
        //btnCancelar.setEnabled(false);
        btnCancelar.setBounds(226, 511, 90, 35);
        btnCancelar.addActionListener(CO);
        panelIzquierdo.add(btnCancelar);

        dimension(350, 0, panelIzquierdo);

        /*---------------------------------------------------------------------*/
 /*-------------------- Contenedor Panel Izquierdo ---------------------*/
    }

    private void PanelCentral() {

        /*---------------------------------------------------------------------*/
 /*--------------------- Contenedor Panel Central ----------------------*/
        // CONSTANTES
        //Ancho del Panel Este y Panel Oeste.
        int PEO = 15;

        //Alto del Panel Norte y Panel Sur.
        int PNS = 140;

        panelCentral = new JPanel();
        //panelCentral.setBackground(Color.yellow);
        panelCentral.setLayout(new BorderLayout());

        JPanel PN = new JPanel();
        PN.setLayout(new BorderLayout());
        PN.setBackground(new Color(52, 73, 94));
        dimension(0, PNS, PN);
        labelTitulo2 = new labelTitulo("Obras Registradas");
        labelTitulo2.setBounds(23, 47, 245, 25);
        panelCentral.add(labelTitulo2);

        panelCentral.add(PN, BorderLayout.NORTH);

        JPanel PO = new JPanel();
        PO.setBackground(new Color(52, 73, 94));
        dimension(PEO, 0, PO);
        panelCentral.add(PO, BorderLayout.WEST);

        JPanel PC = new JPanel();
        PC.setLayout(new BorderLayout());

        PC.add(Creandotabla());

        panelCentral.add(PC);

        JPanel PE = new JPanel();
        PE.setBackground(new Color(52, 73, 94));
        dimension(PEO, 0, PE);
        panelCentral.add(PE, BorderLayout.EAST);

        JPanel PS = new JPanel();
        PS.setBackground(new Color(52, 73, 94));
        PS.setLayout(null);
        dimension(0, PNS, PS);
        panelCentral.add(PS, BorderLayout.SOUTH);

        // JPanel Contenedor de botones
        JPanel PCB = new JPanel();
        PCB.setBounds(10, 24, 850, 50);
        PCB.setOpaque(false);
        PCB.setLayout(new FlowLayout(FlowLayout.LEFT));
        PS.add(PCB);

        btnAsignaciones = new Botones("Ver asignaciones");
        //btnAsignaciones.setEnabled(false);
        btnAsignaciones.setPreferredSize(new Dimension(150, 35));
        btnAsignaciones.addActionListener(this.CO);
        //PCB.add(btnAsignaciones);

        JLabel espacio = new JLabel(" ");
        PCB.add(espacio);

        btnModificar = new Botones("Modificar Obra");
        //btnModificar.setEnabled(false);
        btnModificar.setPreferredSize(new Dimension(130, 35));
        //btnModificar.setBounds(126, 490, 90, 35);
        btnModificar.addActionListener(this.CO);
        PCB.add(btnModificar);

        JLabel espacio2 = new JLabel(" ");
        PCB.add(espacio2);

        btnEliminar = new Botones("Eliminar Obra");
        //btnEliminar.setEnabled(false);
        btnEliminar.setPreferredSize(new Dimension(120, 35));
        btnEliminar.addActionListener(this.CO);
        PCB.add(btnEliminar);

        /*---------------------------------------------------------------------*/
 /*-------------------- Contenedor Panel Central -----------------------*/
    }

    private void dimension(int x, int y, JPanel p) {

        Dimension panelD = new Dimension(x, y);
        p.setPreferredSize(panelD);
        p.setMaximumSize(panelD);
    }

    public JScrollPane Creandotabla() {

        modeloTabla = new DefaultTableModel(null, column);

        JScrollPane scrollPane3 = new JScrollPane();
        tablaObras = new JTable();
        tablaObras.getTableHeader().setFont(new Font("Acme", 1, 16));// Encabezado de tablaObras.
        tablaObras.setModel(modeloTabla);
        scrollPane3.setViewportView(tablaObras);

        return scrollPane3;
    }

    public void Autocompletar(Object data[]) {

        autoCompletar.addItem(data[0]);
    }

    public void llenarFormulario(ObrasDTO datos) {

        this.txtCodigo.setText(String.valueOf(datos.getIdObra()));
        txtNombreObra.setText(   datos.getNombreObra());
        txtEncargadoObra.setText(datos.getEncargadoObra());
        txtTelefonoObra.setText( datos.getTelefonoObra());
        txtDireccionObra.setText(datos.getDireccionObra());
    }

    public void limpiarTabla() {

        for (int i = 0; i < getTablaObras().getRowCount(); i++) {

            getModeloTabla().removeRow(i);
            i -= 1;
        }
    }

    public final void insertarTabla(Object data[]) {

        this.modeloTabla.addRow(data);
    }

    public void limpiar() {

        this.txtCodigo.setText("");
        txtNombreObra.setText("");
        txtEncargadoObra.setText("");
        txtTelefonoObra.setText("");
        txtDireccionObra.setText("");
    }

    
    public int getCodigoInt() {
        
        try {
            return Integer.parseInt(this.txtCodigo.getText());
        } catch (Exception e) {
            return 0;
        }
    }
  
    public ObrasDTO ObtenerDatos() {

        return new ObrasDTO(
                this.getCodigoInt(),
                this.txtNombreObra.getText(),
                this.txtEncargadoObra.getText(),
                this.txtTelefonoObra.getText(),
                this.txtDireccionObra.getText());
    }

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

    public Botones getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(Botones btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public Botones getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(Botones btnModificar) {
        this.btnModificar = btnModificar;
    }

    public Botones getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(Botones btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public txt getTxtBuscar() {
        return txtBuscar;
    }

    public Botones getBtnBuscar() {
        return btnBuscar;
    }

    public Botones getBtnAsignaciones() {
        return btnAsignaciones;
    }

    public void setBtnAsignaciones(Botones btnAsignaciones) {
        this.btnAsignaciones = btnAsignaciones;
    }

    public txt getTxtNombreObra() {
        return txtNombreObra;
    }

    public void setTxtNombreObra(txt txtNombreObra) {
        this.txtNombreObra = txtNombreObra;
    }

    public txt getTxtTelefonoObra() {
        return txtTelefonoObra;
    }

    public void setTxtTelefonoObra(txt txtTelefonoObra) {
        this.txtTelefonoObra = txtTelefonoObra;
    }

    public Botones getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(Botones btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public void setBtnBuscar(Botones btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public Botones getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(Botones btnActualizar) {
        this.btnActualizar = btnActualizar;
    }
//
//    public static void main(String args[]) {
//        JFrame frame = new JFrame("Probando panel individual...");
//        frame.setLayout(new GridLayout());
//        PanelObras PA = new PanelObras();
//        frame.add(PA);
//        frame.getContentPane().setBackground(Color.WHITE);
//        frame.setBackground(Color.WHITE);
//        frame.setSize(1300, 650);
//        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
}
