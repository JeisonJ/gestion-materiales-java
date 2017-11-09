package com.obyhat.controlador;

import com.obyhat.modelo.dao.CategoriaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.obyhat.modelo.dao.MaterialesDAO;
import com.obyhat.modelo.dto.CategoriaDTO;
import com.obyhat.modelo.dto.MaterialesDTO;
import com.obyhat.reporte.material.reporteMaterial;
import com.obyhat.vista.paneles.PanelMateriales;
import java.util.List;
import javax.swing.JComboBox;

public class BotonesMaterial implements ActionListener {

    private PanelMateriales PM;
    private MaterialesDAO materialesDAO;
    private String nombreMaterial;
    private CategoriaDAO miCategoria;
    private reporteMaterial reporteUsuario;

    public BotonesMaterial(PanelMateriales PM) {

        this.PM = PM;
        this.materialesDAO = new MaterialesDAO();
        this.miCategoria = new CategoriaDAO();
        this.reporteUsuario = new reporteMaterial();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == PM.getBtnAgregar()) {

            System.out.println("Boton Guardar escuchando a Skrillex");

                if (ValidarDatos().equals("")) {
                    try {
                        this.materialesDAO.Ingresar(this.PM.ObtenerDatos());
                        //System.err.println(PM.ObtenerDatos().getIdCategoria());
                        this.PM.LimpiarCampos();

                    } catch (Exception e2) {
                        System.out.println("Error al insertar e2" + e2);
                    }
                } else {

                    JOptionPane.showMessageDialog(null, "ERROR!! \n" + ValidarDatos(), "Validando Datos", JOptionPane.ERROR_MESSAGE);
                }

            this.ObtenerMateriales();
        }

        if (e.getSource() == PM.getBtnActualizar()) {

            System.out.println("Boton Actualizar Escuchando");
            this.actualizarUsuario();
            this.PM.getBtnAgregar().setEnabled(true);
            this.PM.getBtnActualizar().setEnabled(true);
            
            this.ObtenerMateriales();
        }
        if (e.getSource() == this.PM.getBtnReporte()) {

            System.out.println("Boton Buscar Escuchando");

            this.reporteUsuario.generarReporte();

        }

        if (e.getSource() == PM.getBtnBuscarMat()) {
            System.out.println("Escuchando boton actualizar");
            ObtenerMateriales();
        }

