/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obyhat.resources.components;


import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author Jeis
 */
public class txt extends JTextField {
    
    public txt(){
        
	setFont(new Font("Tahoma", Font.PLAIN, 17));
        setForeground(Color.white);
	setColumns(10);
        setOpaque(false);
	setBorder(new LineBorder(new Color(42, 59, 80)));
    }
}
