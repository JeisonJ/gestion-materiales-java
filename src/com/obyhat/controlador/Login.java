package com.obyhat.controlador;

import com.obyhat.modelo.dao.UsuarioDAO;
import com.obyhat.modelo.dto.UsuarioDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.obyhat.vista.login.PanelLogin;
import com.obyhat.vista.principal.VistaPrincipal;
import javax.swing.JOptionPane;

public class Login implements ActionListener {

  private PanelLogin PL;
  
  private UsuarioDAO usuario;

  public Login(PanelLogin PL) {
    
    this.PL = PL;
    
    this.usuario  = new UsuarioDAO();
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == this.PL.getBtnIniciar()) {
    
    

        /**
         * Metodo 2: Ejecutas tu consulta enviandole el nombre de usuario como parametro al metodo consultar.
         */

        // Ejecutando la consulta y almacenando su resultado en una variable de tipo UsuarioDTO.
            UsuarioDTO resultado = usuario.Consultar(this.PL.obtenerDatos().getNombre());

        /**
         * Si el nombre de usuario que envias como parametro al metodo consultar no existe te devolvera
         * un "null" (ver metodo Consultar en UsuarioDAO).
         */
        if (resultado != null) {

                if (this.PL.obtenerDatos().getNombre().equals(resultado.getNombre()) && this.PL.obtenerPassword().equals(resultado.getContrasena())){

                    /**
                     * # Si las dos condiciones son verdaderas muestra el mensaje de Bienvenida.
                     */
                    JOptionPane.showMessageDialog(null, "Bienvenido "+ resultado.getNombre());
                    this.PL.dispose();
                    VistaPrincipal vp = new VistaPrincipal();
                    vp.setVisible(true);
                }
                else {

                    /**
                     * # De lo contrario si alguna de las dos condiciones no se cumple muestra el mensaje de Incorrecto.
                     */
                    JOptionPane.showMessageDialog(null, "Usuario o Contrasena incorrecto");
                }
            }
            else {

                /**
                 * Si resultado == null, mostrar esto...
                 */
                JOptionPane.showMessageDialog(null, "Usuario no existe. Verifique!");
            }
    
    }
    
     if (e.getSource() == this.PL.getBtnSalir()) {
     
     System.exit(0);
     }
    
  }
	
}
