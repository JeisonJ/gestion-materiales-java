/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obyhat.vista.paneles;

import com.obyhat.controlador.BotonesNuevoMaterial;
import com.obyhat.modelo.dto.CategoriaDTO;
import com.obyhat.modelo.dto.MaterialesDTO;
import com.obyhat.resources.components.Botones;
import com.obyhat.resources.components.FormTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author jeis
 */
public class PanelNuevoMaterial extends JFrame {

    private JPanel panelFormulario, panelFormularioAuxIzq, panelCentral;
    private JLabel lTituloCategoria;
    private JPanel panelBotones, panelComboCategoria;
    private FormTextField nombreMaterial;
    private JComboBox<CategoriaDTO> comboCategoria;
    private Botones btnCancelar, btnGuardar, btnActualizar,btnEliminar;
    private Color foreground = new Color(31, 31, 31);
    private String[] genero = {"Seleccione una opcion...",
        "Masculino", "Femenino"};

    /**
     * Controlador de esta clase.
     */
    private BotonesNuevoMaterial BNM = new BotonesNuevoMaterial(this);

    public PanelNuevoMaterial() {

        //Perzonalizar ventana.
        this.setTitle("Nuevo material");
        this.setSize(350, 450);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        this.panelCentral = new JPanel();
        this.panelCentral.setLayout(new BorderLayout());
        this.panelCentral.setBackground(new Color(254, 254, 254));
        this.setContentPane(this.panelCentral);

        this.Formulario();
        this.panelCentral.add(this.panelFormulario, BorderLayout.NORTH);
        this.Botones();
        this.panelCentral.add(this.panelBotones, BorderLayout.SOUTH);

        /**
         * Llamada al metodo encargado de llenar el JComboBox de categorias al
         * mostrar la ventana.
         */
        this.llenarComborCategoria();
    }

    /**
     * Metodo que genera el panel que contendra el formulario.
     */
    public void Formulario() {

        this.panelFormulario = new JPanel();
        this.panelFormulario.setOpaque(false);
        this.panelFormulario.setLayout(new GridLayout());
        this.panelFormulario.setBorder(new EmptyBorder(0, 5, 0, 5));
        this.panelFormulario.setPreferredSize(new Dimension(0, 390));

        /**
         * Panel Formulario Izquierdo.
         */
        this.panelFormularioAuxIzq = new JPanel();
        this.panelFormularioAuxIzq.setOpaque(false);
        this.panelFormulario.add(this.panelFormularioAuxIzq);

        this.nombreMaterial = new FormTextField("Nombre del material");
        this.panelFormularioAuxIzq.add(this.nombreMaterial);

//        this.comboCategoria = new FormComboBox();
//        this.comboCategoria.getLabelTitulo().setText("Categorias");
//        this.panelFormularioAuxIzq.add(this.comboCategoria);
        this.panelComboCategoria = new JPanel();
        this.panelComboCategoria.setOpaque(false);
        this.panelComboCategoria.setLayout(null);
        this.panelComboCategoria.setPreferredSize(new Dimension(280, 60));
        this.panelFormularioAuxIzq.add(this.panelComboCategoria);

        this.lTituloCategoria = new JLabel("Categoria");
        this.lTituloCategoria.setForeground(new Color(31, 31, 31));
        this.lTituloCategoria.setBounds(5, 0, 212, 25);
        this.panelComboCategoria.add(lTituloCategoria);

        this.comboCategoria = new JComboBox();
        this.comboCategoria.setBounds(5, 26, 260, 28);
        //this.comboCategoria.addActionListener(BSE);
        this.panelComboCategoria.add(comboCategoria);

    }

    /**
     * Metodo que genera el panel que contendra los botones de la ventana.
     */
    public void Botones() {

        this.panelBotones = new JPanel();
        this.panelBotones.setBackground(new Color(52, 73, 94));
        //this.panelBotones.setLayout(new FlowLayout(2));
        this.panelBotones.setBorder(new EmptyBorder(15, 15, 15, 15));

        this.btnGuardar = new Botones("Guardar");
        this.btnGuardar.setText("Guardar");
        this.btnGuardar.setPreferredSize(new Dimension(85, 35));
        this.btnGuardar.addActionListener(BNM);
        this.panelBotones.add(this.btnGuardar);
        
        this.btnCancelar = new Botones("Cancelar");
        this.btnCancelar.setText("Cancelar");
        this.btnCancelar.setPreferredSize(new Dimension(85, 35));
        this.btnCancelar.addActionListener(BNM);
        this.panelBotones.add(this.btnCancelar);


        this.btnActualizar = new Botones("Actualizar");
        this.btnActualizar.setVisible(false);
        this.btnActualizar.setText("Actualizar");
        this.btnActualizar.setPreferredSize(new Dimension(85, 35));
        //this.btnActualizar.addActionListener(BRP);
        this.panelBotones.add(this.btnActualizar);
        
        this.btnEliminar = new Botones("Eliminar");
        this.btnEliminar.setVisible(false);
        this.btnEliminar.setText("Actualizar");
        this.btnEliminar.setPreferredSize(new Dimension(85, 35));
        //this.btnEliminar.addActionListener(BRP);
        this.panelBotones.add(this.btnEliminar);
    }

    public MaterialesDTO obtenerDatos() {
        return new MaterialesDTO(
            this.comboCategoria.getItemAt(
                comboCategoria.getSelectedIndex()).getIdCategoria(),
            this.nombreMaterial.getText());
    }
    
    public void limpiarFormulario() {
        this.comboCategoria.setSelectedIndex(0);
            this.nombreMaterial.setText("");
    }
//    
//    public void llenarFormulario(Paciente datosPaciente) {
//        
//        this.formNHistoria.setInt(  datosPaciente.getnHistoria());
//        this.formCedula.setInt(     datosPaciente.getCedula()); 
//        this.formNombre.setText(    datosPaciente.getNombre()); 
//        this.formApellido.setText(  datosPaciente.getApellido());
//        this.formFechaNac.setCalendar(new GregorianCalendar());
//        this.formTelefono.setText(  datosPaciente.getTelefono());
//        this.formCorreo.setText(    datosPaciente.getCorreo());
//        this.formGenero.setSelectedIndex(0);
//        this.formEmbarazo.setSelectedNo(true);
//        this.formAlergias.setSelectedNo(true);
//    }
//    

    public void llenarComborCategoria() {
        this.BNM.obtenerCategorias(comboCategoria);
    }

    public Botones getBtnCancelar() {
        return btnCancelar;
    }

    public Botones getBtnGuardar() {
        return btnGuardar;
    }

    public Botones getBtnActualizar() {
        return btnActualizar;
    }

    public Botones getBtnEliminar() {
        return btnEliminar;
    }

    public FormTextField getNombreMaterial() {
        return nombreMaterial;
    }

    public JComboBox<CategoriaDTO> getComboCategoria() {
        return comboCategoria;
    }

    public static void main(String[] args) {

        PanelNuevoMaterial vp = new PanelNuevoMaterial();
        vp.setVisible(true);
    }
}
