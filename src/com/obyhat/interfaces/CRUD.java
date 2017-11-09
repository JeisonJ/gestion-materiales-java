package com.obyhat.interfaces;

import java.util.List;

import com.obyhat.modelo.dto.ObrasDTO;

 /*
 * Interface para que la implementen todas mis clases DAO.
 * En este caso de los metodos CRUD.
 * - CREATE
 * - READ
 * - UPDATE
 * - DELETE
 * 
 * boolean: Verdadero o falso para saber si se hizo o no.
 * 
 * Clases Genericas: Me servira para utilizar muchas veces
 * con diferentes tipos de datos.
 */

public interface CRUD <cualquierCosa> {

	
	public	boolean Ingresar(cualquierCosa datos);
		
	public  boolean Actualizar(cualquierCosa datos);
	
	public  boolean Eliminar(Object key);
	
	

	public  cualquierCosa Consultar(Object key);

	public 	List<cualquierCosa> ConsultarTodos();
	
}
