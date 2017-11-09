package com.obyhat.controlador.categoria;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.obyhat.modelo.dao.CategoriaDAO;
import com.obyhat.vista.paneles.PanelCategorias;

public class TextoCategoria implements KeyListener, FocusListener  {

	private PanelCategorias PC;
	private CategoriaDAO miCategoria;
	
	
	public TextoCategoria(PanelCategorias PC) {
		
		this.PC = PC;
		this.miCategoria = new CategoriaDAO();
	}
	
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
