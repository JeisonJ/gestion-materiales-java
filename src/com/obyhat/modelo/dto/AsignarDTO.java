package com.obyhat.modelo.dto;

import java.sql.Date;

public class AsignarDTO {

	private int 	idAsignacion;
	private int     idObra;
	private String  obra;
	private String  encargadoObra;
	private String 	fechaAsignacion;
	private String 	nombreMaterial;
	private int     idMaterial;
	private int 	cantidadDisponible;
	private int 	cantidadSeleccionada;
	private int     sumaMaterialesAsig;
	
	
	
	public AsignarDTO(int idObra, String fechaAsignacion) {
		
		this.idObra = idObra;
		this.fechaAsignacion = fechaAsignacion;
	}


	public AsignarDTO(String fechaAsignacion, String nombreMaterial, int cantidadSeleccionada) {
		
		this.fechaAsignacion = fechaAsignacion;
		this.nombreMaterial = nombreMaterial;
		this.cantidadSeleccionada = cantidadSeleccionada;
	}

	
	public AsignarDTO(int cantidadSeleccionada, int idMaterial, int idAsignacion) {
		
		this.idAsignacion = idAsignacion;
		this.idMaterial = idMaterial;
		this.cantidadSeleccionada = cantidadSeleccionada;
	}


	public AsignarDTO(String obra,int idAsignacion, String fechaAsignacion, String nombreMaterial,
			int cantidadSeleccionada) {
		
		this.obra = obra;
		this.idAsignacion = idAsignacion;
		this.fechaAsignacion = fechaAsignacion;
		this.nombreMaterial = nombreMaterial;
		this.cantidadSeleccionada = cantidadSeleccionada;
	}

	

  public AsignarDTO(int idAsignacion,String fechaAsignacion,String obra,
		  			String encargadoObra,int sumaMaterialesAsig) {
    
    this.idAsignacion = idAsignacion;
    this.fechaAsignacion = fechaAsignacion;
    this.obra = obra;
    this.encargadoObra = encargadoObra;
    this.sumaMaterialesAsig = sumaMaterialesAsig;
  }


  public final Object[] toArray(){
        Object[] datos = new Object[5];
        
        //datos[0] = this.idAsignacion;
        datos[0] = this.obra;
        datos[1] = this.fechaAsignacion;
        datos[2] = this.nombreMaterial;
        datos[3] = this.cantidadDisponible;
        datos[4] = this.cantidadSeleccionada;
        
        return datos;
    }

	public int getIdAsignacion() {
		return idAsignacion;
	}


	public void setIdAsignacion(int idAsignacion) {
		this.idAsignacion = idAsignacion;
	}


	public String getObra() {
		return obra;
	}


	public void setObra(String obra) {
		this.obra = obra;
	}

	public String getFechaAsignacion() {
		return fechaAsignacion;
	}


	public void setFechaAsignacion(String fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}


	public String getNombreMaterial() {
		return nombreMaterial;
	}


	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}


	public int getCantidadDisponible() {
		return cantidadDisponible;
	}


	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}


	public int getCantidadSeleccionada() {
		return cantidadSeleccionada;
	}


	public void setCantidadSeleccionada(int cantidadSeleccionada) {
		this.cantidadSeleccionada = cantidadSeleccionada;
	}


	public int getIdObra() {
		return idObra;
	}


	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}


	public int getIdMaterial() {
		return idMaterial;
	}


	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}


  public String getEncargadoObra() {
  return encargadoObra;}


  public void setEncargadoObra(String encargadoObra) {
  this.encargadoObra = encargadoObra;}


public int getSumaMaterialesAsig() {
return sumaMaterialesAsig;}


public void setSumaMaterialesAsig(int sumaMaterialesAsig) {
this.sumaMaterialesAsig = sumaMaterialesAsig;}
	
}
