/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obyhat.modelo.dto;

import java.util.Date;

/**
 *
 * @author Jafeht
 */
public class ProveedorDTO {

    private String Rif;
    private String RazonSocial;
    private String Telefono;
    private String Direccion;
    private String MaterialProvee;
    private String Email;

    public ProveedorDTO(String Rif) {
        this.Rif = Rif;
    }

    public ProveedorDTO(String Rif, String RazonSocial, String Telefono, String Direccion, String Email) {
        this.Rif         = Rif;
        this.RazonSocial = RazonSocial;
        this.Telefono    = Telefono;
        this.Direccion   = Direccion;
        this.Email       = Email;
    }

    public ProveedorDTO(String rif, String razonSocial) {
        this.Rif         = Rif;
        this.RazonSocial = RazonSocial;
    }

    public final Object[] toArray() {
        Object[] datos = new Object[6];

        datos[0] = this.Rif;
        datos[1] = this.RazonSocial;
        datos[2] = this.Telefono;
        datos[3] = this.Direccion;
        datos[4] = this.MaterialProvee;
        datos[5] = this.Email;

        return datos;

    }

    public String getRif() {
        return Rif;
    }

    public void setRif(String Rif) {
        this.Rif = Rif;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getMaterialProvee() {
        return MaterialProvee;
    }

    public void setMaterialProvee(String MaterialProvee) {
        this.MaterialProvee = MaterialProvee;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return this.RazonSocial;
    }

}
