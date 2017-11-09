package com.obyhat.modelo.dto;

public class UsuarioDTO {

	private int    idUsuario;
	private String nombre;
	private String contrasena;
	
	private int    idTipoUsuario;
	private String tipo_de_Usuario;
	
  public UsuarioDTO() {}


  public UsuarioDTO(int idTipoUsuario, String tipo_de_Usuario) {

    this.idTipoUsuario   = idTipoUsuario;
    this.tipo_de_Usuario = tipo_de_Usuario;
  }

  public UsuarioDTO(String nombre, String contrasena) {
    
    this.nombre 	= nombre;
    this.contrasena = contrasena;
  }

  public UsuarioDTO(int idUsuario, String nombre, String contrasena) {

    this.idUsuario  = idUsuario;
    this.nombre 	= nombre;
    this.contrasena = contrasena;
  }

  public UsuarioDTO(int idUsuario, String nombre, String contrasena, int idTipoUsuario) {
    
    this.idUsuario = idUsuario;
    this.nombre = nombre;
    this.contrasena = contrasena;
    this.idTipoUsuario = idTipoUsuario;
  }


public UsuarioDTO(String nombre, String contrasena, int idTipoUsuario) {

    this.nombre 	   = nombre;
    this.contrasena    = contrasena;
    this.idTipoUsuario = idTipoUsuario;
  }
  
  public UsuarioDTO(
      int idUsuario, String nombre, String contrasena, int idTipoUsuario, String tipo_de_Usuario) {
    
    this.idUsuario 		 = idUsuario;
    this.nombre 		 = nombre;
    this.contrasena 	 = contrasena;
    this.idTipoUsuario   = idTipoUsuario;
    this.tipo_de_Usuario = tipo_de_Usuario;
  }

  public int getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getContrasena() {
    return contrasena;
  }

  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }

  public String getTipo_de_Usuario() {
    return tipo_de_Usuario;
  }

  public void setTipo_de_Usuario(String tipo_de_Usuario) {
    this.tipo_de_Usuario = tipo_de_Usuario;
  }

  public int getIdTipoUsuario() {
    return idTipoUsuario;
  }

  public void setIdTipoUsuario(int idTipoUsuario) {
    this.idTipoUsuario = idTipoUsuario;
  }

  public String toString() {
    return this.tipo_de_Usuario;
  }
	
}
