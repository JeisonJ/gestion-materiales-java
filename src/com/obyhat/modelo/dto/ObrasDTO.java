package com.obyhat.modelo.dto;

public class ObrasDTO {

	private int idObra;
	private String nombreObra;
	private String encargadoObra;
	private String telefonoObra;
	private String direccionObra;
	
	
	
	public ObrasDTO() {
		
	}
	
	public ObrasDTO(String nombreObra) {
		
		this.nombreObra = nombreObra;
	}
	
	public ObrasDTO(String nombreObra, String encargadoObra, String telefonoObra, String direccionObra) {
		
		this.nombreObra = nombreObra;
		this.encargadoObra = encargadoObra;
		this.telefonoObra = telefonoObra;
		this.direccionObra = direccionObra;
	}
	
	public ObrasDTO(int idObra, String nombreObra, String encargadoObra, 
								String telefonoObra, String direccionObra) {
		
		this.idObra = idObra;
		this.nombreObra = nombreObra;
		this.encargadoObra = encargadoObra;
		this.telefonoObra = telefonoObra;
		this.direccionObra = direccionObra;
	}

   public ObrasDTO(int idObra, String nombreObra) {
    
	   this.idObra = idObra;
	   this.nombreObra = nombreObra;
   }

    public final Object[] toArray(){
            Object[] datos = new Object[5];
            
            //datos[0] = this.idObra;
            datos[0] = this.nombreObra;
            datos[1] = this.encargadoObra;
            datos[2] = this.telefonoObra;
            datos[3] = this.direccionObra;
            
            return datos;
        }
    
    public String toString() {
    	
    	return nombreObra;
    }

	public int getIdObra() {
		return idObra;
	}

	public void setIdobra(int idObra) {
		this.idObra = idObra;
	}

	public String getNombreObra() {
		return nombreObra;
	}

	public void setNombreObra(String nombreObra) {
		this.nombreObra = nombreObra;
	}

	public String getEncargadoObra() {
		return encargadoObra;
	}

	public void setEncargadoObra(String encargadoObra) {
		this.encargadoObra = encargadoObra;
	}

	public String getDireccionObra() {
		return direccionObra;
	}

	public void setDireccionObra(String direccionObra) {
		this.direccionObra = direccionObra;
	}

	public String getTelefonoObra() {
		return telefonoObra;
	}

	public void setTelefonoObra(String telefonoObra) {
		this.telefonoObra = telefonoObra;
	}
	
	
}
