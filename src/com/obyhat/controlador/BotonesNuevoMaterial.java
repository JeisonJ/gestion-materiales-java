/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obyhat.controlador;

import com.obyhat.modelo.dao.CategoriaDAO;
import com.obyhat.modelo.dao.MaterialesDAO;
import com.obyhat.modelo.dto.CategoriaDTO;
import com.obyhat.vista.paneles.PanelNuevoMaterial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeison Perez <jeisonj_2008@hotmail.com>
 * @ Date 29/06/2017
 * @version 1.0
 */
public class BotonesNuevoMaterial implements ActionListener {

    private PanelNuevoMaterial panelNuevoMaterial;
    private MaterialesDAO materialesDAO;
    private CategoriaDAO categoriaDAO;

    public BotonesNuevoMaterial(PanelNuevoMaterial panelNuevoMaterial) {
        this.panelNuevoMaterial = panelNuevoMaterial;
        this.materialesDAO = new MaterialesDAO();
        this.categoriaDAO  = new CategoriaDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Evento para el boton Guardar.
         */
        if (e.getSource().equals(this.panelNuevoMaterial.getBtnGuardar())) {
            System.out.println("Boton Guardar escuchando");
            this.ingresarMaterial();
            this.panelNuevoMaterial.limpiarFormulario();
        }
        /**
         * Evento para el boton Cancelar.
         */
        if (e.getSource().equals(this.panelNuevoMaterial.getBtnCancelar())) {
            System.out.println("Boton Cancelar escuchando");
            this.panelNuevoMaterial.limpiarFormulario();
        }
        /**
         * Evento para el boton Actualizar.
         */
        if (e.getSource().equals(this.panelNuevoMaterial.getBtnActualizar())) {
            System.out.println("Boton Actualizar escuchando");
        }
        /**
         * Evento para el boton Eliminar.
         */
        if (e.getSource().equals(this.panelNuevoMaterial.getBtnEliminar())) {
            System.out.println("Boton Eliminar escuchando");
        }
    }

    private void ingresarMaterial() {
        if (ValidarDatos().equals("")) {
            this.materialesDAO.Ingresar(this.panelNuevoMaterial.obtenerDatos());
            System.err.println(this.panelNuevoMaterial.obtenerDatos().getIdCategoria() +"\n"+
                    this.panelNuevoMaterial.obtenerDatos().getNombreMaterial());
        } else {
            JOptionPane.showMessageDialog(null, "ERROR!! \n" + ValidarDatos(), 
                    "Validando Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo encargado de llenar el JComboBox que recibe como parametro con los
     * resultados de una consulta a la base de datos.
     *
     * @param comboCategoria <CategoriaDTO>
     */
    public void obtenerCategorias(JComboBox<CategoriaDTO> comboCategoria) {

        List<CategoriaDTO> categorias = this.categoriaDAO.ConsultarTodos();
        comboCategoria.removeAllItems();

        for (int i = 0; i < categorias.size(); i++) {
            System.out.println(categorias.get(i).getNombreCategoria());
            comboCategoria.addItem(
                    new CategoriaDTO(categorias.get(i).getIdCategoria(),
                            categorias.get(i).getNombreCategoria().toString()));
        }
    }

    public String ValidarDatos() {//Metodo para comprobar que los datos esten completos.

        String msj = "";

        if (this.panelNuevoMaterial.getComboCategoria().getSelectedIndex() == 0) {//Si TxtNombreMat esta vacio.
            msj += "Por favor selecione una categoria. \n";
        }
        if (this.panelNuevoMaterial.getNombreMaterial().getText().equals("")) {
            msj += "Por favor escriba un nombre. \n";
        }
        return msj;//devuelve msj.
    }
}
