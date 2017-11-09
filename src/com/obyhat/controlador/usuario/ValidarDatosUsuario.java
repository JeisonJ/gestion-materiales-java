package com.obyhat.controlador.usuario;

import com.obyhat.vista.paneles.PanelUsuarios;

public class ValidarDatosUsuario {
	
	private PanelUsuarios panelUsuarios;

  public ValidarDatosUsuario(PanelUsuarios panelUsuarios) {
    
    this.panelUsuarios = panelUsuarios;
  }

  public String ValidarDatos() { //Metodo para comprobar que los datos esten completos.

    String msj = "";

    if (this.panelUsuarios.ObtenerDatos().getNombre().equals("")) { //Si TxtNombreMat esta vacio.
      msj += "Por favor ingrese un nombre de usuario. \n";
    }
    if (this.panelUsuarios.ObtenerDatos().getContrasena().equals("")) { //Si TxtNombreMat esta vacio.
      msj += "Por favor ingrese la contrasena para su usuario. \n";
    }
    if (this.panelUsuarios.ObtenerDatos().getIdTipoUsuario() == 1) { //Si TxtNombreMat esta vacio.
      msj += "Por favor seleccione un tipo de usuario. \n";
    }

    return msj; //devuelve msj.
  }
}
