/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obyhat.controlador;

import com.obyhat.modelo.dao.AsignarDAO;
import com.obyhat.modelo.dao.MaterialesDAO;
import com.obyhat.modelo.dao.ObraDAO;
import com.obyhat.modelo.dto.AsignarDTO;
import com.obyhat.modelo.dto.MaterialesDTO;
import com.obyhat.modelo.dto.ObrasDTO;
import com.obyhat.vista.paneles.HistorialAsignaciones;
import com.obyhat.vista.paneles.PanelAsignar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author joselara
 */
public class BotonesAsignar implements ActionListener {

    private PanelAsignar PA;
    private HistorialAsignaciones HA;
    private AsignarDAO asignarDAO;
    private MaterialesDAO misMateriales;
    private ObraDAO miObra;

    public BotonesAsignar(PanelAsignar PA) {

        this.PA = PA;
        this.asignarDAO = new AsignarDAO();
        this.miObra = new ObraDAO();
        this.misMateriales = new MaterialesDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.PA.getBtnAgregar()) {

            System.out.println("Boton Agregar Escuchando");

            this.agregarMaterial();

        }

        if (e.getSource() == this.PA.getBtnCancelar()) {

            System.out.println("Boton Cancelar Escuchando");

            //this.PA.limpiar();
            /*this.obtenerCategorias();
			this.PA.getBtnAgregar().setEnabled(true);
			this.PA.getBtnActualizar().setEnabled(false);*/
        }

        if (e.getSource() == this.PA.getBtnProcesarSelect()) {

            System.out.println("Boton 'Procesar' escuchando Rock!");

            this.procesarAsignacion();
        }

        if (e.getSource() == this.PA.getBtnEliminarSelect()) {

            System.out.println("Boton 'Eliminar Seleccion' escuchando Rock!");

            this.eliminarSeleccion();
        }

