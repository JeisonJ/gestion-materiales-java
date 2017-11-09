/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obyhat.vista.principal;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.obyhat.controlador.Controlador;
import com.obyhat.resources.components.MenuItem;
import com.obyhat.resources.components.Separator;
import com.obyhat.vista.paneles.PanelAsignar;
import com.obyhat.vista.paneles.PanelCategorias;
import com.obyhat.vista.paneles.PanelInicio;
import com.obyhat.vista.paneles.PanelMateriales;
import com.obyhat.vista.paneles.PanelObras;
import com.obyhat.vista.paneles.PanelProveedores;
import com.obyhat.vista.paneles.PanelUsuarios;

/**
 *
 * @author Jeis
 */
public class VistaPrincipal extends JFrame {

    private JMenuBar barraMenu;
    private JMenu nombreEmpresa, regMateriales, regCategoria,
            regObra, regProveedores, ayuda, regUsuarios;
    private JButton btnCerrar, btnInicio;
    private JPanel panelCentral;
    private MenuItem itemRegistrar, itemRegistrados, itemAsignar, itemAsignados, itemAsignados2,
            itemCategorias, itemObras, itemProveedores, itemDevoluciones, itemUsuarios,
            itemayuda;
    Controlador c = new Controlador(this);

    private static final Font fontBarraM = new Font("Myriad Pro", 1, 15);
    private static final Font fontItem = new Font("Myriad Pro Light", 1, 13);
    private static final Color fColor = new Color(255, 255, 255);
    private static final Color bMenu = new Color(239, 100, 99);

    //IDENTIFICADORES PARA EL CARDLAYOUT
    final public String VENTANA0 = "Ventana 0";
    final public String VENTANA1 = "Ventana 1";
    final public String VENTANA2 = "Ventana 2";
    final public String VENTANA3 = "Ventana 3";
    final public String VENTANA4 = "Ventana 4";
    final public String VENTANA5 = "Ventana 5";
    final public String VENTANA6 = "Ventana 6";
    final public String VENTANA7 = "Ventana 7";
    final public String VENTANA8 = "Ventana 8";

    //INSTANCIANDO LOS DIFERENTES PANELES A MOSTRAR
    private PanelInicio v0 = new PanelInicio();
    private PanelMateriales v1 = new PanelMateriales();
    private PanelAsignar v2 = new PanelAsignar();
    private PanelCategorias v3 = new PanelCategorias();
    private PanelObras v4 = new PanelObras();
    private PanelProveedores v5 = new PanelProveedores();
    private PanelUsuarios v6 = new PanelUsuarios();
    //private PanelModificacionesMat v7 = new  PanelModificacionesMat();
    //private PanelAsignacionesObras v8 = new PanelAsignacionesObras();

