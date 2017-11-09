/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obyhat.resources.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JMenuItem;

/**
 *
 * @author Jeis
 */
public class MenuItem extends JMenuItem{
    
    public MenuItem(String titulo){
    
        setText(titulo);
        setFont(new Font(null,1,13));
        setBackground(new Color(255,255,255));
        setPreferredSize(new Dimension(270,55));
        
    }
}