        if (e.getSource() == this.PA.getBtnVerAsignaciones()) {

            System.out.println("Boton 'Ver Asignaciones' escuchando Rock!");

            new HistorialAsignaciones().setVisible(true);

            //JOptionPane.showMessageDialog(null, PA.ObtenerDatos().getIdObra()+" \n "+PA.ObtenerDatos().getFechaAsignacion());
        }
    }

    public void agregarMaterial() {

        int filaSeleccionada = PA.getTablaMateriales().getSelectedRow();
        int cantidadSelec;
        String cantidadSele = this.PA.getTxtCantidadSel().getText();

        //String datos         = PA.getTablaMateriales().getValueAt(filaSeleccionada, 0).toString();
        if (cantidadSele.equals("") || cantidadSele.equals("0")) {

            JOptionPane.showMessageDialog(null, "El campo cantidad no puede estar vacio");
        } else {

            cantidadSelec = Integer.parseInt(this.PA.getTxtCantidadSel().getText());

            try {

                if (filaSeleccionada >= 0) {

                    try {

                        String Codigo = this.PA.getTablaMateriales().getValueAt(filaSeleccionada, 0).toString();
                        String nombre = this.PA.getTablaMateriales().getValueAt(filaSeleccionada, 1).toString();
                        int cantidadDis = Integer.parseInt(this.PA.getTablaMateriales().getValueAt(filaSeleccionada, 2).toString());
                        String cantidadSel = this.PA.getTxtCantidadSel().getText();

                        if (cantidadSelec > cantidadDis) {
                            JOptionPane.showMessageDialog(null, "Ha selecionado una cantidad mayor a la disponible",
                                "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            String materialesSelec[] = {Codigo, nombre, cantidadSel};
                            this.PA.llenarTablaAsig(materialesSelec);
                            this.PA.getTxtCantidadSel().setText("");

                        }
                        
                    } catch (Exception e2) {
                        System.out.println(e2);
                        JOptionPane.showMessageDialog(null, "No se pudo agregar el material seleccionado",
                                "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Debe seleccionar un material y una cantidad mayor a cero");
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    public void agregarAsignacion() {

        try {

            if (ValidarDatos().equals("")) {
                /*
					 *  Si el medoto ValidarDatos devuelve "", es decir, 
					 *  nada es porque los dos campos estan llenos. 
					 *  
                 */

                try {

                    /*
						  * Creando un arreglo de 3 posiciones que contendra los
						  * datos obtenidos en el formulario.
                     */
                    Object[] datos = new Object[4];
                    datos[0] = PA.ObtenerDatos().getObra();
                    datos[1] = PA.ObtenerDatos().getFechaAsignacion();
                    datos[2] = PA.ObtenerDatos().getNombreMaterial();
                    datos[3] = PA.ObtenerDatos().getCantidadSeleccionada();

                    //PA.llenarTabla(datos);
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

    public void eliminarSeleccion() {

        int filaSelecionada = PA.getTablaSeleccionados().getSelectedRow();
        System.out.println(filaSelecionada);

        if (filaSelecionada != -1) {

            try {

                PA.removerSeleccion(filaSelecionada);
            } catch (Exception e2) {

                JOptionPane.showMessageDialog(null, "La cedula no existe", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {

            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }

    public void procesarAsignacion() {

        System.out.println("Entrando en asignacion");

        int canntidad = PA.getTablaSeleccionados().getRowCount();

        String fecha = null;
        int cantidadSel, idMaterial, obra, idUltimaAsig = 0;

        try {

            if (ValidarDatos().equals("")) {

                obra = PA.getComboObra().getItemAt(PA.getComboObra().getSelectedIndex()).getIdObra();
                fecha = PA.obtenerFecha();

                //JOptionPane.showMessageDialog(null, obra+" \n "+fecha+" \n "+idMaterial+" \n "+cantidadSel);
                asignarDAO.Ingresar(this.PA.ObtenerDatos());
                System.out.println(asignarDAO.obtenerUltimaAsig());
                idUltimaAsig = asignarDAO.obtenerUltimaAsig();

                for (int i = 0; i < canntidad; i++) {

                    idMaterial  = Integer.parseInt(PA.getTablaSeleccionados().getValueAt(i, 0).toString());
                    cantidadSel = Integer.parseInt(PA.getTablaSeleccionados().getValueAt(i, 2).toString());

                    //cantidad, idMaterial, idAsignacion
                    asignarDAO.insertarDetalles(new AsignarDTO(cantidadSel, idMaterial, idUltimaAsig));
                    misMateriales.Actualizar(new MaterialesDTO(cantidadSel, idMaterial));
                    this.PA.vaciarTablaMat();
                    obtenerMateriales();
                }

                this.PA.vaciarTablaAsig();
                
                JOptionPane.showMessageDialog(null, "Asignacion exitosa. \n", "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE);
                
                
            } else {

                JOptionPane.showMessageDialog(null, "ERROR!! \n" + ValidarDatos(), "Validando Datos",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e2) {

            JOptionPane.showMessageDialog(null, "Error en Eventos del Boton procesar. \n" + e2, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public void obtenerObras(JComboBox<ObrasDTO> comboObra) {

        List<ObrasDTO> obras = this.miObra.ConsultarTodos();

        comboObra.removeAllItems();

        for (int i = 0; i < obras.size(); i++) {
            System.out.println(obras.get(i).getNombreObra() + "Estoy en Asignar");
            comboObra.addItem(new ObrasDTO(obras.get(i).getIdObra(), obras.get(i).getNombreObra().toString()));
        }
    }

    public void obtenerMateriales() {

        List<MaterialesDTO> materiales = this.misMateriales.ConsultarTodosAsig();

        //SO.limpiarTabla();
        for (int i = 0; i < materiales.size(); i++) {

            
            this.PA.llenarTablaMat(new Object[]{
                materiales.get(i).getIdMaterial(),
                materiales.get(i).getNombreMaterial(),
                materiales.get(i).getCantidadMaterial()});
        }
    }
    
    public void generarReporteAsignacion() {
    
    }

    public String ValidarDatos() {//Metodo para comprobar que los datos esten completos.

        String msj = "";

        //@Deprecated
        if (this.PA.getComboObra().getSelectedIndex() == 0) {//Si TxtNombreMat esta vacio.
            msj += "Por favor seleccione una obra. \n";
        }
        if (this.PA.obtenerFecha().equals("")) {//Si TxtCodigoMat esta vacio.
            msj += "Por favor ingrese una fecha. \n";
        }
        if (this.PA.getTablaSeleccionados().getRowCount() == 0) {//Si TxtCodigoMat esta vacio.
            msj += "No se han elegido materiales. \n";
        }

        return msj;//devuelve msj.
    }

}
