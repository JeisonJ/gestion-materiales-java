package com.obyhat.controlador.obra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.obyhat.modelo.dao.ObraDAO;
import com.obyhat.modelo.dto.ObrasDTO;
import com.obyhat.vista.paneles.PanelObras;

import java.util.List;

import javax.swing.JOptionPane;

public class BotonesObras implements ActionListener {

    private PanelObras PO;
    private ObraDAO miObraDAO;
    private String nombre;
    private ValidarDatosObra validarDatosObra;

    public BotonesObras(PanelObras PO) {

        this.PO = PO;
        this.miObraDAO = new ObraDAO();
        this.validarDatosObra = new ValidarDatosObra(this.PO);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == PO.getBtnAgregar()) {

            System.out.println("Boton 'Agregar Obra' escuchando Rock!");

            this.registrarObra();
            this.PO.limpiar();
            this.obtenerObras();
        }

        if (e.getSource() == PO.getBtnActualizar()) {

            System.out.println("Boton Actualizar Escuchando");

            this.actualizarObra();
            PO.limpiar();
            this.obtenerObras();
            this.PO.getBtnAgregar().setEnabled(true);
            this.PO.getBtnActualizar().setEnabled(false);
        }

        if (e.getSource() == PO.getBtnCancelar()) {

            System.out.println("Boton Cancelar Escuchando");

            this.PO.limpiar();
            this.obtenerObras();
            this.PO.getBtnAgregar().setEnabled(true);
            this.PO.getBtnActualizar().setEnabled(false);
        }

        if (e.getSource() == PO.getBtnModificar()) {

            System.out.println("Boton 'Modificar' escuchando Rock!");

            this.eventoModificar();
        }

        if (e.getSource() == PO.getBtnEliminar()) {

            System.out.println("Boton 'Eliminar' escuchando Rock!");
            this.eliminarObra();
        }
    }

    public void registrarObra() {
        if (this.validarDatosObra.ValidarDatos().equals("")) {

            this.miObraDAO.Ingresar(this.PO.ObtenerDatos());
        } else {
            JOptionPane.showMessageDialog(null, "ERROR!! \n"
                    + this.validarDatosObra.ValidarDatos(), "Validando Datos",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void obtenerObras() {

        List<ObrasDTO> obras = this.miObraDAO.ConsultarTodos();

        PO.limpiarTabla();

        for (int i = 0; i < obras.size(); i++) {
            System.out.println(obras.get(i).getNombreObra());
            this.PO.insertarTabla(obras.get(i).toArray());
        }
    }

    public void eventoModificar() {

        //Obtenet la Fila seleccionada.
        int filaSeleccionada = PO.getTablaObras().getSelectedRow();

        if (filaSeleccionada >= 0) {

            String nombreObra = PO.getTablaObras().getValueAt(
                    filaSeleccionada, 0).toString();

            int opc = JOptionPane.showConfirmDialog(
                    null, " Desea modificar la obra: " + nombreObra + "? ",
                    "Confirmar modificacion ",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            /*
                 * Le preguntare al usuario si en realidad desea modificar la categoria.
             */
            if (opc == 0) {
                PO.getModeloTabla().removeRow(filaSeleccionada);
                ObrasDTO consultarObra = miObraDAO.Consultar(nombreObra);
                PO.llenarFormulario(consultarObra);

                PO.getBtnAgregar().setEnabled(false);
                PO.getBtnActualizar().setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione la fila a eliminar");
        }
    }

    public void actualizarObra() {
        if (this.validarDatosObra.ValidarDatos().equals("")) {

            miObraDAO.Actualizar(this.PO.ObtenerDatos());
        } else {
            JOptionPane.showMessageDialog(null, "ERROR!! \n"
                    + this.validarDatosObra.ValidarDatos(), "Validando Datos",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarObra() {

        int filaSelecionada = PO.getTablaObras().getSelectedRow();

        if (filaSelecionada != -1) {

            String nombreObra = PO.getTablaObras().getValueAt(
                    filaSelecionada, 0).toString();

            int opc = JOptionPane.showConfirmDialog(
                    null, " Desea eliminar permanentemente la obra: " + nombreObra + "? ", 
                        "Confirmar eliminacion ",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            /*
             * Le preguntare al usuario si en realidad desea modificar la categoria.
             */
            if (opc == 0) {
              
                PO.getModeloTabla().removeRow(filaSelecionada);
                this.miObraDAO.Eliminar(nombreObra);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }
        
    
    
    private String getNombre(String nombre) {

        return nombre;
    }




}