        if (e.getSource() == PM.getBtnModificar()) {

            System.out.println("Boton 'Modificar' escuchando Rock!");

            //Obtenet la Fila seleccionada.
            int filaSeleccionada = PM.getTablaMaterialesReg().getSelectedRow();

            if (filaSeleccionada >= 0) {

                this.nombreMaterial = PM.getTablaMaterialesReg().getValueAt(filaSeleccionada, 0).toString();
                System.err.println(nombreMaterial);

                int opc = JOptionPane.showConfirmDialog(null, " Desea modificar el material: " + nombreMaterial + "? ", "Confirmar modificacion ",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                /*
                	 * Le preguntare al usuario si en realidad desea modificar la categoria.
                 */

                if (opc == 0) {

                    try {

                        PM.getModeloTabla().removeRow(filaSeleccionada);
                        MaterialesDTO consultarMaterial = materialesDAO.Consultar(nombreMaterial);
                        PM.llenarFormulario(consultarMaterial);
                        //JOptionPane.showConfirmDialog(null,consultarMaterial.getNombreMaterial()+"\n"+consultarMaterial.getCantidadMaterial()+"\n"+consultarMaterial.getFechaRegistro());

                        PM.getBtnAgregar().setEnabled(true);
                        PM.getBtnActualizar().setEnabled(true);

                        //nombre = consultarMaterial.getNombreMaterial();
                        this.getNombre(nombreMaterial);

                    } catch (Exception e2) {

                        JOptionPane.showMessageDialog(null, "La cedula no existe", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } else {

                JOptionPane.showMessageDialog(null, "Seleccione la fila a eliminar");
            }
        }

        if (e.getSource() == PM.getBtnEliminar()) {

            System.out.println("Boton 'Eliminar' escuchando Rock!");

            int filaSelecionada = PM.getTablaMaterialesReg().getSelectedRow();

            if (filaSelecionada != -1) {

                this.nombreMaterial = PM.getTablaMaterialesReg().getValueAt(filaSelecionada, 0).toString();

                int opc = JOptionPane.showConfirmDialog(null, " Desea eliminar permanentemente el material: " + nombreMaterial + "? ", "Confirmar eliminacion ",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                /*
            	 * Le preguntare al usuario si en realidad desea modificar la categoria.
                 */

                if (opc == 0) {

                    try {

                        PM.getModeloTabla().removeRow(filaSelecionada);
                        this.materialesDAO.Eliminar(nombreMaterial);
                    } catch (Exception e2) {
                        System.err.println(e2.getMessage() + "Error boton eliminar");
                        JOptionPane.showMessageDialog(null, "La cedula no existe", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } else {

                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            }
            
            this.ObtenerMateriales();
        }

    }

    public String ValidarDatos() {//Metodo para comprobar que los datos esten completos.

        String msj = "";

//        if (this.PM.getComboCategoria().getSelectedIndex() == 0) {//Si TxtNombreMat esta vacio.
//            msj += "Por favor selecione una categoria. \n";
//        }
        if (this.PM.getTxtNombreMat().getText().equals("")) {
            msj += "Por favor escriba un nombre. \n";
        }
        if (this.PM.getTxtCantidadMat().getText().equals("")) {
            msj += "Por favor escriba una cantidad. \n";
        }

        if (this.PM.obtenerFecha().equals("")) {
            msj += "Por favor escriba una fecha. \n";
        }
        return msj;//devuelve msj.
    }

    //logica con el llenado de la tabla
    public void ObtenerMateriales() {
        List<MaterialesDTO> materiales = this.materialesDAO.ConsultarTodos();

        PM.limpiarTabla();

        for (int i = 0; i < materiales.size(); i++) {
            System.out.println(materiales.get(i).getNombreMaterial() + "" + 
                    materiales.get(i).getCantidadMaterial() + "" + materiales.get(i).getFechaRegistro());
            //PM.llenarTabla(materiales.get(i).toArray());
            this.PM.insertarTabla(materiales.get(i).toArray());

        }
    }

    private String getNombre(String nombre) {

        return nombre;
    }

    /* public void getObras() {
		
		System.out.println("HOLA");
		
		List<MaterialesDTO> obras = this.materialesDAO.ConsultarTodos();
    	
    	PM.limpiarTabla();
        
        for (int i = 0; i < obras.size(); i++) {
            System.out.println(obras.get(i).getNombreMaterial()+"Estoy en Obras");
            this.PM.insertarTabla(obras.get(i).toArray());
        }
	}*/
//    public void obtenerCategorias(JComboBox<CategoriaDTO> comboCategoria) {
//
//        List<CategoriaDTO> categorias = this.miCategoria.ConsultarTodos();
//        comboCategoria.removeAllItems();
//
//        for (int i = 0; i < categorias.size(); i++) {
//            System.out.println(categorias.get(i).getNombreCategoria());
//            comboCategoria.addItem(
//                    new CategoriaDTO(categorias.get(i).getIdCategoria(),
//                            categorias.get(i).getNombreCategoria().toString()));
//        }
//    }

    public void actualizarUsuario() {

        try {

            if (ValidarDatos().equals("")) {
                /*
				 *  Si el medoto ValidarDatos devuelve "", es decir, 
				 *  nada es porque los dos campos estan llenos. 
				 *  
                 */

                try {

                    materialesDAO.Actualizar(this.PM.ObtenerDatos(), this.nombreMaterial);
                    PM.LimpiarCampos();

                    this.ObtenerMateriales();

                } catch (Exception e2) {

                    System.out.println("Error al insertar " + e2);
                }
            } else {
                /*
				 * de lo contrario emite el mensaje
                 */

                JOptionPane.showMessageDialog(null, "ERROR!! \n" + ValidarDatos(), "Validando Datos",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e1) {

            JOptionPane.showMessageDialog(null, "Error en Eventos del Boton Agregar. \n" + e1, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
