package com.obyhat.controlador.usuario;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.obyhat.modelo.dao.CategoriaDAO;
import com.obyhat.modelo.dao.UsuarioDAO;
import com.obyhat.vista.paneles.PanelCategorias;
import com.obyhat.vista.paneles.PanelUsuarios;

public class TextoUsuarios implements KeyListener, FocusListener  {

	private PanelUsuarios PU;
	private UsuarioDAO miUsuario;
	private String nombre;
	
	
	public TextoUsuarios(PanelUsuarios PU) {
		
		this.PU = PU;
		this.miUsuario = new UsuarioDAO();
	}
	
	@Override
	public void focusGained(FocusEvent fe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent fe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}
}
