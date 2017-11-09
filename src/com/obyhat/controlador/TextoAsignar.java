package com.obyhat.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import com.obyhat.modelo.dao.AsignarDAO;
import com.obyhat.vista.paneles.PanelAsignar;

public class TextoAsignar implements KeyListener, MouseListener {
	
	private PanelAsignar PA;
	private BotonesAsignar bAsignar;
	
	public TextoAsignar(PanelAsignar PA) {
		
		this.PA = PA;
		//this.bAsignar = new BotonesAsignar(null);
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

		if (e.getSource() == PA.getTxtCantidadSel()) {
        	
        	int k = (int) e.getKeyChar();//k = al valor de la tecla presionada
            
            if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {//Si el caracter ingresado es una letra
            e.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
            JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!", "Validando Datos",
                    JOptionPane.ERROR_MESSAGE);
            }

            if (k == 241 || k == 209) {//Si el caracter ingresado es una letra
                e.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
                JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!", "Validando Datos",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		
		if (e.getSource() == this.PA.getComboObra()) {
			
			System.out.println("Te he presionado");
		}
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
