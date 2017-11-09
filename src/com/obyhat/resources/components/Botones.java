/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obyhat.resources.components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author Jeis
 */
public class Botones extends JButton{

    public Botones(String titulo) {
        
        setText(titulo);
        setBackground(new Color(108, 122, 137));
        setFont(new Font("Tahoma", 1, 15));
        setForeground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new Color(108, 122, 137), 2, true));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setFocusPainted(false);
        //setMargin(new java.awt.Insets(6, 14, 6, 14));
        //setPreferredSize(new java.awt.Dimension(85, 45));
    }
}
