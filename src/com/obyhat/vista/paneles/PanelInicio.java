/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obyhat.vista.paneles;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Jeis
 * 
 * Clase que contiene un JPanel a el cual se le agregara una imagen que se redimencionara
 * de acuerdo al tamano de la ventana.
 */
public class PanelInicio extends JPanel {
    
    
    @Override
    public void paintComponent(Graphics g){
    
        //Se obtiene las dimensiones de la ventana y se gurdan en la variable @tam.
        Dimension tam = getSize();
        
        ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("/com/obyhat/resources/img/1.png")).getImage());
        
        //Dibujando y ubicando la imagen
        g.drawImage(imagen.getImage(), 0, -1,tam.width,tam.height, null);
    }
}
