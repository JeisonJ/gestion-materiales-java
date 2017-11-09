/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obyhat.resources.components;


import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Jeis
 */
public class labelTitulo extends JLabel {
    
    public labelTitulo(String titulo){
        setText(titulo);
        setFont(new Font("Tahoma",0,23));
        setForeground(Color.white);
    }
}
