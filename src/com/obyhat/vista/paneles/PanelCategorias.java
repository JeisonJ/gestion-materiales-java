/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obyhat.vista.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.obyhat.controlador.categoria.BotonesCategoria;
import com.obyhat.controlador.categoria.TextoCategoria;
import com.obyhat.modelo.dto.CategoriaDTO;
import com.obyhat.modelo.dto.ObrasDTO;
import com.obyhat.resources.components.Botones;
import com.obyhat.resources.components.Separator;
import com.obyhat.resources.components.labelForm;
import com.obyhat.resources.components.labelTitulo;
import com.obyhat.resources.components.txt;
import com.obyhat.vista.principal.VistaPrincipal;

/**
 *
 * @author Jeis
 */
public class PanelCategorias extends JPanel {

    private DefaultTableModel modeloTabla;
    private String[][] datos = {};
    private String[] column = {"Categoria", "Descripción"};
    private JTable tablaCategoria;

    private JPanel panelCentral, panelIzquierdo;
    private JScrollPane scrollPane, scrollPane2;

    private labelForm labelNombreCat, labelDesCateg;
    private txt txtCategoria, txtCodigo;
    private Separator separatorNom, separatorDes;
    private labelTitulo labelTitulo1, labelTitulo2;
    private Botones btnAgregar, btnModificar, btnEliminar, btnActualizar, btnCancelar, btnBuscar;
    private JTextArea txtDesCategoria;

    private BotonesCategoria BC = new BotonesCategoria(this);
    private TextoCategoria TC = new TextoCategoria(this);

    public PanelCategorias() {

        setLayout(new GridLayout(1, 0, 0, 0));

        scrollPane = new JScrollPane();

        JPanel panelContenedor = new JPanel();
        panelContenedor.setBackground(Color.GRAY);
        panelContenedor.setPreferredSize(new Dimension(950, 550));
        panelContenedor.setLayout(new BorderLayout(0, 0));

        PanelIzquierdo();
        PanelCentral();

        panelContenedor.add(panelIzquierdo, BorderLayout.WEST);
        panelContenedor.add(panelCentral, BorderLayout.CENTER);

        scrollPane.setViewportView(panelContenedor);
        add(scrollPane);

        //this.BC.obtenerCategorias();
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

        labelTitulo1 = new labelTitulo("Registrar Categoria");
        labelTitulo1.setBounds(23, 47, 245, 25);
        panelIzquierdo.add(labelTitulo1);

        txtCodigo = new txt();
        txtCodigo.setEditable(false);
        txtCodigo.setBounds(25, 80, 291, 28);
        panelIzquierdo.add(txtCodigo);

        labelNombreCat = new labelForm("Nombre de la categoria");
        labelNombreCat.setBounds(24, 116, 212, 25);
        panelIzquierdo.add(labelNombreCat);
        txtCategoria = new txt();
        txtCategoria.setBounds(25, 144, 291, 28);
        panelIzquierdo.add(txtCategoria);
        separatorNom = new Separator();
        separatorNom.setBounds(25, 179, 290, 14);
        panelIzquierdo.add(separatorNom);

        labelDesCateg = new labelForm("Descripción (Opcional)");
        labelDesCateg.setBounds(24, 206, 212, 25);
        panelIzquierdo.add(labelDesCateg);
        txtDesCategoria = new JTextArea();
        txtDesCategoria.setBounds(25, 235, 291, 164);
        txtDesCategoria.setLineWrap(true);
        txtDesCategoria.setWrapStyleWord(true);
        txtDesCategoria.setColumns(20);
        txtDesCategoria.setFont(new Font(null, 0, 16));
        txtDesCategoria.setRows(5);
        //scrollPane.setViewportView(txtDesCategoria);
        panelIzquierdo.add(txtDesCategoria);
        separatorDes = new Separator();
        separatorDes.setBounds(25, 407, 290, 14);
        panelIzquierdo.add(separatorDes);

        btnAgregar = new Botones("Agregar");
        btnAgregar.setBounds(25, 490, 90, 35);
        btnAgregar.addActionListener(BC);
        panelIzquierdo.add(btnAgregar);

        btnActualizar = new Botones("Actualizar");
        btnActualizar.setEnabled(false);
        btnActualizar.setBounds(126, 490, 90, 35);
        btnActualizar.addActionListener(BC);
        panelIzquierdo.add(btnActualizar);

        btnCancelar = new Botones("Cancelar");
        //btnCancelar.setEnabled(false);
        btnCancelar.setBounds(226, 490, 90, 35);
        btnCancelar.addActionListener(BC);
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
        //panelCentral.setBackground(new Color(52, 73, 94));
        panelCentral.setLayout(new BorderLayout());

        JPanel PN = new JPanel();
        PN.setLayout(new BorderLayout());
        PN.setBackground(new Color(52, 73, 94));
        dimension(0, PNS, PN);
        labelTitulo2 = new labelTitulo("Categorias Registradas");
        labelTitulo2.setBounds(23, 47, 295, 25);
        panelCentral.add(labelTitulo2);
        panelCentral.add(PN, BorderLayout.NORTH);

        JPanel PO = new JPanel();
        PO.setBackground(new Color(52, 73, 94));
        dimension(PEO, 0, PO);
        panelCentral.add(PO, BorderLayout.WEST);

        PanelInicio PC = new PanelInicio();
        PC.setLayout(new BorderLayout());

        PC.add(Creandotabla(scrollPane2));

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

        btnModificar = new Botones("Modificar Categoria");
        //btnModificar.setEnabled(false);
        btnModificar.setPreferredSize(new Dimension(200, 35));
        //btnModificar.setBounds(126, 490, 90, 35);
        btnModificar.addActionListener(this.BC);
        PCB.add(btnModificar);

        JLabel espacio2 = new JLabel(" ");
        PCB.add(espacio2);

        btnEliminar = new Botones("Eliminar Categoria");
        //btnEliminar.setEnabled(false);
        btnEliminar.setPreferredSize(new Dimension(200, 35));
        btnEliminar.addActionListener(this.BC);
        PCB.add(btnEliminar);

        /*---------------------------------------------------------------------*/
 /*-------------------- Contenedor Panel Central -----------------------*/
    }