    public VistaPrincipal() {

        this.setSize(1200, 700);
        CreandoMenu();
        Control();
        this.setTitle("Instituto Universitario de Tecnología de Valencia - "
                + "PST II - Proyectos y Construcciones OBYHAT C.A. ®");
        //this.setUndecorated(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void CreandoMenu() {

        barraMenu = new JMenuBar();
        barraMenu.setPreferredSize(new Dimension(0, 80));
        barraMenu.setBackground(bMenu);//Salmon
        setJMenuBar(barraMenu);

        nombreEmpresa = new JMenu();
        nombreEmpresa.setIcon(new ImageIcon(this.getClass().getResource("/com/obyhat/resources/img/S3.png")));
        //nombreEmpresa.setEnabled(false);
        barraMenu.add(nombreEmpresa);

        btnInicio = new JButton();
        btnInicio.setBackground(bMenu);
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/obyhat/resources/img/home.png")));
        btnInicio.setBorderPainted(false);
        btnInicio.setContentAreaFilled(true);
        btnInicio.setFocusPainted(false);
        barraMenu.add(btnInicio);

        regMateriales = new JMenu("  MATERIALES  ");
        regMateriales.setFont(fontBarraM);
        regMateriales.setForeground(fColor);
        itemRegistrar = new MenuItem("Consultar y Registrar Materiales");
        itemRegistrar.setFont(fontItem);
        itemRegistrar.add(new Separator());
        regMateriales.add(itemRegistrar);
        itemRegistrados = new MenuItem("Historial de modificaciones Materiales");
        itemRegistrados.setFont(fontItem);
        itemRegistrados.add(new Separator());
        //regMateriales.add(itemRegistrados);
        itemAsignar = new MenuItem("Asignar materiales a una obra");
        itemAsignar.setFont(fontItem);
        itemAsignar.add(new Separator());
        regMateriales.add(itemAsignar);
        itemAsignados2 = new MenuItem("Historial de Asignaciones de Materiales");
        itemAsignados2.setFont(fontItem);
        itemAsignados2.add(new Separator());
        //regMateriales.add(itemAsignados2);
        barraMenu.add(regMateriales);

        regCategoria = new JMenu("  CATEGORIAS  ");
        regCategoria.setFont(fontBarraM);
        regCategoria.setForeground(fColor);
        itemCategorias = new MenuItem("Consultar y Registrar Categorias");
        itemCategorias.setFont(fontItem);
        regCategoria.add(itemCategorias);
        //barraMenu.add(regCategoria);

        regObra = new JMenu("  OBRAS  ");
        regObra.setFont(fontBarraM);
        regObra.setForeground(fColor);
        itemObras = new MenuItem("Consultar y Registrar Obras");
        itemObras.setFont(fontItem);
        regObra.add(itemObras);
        itemAsignados = new MenuItem("Historial de Asignaciones de Materiales");
        itemAsignados.setFont(fontItem);
        itemAsignados.add(new Separator());
        //regObra.add(itemAsignados);
        barraMenu.add(regObra);

        regProveedores = new JMenu("  PROVEEDORES  ");
        regProveedores.setFont(fontBarraM);
        regProveedores.setForeground(fColor);
        itemProveedores = new MenuItem("Consultar y Registrar Proveedores");
        itemProveedores.setFont(fontItem);
        regProveedores.add(itemProveedores);
        //barraMenu.add(regProveedores);

        regUsuarios = new JMenu("  USUARIOS  ");
        regUsuarios.setFont(fontBarraM);
        regUsuarios.setForeground(fColor);
        itemUsuarios = new MenuItem("Administrar usuarios");
        itemUsuarios.setFont(fontItem);
        regUsuarios.add(itemUsuarios);
        barraMenu.add(regUsuarios);

        ayuda = new JMenu("   AYUDA   ");
        ayuda.setFont(fontBarraM);
        ayuda.setForeground(fColor);
        itemayuda = new MenuItem("Ver ayuda");
        itemayuda.setFont(fontItem);
        ayuda.add(itemayuda);
        barraMenu.add(ayuda);

        barraMenu.add(Box.createHorizontalGlue());

        btnCerrar = new JButton("  SALIR  ");
        btnCerrar.setBackground(new java.awt.Color(240, 114, 113));
        btnCerrar.setFont(new Font("Myriad Pro", 1, 17)); // NOI18N
        btnCerrar.setForeground(fColor);
        btnCerrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(247, 184, 184), 3, true));
        //btnCerrar.setContentAreaFilled(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        //btnCerrar.setFocusPainted(false);
        barraMenu.add(btnCerrar);
        JLabel label1 = new JLabel("     ");
        barraMenu.add(label1);

        /* Contenedor Principal */
        panelCentral = new JPanel();
        panelCentral.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelCentral);
        panelCentral.setLayout(new CardLayout(0, 0));

        //ANADIR LOS PANELES AL CONTENEDOR PRINCIPAL
        panelCentral.add(v0, VENTANA0);
        panelCentral.add(v1, VENTANA1);
        panelCentral.add(v2, VENTANA2);
        panelCentral.add(v3, VENTANA3);
        panelCentral.add(v4, VENTANA4);
        panelCentral.add(v5, VENTANA5);
        panelCentral.add(v6, VENTANA6);
        //panelCentral.add(v7,VENTANA7);
        //panelCentral.add(v8,VENTANA8);

    }

    public void Control() {

        btnInicio.addActionListener(c);
        itemRegistrar.addActionListener(c);
        itemAsignar.addActionListener(c);
        itemAsignados.addActionListener(c);
        itemAsignados2.addActionListener(c);
        itemCategorias.addActionListener(c);
        itemObras.addActionListener(c);
        itemProveedores.addActionListener(c);
        itemUsuarios.addActionListener(c);
        itemRegistrados.addActionListener(c);
        itemayuda.addActionListener(c);
        btnCerrar.addActionListener(c);
    }

    public JPanel getPanelCentral() {
        return panelCentral;
    }

    public void setPanelCentral(JPanel panelCentral) {
        this.panelCentral = panelCentral;
    }

    public JButton getBtnCerrar() {
        return btnCerrar;
    }

    public void setBtnCerrar(JButton btnCerrar) {
        this.btnCerrar = btnCerrar;
    }

    public JButton getBtnInicio() {
        return btnInicio;
    }

    public void setBtnInicio(JButton btnInicio) {
        this.btnInicio = btnInicio;
    }

    public MenuItem getItemRegistrar() {
        return itemRegistrar;
    }

    public void setItemRegistrar(MenuItem itemRegistrar) {
        this.itemRegistrar = itemRegistrar;
    }

    public MenuItem getItemRegistrados() {
        return itemRegistrados;
    }

    public void setItemRegistrados(MenuItem itemRegistrados) {
        this.itemRegistrados = itemRegistrados;
    }

    public MenuItem getItemAsignar() {
        return itemAsignar;
    }

    public void setItemAsignar(MenuItem itemAsignar) {
        this.itemAsignar = itemAsignar;
    }

    public MenuItem getItemAsignados() {
        return itemAsignados;
    }

    public void setItemAsignados(MenuItem itemAsignados) {
        this.itemAsignados = itemAsignados;
    }

    public MenuItem getItemAsignados2() {
        return itemAsignados2;
    }

    public void setItemAsignados2(MenuItem itemAsignados2) {
        this.itemAsignados2 = itemAsignados2;
    }

    public MenuItem getItemCategorias() {
        return itemCategorias;
    }

    public void setItemCategorias(MenuItem itemCategorias) {
        this.itemCategorias = itemCategorias;
    }

    public MenuItem getItemObras() {
        return itemObras;
    }

    public void setItemObras(MenuItem itemObras) {
        this.itemObras = itemObras;
    }

    public MenuItem getItemProveedores() {
        return itemProveedores;
    }

    public void setItemProveedores(MenuItem itemProveedores) {
        this.itemProveedores = itemProveedores;
    }

    public MenuItem getItemDevoluciones() {
        return itemDevoluciones;
    }

    public void setItemDevoluciones(MenuItem itemDevoluciones) {
        this.itemDevoluciones = itemDevoluciones;
    }

    public MenuItem getItemUsuarios() {
        return itemUsuarios;
    }

    public void setItemUsuarios(MenuItem itemUsuarios) {
        this.itemUsuarios = itemUsuarios;
    }

    public MenuItem getItemayuda() {
        return itemayuda;
    }

    public PanelMateriales getV1() {
        return v1;
    }

    public PanelInicio getV0() {
        return v0;
    }

    public PanelAsignar getV2() {
        return v2;
    }

    public PanelCategorias getV3() {
        return v3;
    }

    public PanelObras getV4() {
        return v4;
    }

    public PanelProveedores getV5() {
        return v5;
    }

    public PanelUsuarios getV6() {
        return v6;
    }

    public static void main(String[] args) {
        //Sobreescribiendo el UIManager
        UIManager.put("MenuItem.selectionBackground", new Color(255, 255, 255));
        UIManager.put("Menu.selectionBackground", new Color(240, 114, 113));
        UIManager.put("PopupMenu.border", new LineBorder(new Color(255, 255, 255)));
        UIManager.put("Menu.border", new LineBorder(new Color(239, 100, 99)));

        VistaPrincipal v = new VistaPrincipal();

    }
}
