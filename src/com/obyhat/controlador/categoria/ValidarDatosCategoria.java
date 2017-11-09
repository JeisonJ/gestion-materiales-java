package com.obyhat.controlador.categoria;

import com.obyhat.controlador.obra.*;
import com.obyhat.vista.paneles.PanelCategorias;
import com.obyhat.vista.paneles.PanelObras;

public class ValidarDatosCategoria {

    private PanelCategorias panelCategorias;

    public ValidarDatosCategoria(PanelCategorias panelCategorias) {

        this.panelCategorias = panelCategorias;
    }

    public String ValidarDatos() { //Metodo para comprobar que los datos esten completos.

        String msj = "";

        if (this.panelCategorias.ObtenerDatos().getNombreCategoria().equals("")) { //Si TxtNombreMat esta vacio.
            msj += "Por favor ingrese un nombre de usuario. \n";
        }

        return msj; //devuelve msj.
    }
}
