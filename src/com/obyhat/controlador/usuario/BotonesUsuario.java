package com.obyhat.controlador.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.obyhat.modelo.dao.UsuarioDAO;
import com.obyhat.modelo.dto.UsuarioDTO;
import com.obyhat.vista.paneles.PanelUsuarios;

public class BotonesUsuario implements ActionListener {

  private PanelUsuarios panelUsuarios;
  private UsuarioDAO 	usuarioDAO;
  private ValidarDatosUsuario validarUsuario;
  private String nombreUsuario;

  public BotonesUsuario(PanelUsuarios panelUsuarios) {

    this.panelUsuarios  = panelUsuarios;
    this.usuarioDAO 	= new UsuarioDAO();
    this.validarUsuario = new ValidarDatosUsuario(this.panelUsuarios);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == this.panelUsuarios.getBtnAgregar()) {

      System.out.println("Boton 'Agregar Obra' escuchando Rock!");

      	this.registrarUsuario();
        this.obtenerUsuarios();
    }

    if (e.getSource() == this.panelUsuarios.getBtnActualizar()) {

      System.out.println("Boton Actualizar Escuchando");

      this.actualizarUsuario();
      this.obtenerUsuarios();
    }

    if (e.getSource() == this.panelUsuarios.getBtnCancelar()) {

      System.out.println("Boton Cancelar Escuchando");

      this.panelUsuarios.vaciarFormulario();
      this.obtenerUsuarios();

    }

    if (e.getSource() == this.panelUsuarios.getBtnBuscar()) {

      System.out.println("Boton Buscar Escuchando");

      this.obtenerUsuarios();

    }

    if (e.getSource() == this.panelUsuarios.getBtnModificar()) {

      System.out.println("Boton 'Modificar' escuchando Rock!");

      eveModificar();
    }

