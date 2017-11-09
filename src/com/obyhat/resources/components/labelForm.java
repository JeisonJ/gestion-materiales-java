/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obyhat.resources.components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Jeis
 */
public class labelForm extends JLabel {

    public labelForm(String titulo) {
        
        setText(titulo);
        setHorizontalAlignment(SwingConstants.LEFT);
	setForeground(new Color(255, 255, 255));
	setFont(new Font("Tahoma", Font.PLAIN, 17));
    }
}
