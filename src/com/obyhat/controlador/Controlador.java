/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obyhat.controlador;

import com.obyhat.resources.components.AbrirAyuda;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import com.obyhat.vista.paneles.PanelAsignar;
import com.obyhat.vista.paneles.PanelMateriales;
import com.obyhat.vista.principal.VistaPrincipal;

/**
 *
 * @author Jeis
 */
public class Controlador implements ActionListener {

    VistaPrincipal aux;
    private PanelAsignar PA;
    private PanelMateriales panelMateriales;
    private AbrirAyuda abrirAyuda;
    
    public Controlador(VistaPrincipal adn){
    
    	this.PA = PA;
    	this.panelMateriales = panelMateriales;
       this.aux = adn;
      // bUsuario = new PanelAsignar();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==aux.getBtnInicio()) {
            
            System.out.println("Boton Inicio Escuchando!");
            CardLayout cl = (CardLayout)(aux.getPanelCentral().getLayout());
			    cl.show(aux.getPanelCentral(), aux.VENTANA0);
            
        }
        
        if (e.getSource()==aux.getItemRegistrar()) {
            
            System.out.println("ItemMenu Registrar Escuchando!");
            
          
            
            //aux.add(new Panel1());
            CardLayout cl = (CardLayout)(aux.getPanelCentral().getLayout());
			    cl.show(aux.getPanelCentral(), aux.VENTANA1);
			  
		           //tmp.actualizarComboCategorias();
        }
        
        if (e.getSource()==aux.getItemRegistrados()) {
            
            System.out.println("ItemMenu Usuarios Escuchando!");
            
            //aux.add(new Panel1());
            CardLayout cl = (CardLayout)(aux.getPanelCentral().getLayout());
			    cl.show(aux.getPanelCentral(), aux.VENTANA7);
        }
        
        if (e.getSource() == aux.getItemAsignar()) {

            System.out.println("ItemMenu Asignar Escuchando!");

            CardLayout cl = (CardLayout) (aux.getPanelCentral().getLayout());
            cl.show(aux.getPanelCentral(), aux.VENTANA2);

            this.aux.getV2().llenarComboObras();
            this.aux.getV2().llenarTablaMateriales();
        }
        
        if (e.getSource()==aux.getItemAsignados()) {
            
            System.out.println("ItemMenu Asignados Escuchando!");
            
            //aux.add(new Panel1());
            CardLayout cl = (CardLayout)(aux.getPanelCentral().getLayout());
			    cl.show(aux.getPanelCentral(), aux.VENTANA8);
        }
        
        if (e.getSource()==aux.getItemAsignados2()) {
            
            System.out.println("ItemMenu Asignados 2 Escuchando!");
            
            //aux.add(new Panel1());
            CardLayout cl = (CardLayout)(aux.getPanelCentral().getLayout());
			    cl.show(aux.getPanelCentral(), aux.VENTANA8);
        }
        
        if (e.getSource()==aux.getItemCategorias()) {
            
            System.out.println("ItemMenu Categorias Escuchando!");
            
            //aux.add(new Panel1());
            CardLayout cl = (CardLayout)(aux.getPanelCentral().getLayout());
			    cl.show(aux.getPanelCentral(), aux.VENTANA3);
        }
        
        if (e.getSource()==aux.getItemObras()) {
            
            System.out.println("ItemMenu Obras Escuchando!");
            
            //aux.add(new Panel1());
            CardLayout cl = (CardLayout)(aux.getPanelCentral().getLayout());
			    cl.show(aux.getPanelCentral(), aux.VENTANA4);
        }
        
        if (e.getSource()==aux.getItemProveedores()) {
            
            System.out.println("ItemMenu Proveedores Escuchando!");
            
            //aux.add(new Panel1());
            CardLayout cl = (CardLayout)(aux.getPanelCentral().getLayout());
			    cl.show(aux.getPanelCentral(), aux.VENTANA5);
        }
        
        if (e.getSource()==aux.getItemDevoluciones()) {
            
            System.out.println("ItemMenu Devoluciones Escuchando!");
            
        }
        
        
        if (e.getSource()==aux.getItemUsuarios()) {
            
            System.out.println("ItemMenu Usuarios Escuchando!");
            
            CardLayout cl = (CardLayout)(aux.getPanelCentral().getLayout());
			    cl.show(aux.getPanelCentral(), aux.VENTANA6);
        }
        
        
        if (e.getSource()==aux.getItemayuda()) {
            
            System.out.println("ItemMenu Ayuda Escuchando!");
            
            abrirAyuda = new AbrirAyuda();
            abrirAyuda.abrirArchivo();
        }
        
        //Evento Boton Salir
        if (e.getSource()==aux.getBtnCerrar()) {
            
            System.out.println("Boton Salir Escuchando!");
            
            int i = JOptionPane.showConfirmDialog(null,"Desea Salir?");            
                
                if (i==0) {
                    aux.dispose(); //Elimina la ventana del sistema.
                    System.exit(0);
                }
        }
    }

    
    
}
