package com.obyhat.controlador.obra;

import com.obyhat.vista.paneles.PanelObras;

public class ValidarDatosObra {

    private PanelObras panelObras;

    public ValidarDatosObra(PanelObras panelObras) {

        this.panelObras = panelObras;
    }

    public String ValidarDatos() { //Metodo para comprobar que los datos esten completos.

        String msj = "";

        if (this.panelObras.ObtenerDatos().getNombreObra().equals("")) { //Si TxtNombreMat esta vacio.
            msj += "Por favor ingrese un nombre de usuario. \n";
        }
        if (this.panelObras.ObtenerDatos().getEncargadoObra().equals("")) { //Si TxtNombreMat esta vacio.
            msj += "Por favor ingrese la contrasena para su usuario. \n";
        }
        if (this.panelObras.ObtenerDatos().getTelefonoObra().equals("")) { //Si TxtNombreMat esta vacio.
            msj += "Por favor seleccione un tipo de usuario. \n";
        }
        if (this.panelObras.ObtenerDatos().getDireccionObra().equals("")) { //Si TxtNombreMat esta vacio.
            msj += "Por favor seleccione un tipo de usuario. \n";
        }

        return msj; //devuelve msj.
    }
}