    if (e.getSource() == this.panelUsuarios.getBtnEliminar()) {

      System.out.println("Boton 'Eliminar' escuchando Rock!");

      this.eliminarUsuario();
      this.obtenerUsuarios();
    }
  }
  
  
  
  
  public void registrarUsuario() {

    if (this.validarUsuario.ValidarDatos().equals("")) {

      this.nombreUsuario   = this.panelUsuarios.ObtenerDatos().getNombre();
      UsuarioDTO resultado = this.usuarioDAO.Consultar(this.nombreUsuario);
      
      if (resultado == null) {
    	  /**
    	   * Realiza el registro del nuevo usuario si este no existe.
    	   */
    	  this.usuarioDAO.Ingresar(this.panelUsuarios.ObtenerDatos());
    	  this.panelUsuarios.vaciarFormulario();
      } else {
    	  /**
    	   * El nombre de usuario existe, por lo tanto pregunta si desea modificarlo.
    	   */
    	  JOptionPane.showMessageDialog(
    			  null, "      El nombre de usuario ya existe! \n" 
    				  + "Considere usar otro nombre o modificar el \n"
	    			  + "usuario ya existente.",
	    			    "Alerta!", JOptionPane.INFORMATION_MESSAGE);
    	  this.panelUsuarios.vaciarFormulario();
        }
    } else {

	    JOptionPane.showMessageDialog(
	         null, "ERROR!! \n" + this.validarUsuario.ValidarDatos(),
	          	"Validando Datos", JOptionPane.ERROR_MESSAGE);
	 }
  }

  public void eliminarUsuario() {

    int filaSeleccionada = panelUsuarios.getTablaUsuarios().getSelectedRow();

    if (filaSeleccionada != -1) {

      String nombreUsuario = panelUsuarios.getTablaUsuarios().getValueAt(filaSeleccionada, 1).toString();
      int    codigoUsuario = Integer.parseInt(String.valueOf(
    		  panelUsuarios.getTablaUsuarios().getValueAt(filaSeleccionada,0)));
      /*
       * Le preguntare al usuario si en realidad desea modificar la categoria.
       */
      int opc =
          JOptionPane.showConfirmDialog(
              null,
              " Desea eliminar de forma permanente al usuario: " + nombreUsuario + "? ",
              "Confirmar eliminacion ",
              JOptionPane.YES_NO_OPTION,
              JOptionPane.QUESTION_MESSAGE);
     
      if (opc == 0) {

          panelUsuarios.getModeloTabla().removeRow(filaSeleccionada);
          this.usuarioDAO.Eliminar(codigoUsuario);
      }
    } else {

      JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
    }
  }
  
  public void eveModificar() {

    //Obtenet la Fila seleccionada.
    int filaSeleccionada = panelUsuarios.getTablaUsuarios().getSelectedRow();

    if (filaSeleccionada >= 0) {

      this.nombreUsuario =
          panelUsuarios.getTablaUsuarios().getValueAt(filaSeleccionada, 1).toString();
      
      int opc =
          JOptionPane.showConfirmDialog(
              null,
              " Desea modificar el usuario: " + nombreUsuario + "? ",
              "Confirmar modificacion ",
              JOptionPane.YES_NO_OPTION,
              JOptionPane.QUESTION_MESSAGE);
      /*
       * Le preguntare al usuario si en realidad desea modificar la categoria.
       */

      if (opc == 0) {


          panelUsuarios.getModeloTabla().removeRow(filaSeleccionada);
          UsuarioDTO consultarUsuario = usuarioDAO.Consultar(this.nombreUsuario);

          int i;
          for (i = 0; i < this.panelUsuarios.getComboTipoUsuario().getItemCount(); i++) {

            if (this.panelUsuarios.getComboTipoUsuario().getItemAt(i).getIdTipoUsuario()
                == consultarUsuario.getIdTipoUsuario()) {

              //this.panelUsuarios.getComboTipoUsuario().setSelectedIndex(i);
              break;
            }
          }

          panelUsuarios.llenarFormulario(consultarUsuario, i);
      }
    } else {

      JOptionPane.showMessageDialog(null, "Seleccione la fila a eliminar");
    }
  }
  
  public void actualizarUsuario() {

    try {

      if (this.validarUsuario.ValidarDatos().equals("")) {
        try {
          /**
           * Haciendo referencia a la ultima asignacion hecha a la variable codigoUsuario
           */
          usuarioDAO.Actualizar(this.panelUsuarios.ObtenerDatos());
          //panelUsuarios.limpiar();

          this.obtenerUsuarios();

        } catch (Exception e2) {

          System.out.println("Error al insertar " + e2);
        }
      } else {
        JOptionPane.showMessageDialog(
            null, "ERROR!! \n" + this.validarUsuario.ValidarDatos(), "Validando Datos", JOptionPane.ERROR_MESSAGE);
      }

    } catch (Exception e1) {

      JOptionPane.showMessageDialog(
          null, "Error en Eventos del Boton Agregar. \n" + e1, "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void obtenerUsuarios() {

    List<UsuarioDTO> usuarios = this.usuarioDAO.ConsultarTodos();

    panelUsuarios.limpiarTabla();

    for (int i = 0; i < usuarios.size(); i++) {
      System.out.println(
          usuarios.get(i).getNombre() + " - " + usuarios.get(i).getTipo_de_Usuario());
      this.panelUsuarios.insertarTabla(new Object[] {
    		  usuarios.get(i).getIdUsuario(),
    		  usuarios.get(i).getNombre(),
    		  usuarios.get(i).getTipo_de_Usuario()});
    }
  }

  public void getUserType(JComboBox<UsuarioDTO> comboTipoUsuario) {
		
    List<UsuarioDTO> tiposdeUsuarios = this.usuarioDAO.getUserType();

    comboTipoUsuario.removeAllItems();

    System.out.println("\n\nTipo de usuarios ");
    for (int i = 0; i < tiposdeUsuarios.size(); i++) {
      
    	System.out.println(tiposdeUsuarios.get(i).getTipo_de_Usuario());
    	comboTipoUsuario.addItem(
    			new UsuarioDTO(tiposdeUsuarios.get(i).getIdTipoUsuario(),
        		  		       tiposdeUsuarios.get(i).getTipo_de_Usuario().toString()));
    }
    System.out.println("\n\n");
  }

  
  
}
