package com.obyhat.controlador.obra;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.obyhat.modelo.dao.ObraDAO;
import com.obyhat.modelo.dto.ObrasDTO;
import com.obyhat.vista.paneles.PanelObras;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import javax.swing.JOptionPane;

public class TextoObras implements KeyListener, FocusListener {

        private PanelObras PO;
        private ObraDAO miObraDAO;
    
	public TextoObras(PanelObras PO) {
		
		this.PO = PO;
        this.miObraDAO = new ObraDAO();
	}
	
	
	/*********************************************************************/
	
	
	@Override
	public void keyTyped(KeyEvent e) {

        if (e.getSource() == PO.getTxtTelefonoObra()) {
        	
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
        
		
        if (e.getSource() == PO.getTxtBuscar()) {
            
            String buscar = PO.getTxtBuscar().getText();
            
            List<ObrasDTO> obras = this.miObraDAO.autoBusqueda(buscar);
            
            for (int i = 0; i < obras.size(); i++) {
                
                System.out.println(obras.get(i).getNombreObra());
                //this.PO.Autocompletar(obras.get(i).toArray());
                //this.PO.getModeloTabla().addRow(obras.get(i).toArray());
                this.PO.insertarTabla(obras.get(i).toArray());
            }
        }
        
        //--------------------------------------------------------------//
        
	}
	
	
	/*********************************************************************/
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}
	
	/*********************************************************************/
	
	@Override
	public void keyReleased(KeyEvent e) {
	
	}

	
	/*********************************************************************/
	
	
    @Override
    public void focusGained(FocusEvent fe) {
        
    }
    
    
    /*********************************************************************/
    
    /*
     * (non-Javadoc)
     * #focusLost Evento para que la caja de texto de nombre de obra pierda
     * el foco consulte a la base de datos para verificar si ese nombre no 
     * ha sido registrado con anterioridad. 
     */

    @Override
    public void focusLost(FocusEvent fe) {
        
        if (fe.getSource() == PO.getTxtNombreObra()) {
                
                String buscar = PO.getTxtNombreObra().getText();
                
                if (buscar.equals("")) {
					
                	// Hacer nada si esta vacio.
				} else {

					try {
						
						ObrasDTO obras = this.miObraDAO.Consultar(buscar);
						
	                	String res = obras.getEncargadoObra();
	                    System.out.println(res);
	                    
	                    while (obras.equals(buscar)) {                
	                    
	                        res = obras.getEncargadoObra();
	                    }
	                    
	                    if (obras.getNombreObra().toString().equals(buscar)) {
	                    
	                        JOptionPane.showMessageDialog(null, "El nombre ya ha sido registrado");
	                        
	                        PO.getTxtNombreObra().setText("");
	                        
	                    }
					} catch (Exception e) {
						
						// Error Capturado y Silenciado: La obra no existe.
					}
				}
                
                
                
            
                
        }
    }
}
