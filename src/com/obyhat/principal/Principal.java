/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obyhat.principal;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.obyhat.vista.login.PanelLogin;
/**
 *
 * @author Jeis
 */
public class Principal {
    
    public static void main(String[] args) {
        //Sobreescribiendo el UIManager
        UIManager.put("MenuItem.selectionBackground", new Color(255, 255, 255));
        UIManager.put("Menu.selectionBackground", new Color(240, 114, 113));
        UIManager.put("PopupMenu.border", new LineBorder(new Color(255, 255, 255)));
        UIManager.put("Menu.border", new LineBorder(new Color(239, 100, 99)));
        
        PanelLogin PL = new PanelLogin();
        PL.setVisible(true);
       // VistaPrincipal v = new VistaPrincipal();
        
    }
}
