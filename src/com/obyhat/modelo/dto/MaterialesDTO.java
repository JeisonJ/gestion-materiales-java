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
public class MaterialesDTO {

    private int idMaterial;
    private int idCategoria;
    private String nombreCategoria;
    private String nombreMaterial;
    private int cantidadMaterial;
    private int Existencia;
    private int ExistenciaMin;
    private int ExistenciaMax;
    private String fechaRegistro;

    public MaterialesDTO(int idMaterial) {
        this.idMaterial = idMaterial;

    }

    public MaterialesDTO(String nombreMaterial) {

        this.nombreMaterial = nombreMaterial;

    }

    /**
     * Constructor para la clase PanelNuevoMaterial.
     * @param idCategoria
     * @param nombreMaterial 
     */
    public MaterialesDTO(int idCategoria, String nombreMaterial) {
        this.idCategoria    = idCategoria;
        this.nombreMaterial = nombreMaterial;
    }

    public MaterialesDTO(int idMaterial, String nombreMaterial, int cantidadMaterial) {

        this.idMaterial = idMaterial;
        this.nombreMaterial = nombreMaterial;
        this.cantidadMaterial = cantidadMaterial;
    }

    public MaterialesDTO(String nombreMaterial, int Existencia, int ExistenciaMin, int ExistenciaMax, int cantidadMaterial, String fechaRegistro) {

        this.nombreMaterial = nombreMaterial;
        this.Existencia = Existencia;
        this.ExistenciaMin = ExistenciaMin;
        this.ExistenciaMax = ExistenciaMax;
        this.cantidadMaterial = cantidadMaterial;
        this.fechaRegistro = fechaRegistro;

    }

    public MaterialesDTO(int idMaterial, String nombreMaterial, int Existencia, int ExistenciaMin, int ExistenciaMax, int cantidadMaterial, String fechaRegistro) {

        this.idMaterial = idMaterial;
        this.nombreMaterial = nombreMaterial;
        this.Existencia = Existencia;
        this.ExistenciaMin = ExistenciaMin;
        this.ExistenciaMax = ExistenciaMax;
        this.cantidadMaterial = cantidadMaterial;
        this.fechaRegistro = fechaRegistro;
    }

    public MaterialesDTO(String nombreMaterial, int cantidadMaterial) {
        this.nombreMaterial = nombreMaterial;
        this.cantidadMaterial = cantidadMaterial;

    }

    public MaterialesDTO(int cantidadMaterial, int idMaterial) {
        this.cantidadMaterial = cantidadMaterial;
        this.idMaterial = idMaterial;
    }

    public MaterialesDTO(String nombreMaterial, int cantidadMaterial, String fechaRegistro) {
        this.nombreMaterial = nombreMaterial;
        this.cantidadMaterial = cantidadMaterial;
        this.fechaRegistro = fechaRegistro;
    }

    public MaterialesDTO(int idMaterial, String nombreMaterial, int cantidadMaterial, 
            String fechaRegistro) {
        this.idMaterial        = idMaterial;
        this.nombreMaterial    = nombreMaterial;
        this.cantidadMaterial  = cantidadMaterial;
        this.fechaRegistro     = fechaRegistro;
    }

    public MaterialesDTO(String nombreCategoria, String nombreMaterial, int cantidadMaterial, String fechaRegistro) {
        this.nombreCategoria = nombreCategoria;
        this.nombreMaterial = nombreMaterial;
        this.cantidadMaterial = cantidadMaterial;
        this.fechaRegistro = fechaRegistro;
    }

    public final Object[] toArray() {
        Object[] datos = new Object[3];

        //datos[0] = this.idObra;
        datos[0] = this.nombreMaterial;
        //datos[1] = this.Existencia;
        //datos[2] = this.ExistenciaMin;
        //datos[3] = this.ExistenciaMax;
        datos[1] = this.cantidadMaterial;
        datos[2] = this.fechaRegistro;

        return datos;
    }

    public final Object[] toArrayDos() {
        Object[] datos = new Object[2];

        datos[0] = this.nombreMaterial;
        datos[1] = this.cantidadMaterial;

        return datos;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public int getExistencia() {
        return Existencia;
    }

    public void setExistencia(int Existencia) {
        this.Existencia = Existencia;
    }

    public int getExistenciaMin() {
        return ExistenciaMin;
    }

    public void setExistenciaMin(int ExistenciaMin) {
        this.ExistenciaMin = ExistenciaMin;
    }

    public int getExistenciaMax() {
        return ExistenciaMax;
    }

    public void setExistenciaMax(int ExistenciaMax) {
        this.ExistenciaMax = ExistenciaMax;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getCantidadMaterial() {
        return cantidadMaterial;
    }

    public void setCantidadMaterial(int cantidadMaterial) {
        this.cantidadMaterial = cantidadMaterial;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public String toString() {
        return this.nombreCategoria;
    }

}