    public void llenarFormulario(CategoriaDTO datos) {

        this.txtCodigo.setText(String.valueOf(datos.getIdCategoria()));
        txtCategoria.setText(datos.getNombreCategoria());
        txtDesCategoria.setText(datos.getDesCategoria());
    }

    public void limpiarTabla() {

        for (int i = 0; i < tablaCategoria.getRowCount(); i++) {

            getModeloTabla().removeRow(i);
            i -= 1;
        }
    }

    public final void insertarTabla(Object data[]) {

        this.modeloTabla.addRow(data);
    }

    public void vaciarFormulario() {
        this.txtCodigo.setText("");
        txtCategoria.setText("");
        txtDesCategoria.setText("");
    }

    public int getCodigoInt() {
        try {
            return Integer.parseInt(this.txtCodigo.getText());
        } catch (Exception e) {
            return 0;
        }
    }
      
    public CategoriaDTO ObtenerDatos() {

        return new CategoriaDTO(
                getCodigoInt(),
                this.txtCategoria.getText(),
                this.txtDesCategoria.getText());
    }

    private void dimension(int x, int y, JPanel p) {

        Dimension panelD = new Dimension(x, y);
        p.setPreferredSize(panelD);
        p.setMaximumSize(panelD);
    }

    public JScrollPane Creandotabla(JScrollPane scrollPane) {

        modeloTabla = new DefaultTableModel(datos, column);

        scrollPane = new JScrollPane();
        tablaCategoria = new JTable();
        tablaCategoria.getTableHeader().setFont(new Font("Acme", 0, 16));// Encabezado de tablaCategoria
        //tablaCategoria.getTableHeader().setBackground(Color.black);
        // tablaCategoria.getTableHeader().setForeground(Color.BLUE);
        //tablaCategoria.getTableHeader().setReorderingAllowed(false);// No permite que se muevan las columnas
        tablaCategoria.setModel(modeloTabla);
        scrollPane.setViewportView(tablaCategoria);

        return scrollPane;

    }
    
    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JTable getTablaCategoria() {
        return tablaCategoria;
    }

    public void setTablaCategoria(JTable tablaCategoria) {
        this.tablaCategoria = tablaCategoria;
    }

    public txt getTxtCategoria() {
        return txtCategoria;
    }

    public void setTxtCategoria(txt txtCategoria) {
        this.txtCategoria = txtCategoria;
    }

    public labelTitulo getLabelTitulo1() {
        return labelTitulo1;
    }

    public void setLabelTitulo1(labelTitulo labelTitulo1) {
        this.labelTitulo1 = labelTitulo1;
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

    public JTextArea getTxtDesCategoria() {
        return txtDesCategoria;
    }

    public void setTxtDesCategoria(JTextArea txtDesCategoria) {
        this.txtDesCategoria = txtDesCategoria;
    }

    public Botones getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(Botones btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public Botones getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(Botones btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public Botones getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(Botones btnBuscar) {
        this.btnBuscar = btnBuscar;
    }
//
//    public static void main(String args[]) {
//        JFrame frame = new JFrame("Probando panel individual...");
//        frame.setLayout(new GridLayout());
//        PanelCategorias PA = new PanelCategorias();
//        frame.add(PA);
//        frame.getContentPane().setBackground(Color.WHITE);
//        frame.setBackground(Color.WHITE);
//        frame.setSize(1300, 650);
//        frame.setLocationRelativeTo(null);;
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
}
