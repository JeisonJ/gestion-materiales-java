package com.obyhat.controlador.categoria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.obyhat.modelo.dao.CategoriaDAO;
import com.obyhat.modelo.dto.CategoriaDTO;
import com.obyhat.vista.paneles.PanelCategorias;

public class BotonesCategoria implements ActionListener {

    private PanelCategorias PC;
    private CategoriaDAO miCategoria;
    private String nombre;
    private ValidarDatosCategoria validarDatosCategoria;

    public BotonesCategoria(PanelCategorias PC) {
        this.PC = PC;
        this.miCategoria = new CategoriaDAO();
        this.validarDatosCategoria = new ValidarDatosCategoria(this.PC);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.PC.getBtnAgregar()) {

            System.out.println("Boton 'Agregar Obra' escuchando Rock!");

            this.registrarCategoria();
            this.PC.vaciarFormulario();
            this.obtenerCategorias();
        }

        if (e.getSource() == this.PC.getBtnActualizar()) {

            System.out.println("Boton Actualizar Escuchando");

            this.actualizarCategoria();
            this.obtenerCategorias();
            this.PC.vaciarFormulario();
            this.PC.getBtnAgregar().setEnabled(true);
            this.PC.getBtnActualizar().setEnabled(false);
        }

        if (e.getSource() == this.PC.getBtnCancelar()) {

            System.out.println("Boton Cancelar Escuchando");

            this.PC.vaciarFormulario();
            this.obtenerCategorias();
            this.PC.getBtnAgregar().setEnabled(true);
            this.PC.getBtnActualizar().setEnabled(false);
        }
        if (e.getSource() == this.PC.getBtnModificar()) {

            System.out.println("Boton 'Modificar' escuchando Rock!");

            this.eventoModificar();

            PC.getBtnAgregar().setEnabled(false);
            PC.getBtnActualizar().setEnabled(true);
        }

        if (e.getSource() == this.PC.getBtnEliminar()) {

            System.out.println("Boton 'Eliminar' escuchando Rock!");

            this.eliminarCategoria();
            this.obtenerCategorias();
        }

    }

    public void registrarCategoria() {

        if (validarDatosCategoria.ValidarDatos().equals("")) {

            this.miCategoria.Ingresar(this.PC.ObtenerDatos());

        } else {
            JOptionPane.showMessageDialog(null, "ERROR!! \n"
                    + validarDatosCategoria.ValidarDatos(), "Validando Datos",
                        JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eventoModificar() {
        //Obtenet la Fila seleccionada.
        int filaSeleccionada = PC.getTablaCategoria().getSelectedRow();

        if (filaSeleccionada >= 0) {

            String nombreObra = PC.getTablaCategoria().getValueAt(
                    filaSeleccionada, 0).toString();

            int opc = JOptionPane.showConfirmDialog(
                    null, " ¿Desea modificar la categoria: " + nombreObra + "? ",
                    "Confirmar modificacion  ",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            /*
	     * Le preguntare al usuario si en realidad desea modificar la categoria.
             */
            if (opc == 0) {

                PC.getModeloTabla().removeRow(filaSeleccionada);
                CategoriaDTO consultarCat = miCategoria.Consultar(nombreObra);
                PC.llenarFormulario(consultarCat);
            }

        } else {

            JOptionPane.showMessageDialog(null, "Seleccione la fila a eliminar");
        }
    }
    
    public void actualizarCategoria() {

        if (validarDatosCategoria.ValidarDatos().equals("")) {

            miCategoria.Actualizar(this.PC.ObtenerDatos());

        } else {
            JOptionPane.showMessageDialog(null, "ERROR!! \n"
                    + validarDatosCategoria.ValidarDatos(), "Validando Datos",
                        JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminarCategoria() {

        int filaSelecionada = PC.getTablaCategoria().getSelectedRow();

        if (filaSelecionada != -1) {

            String nombreCat = PC.getTablaCategoria().getValueAt(
                    filaSelecionada, 0).toString();

            int opc = JOptionPane.showConfirmDialog(
                    null, " Desea eliminar la categoria: " + nombreCat + "? ",
                        "Confirmar eliminacion  ",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            /*
             * Le preguntare al usuario si en realidad desea eliminar la categoria.
             */
            if (opc == 0) {

                PC.getModeloTabla().removeRow(filaSelecionada);
                this.miCategoria.Eliminar(nombreCat);
            }
        } else {

            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }

    public void obtenerCategorias() {

        List<CategoriaDTO> categorias = this.miCategoria.ConsultarTodos();

        PC.limpiarTabla();

        for (int i = 1; i < categorias.size(); i++) {
            System.out.println(categorias.get(i).getNombreCategoria());
            this.PC.insertarTabla(categorias.get(i).toArray());
        }
    }

}
