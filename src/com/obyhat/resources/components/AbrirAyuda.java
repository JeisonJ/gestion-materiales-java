/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.obyhat.resources.components;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AbrirAyuda {

    public void abrirArchivo() {
    
        //ruta del archivo en el pc
        //String file = new String("E:\\pruebaArchivo\\ArchivoPrueba.xlsx"); 
     
        //rutal del archivo desde el src del proyecto
        String fileLocal = new String("help/Manual.pdf"); 
        try{ 
       
        File path = new File (fileLocal);
        Desktop.getDesktop().open(path);
        
        }catch(IOException e){
            e.printStackTrace();
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(
                    null, "No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } 
    }
    public static void main(String[] args) {
        new AbrirAyuda().abrirArchivo();
    }
}
