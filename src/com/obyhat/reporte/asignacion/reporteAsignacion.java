/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obyhat.reporte.asignacion;

import com.obyhat.reporte.material.*;
import com.obyhat.modelo.conexion.Conexion;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jeis
 */
public class reporteAsignacion {
    
    private static final Conexion miConexion = Conexion.saberEstado();
    
    private String      ruta;
    private URL         url;
    private File        archivo;
    public static       JasperReport reporte;
    public static       JasperViewer viewReport;
    public static       JasperPrint  printReport;
    private Map<String, Object>      parametro;
    
    public void generarReporte(String obra, String encargado , String codigo, 
            String fechaAsignacion, String idAsignacion) {

        try {
          ///home/jeis/Documentos/workspace/Java/TECNOLOGICO/OBYHAT/ProyectoOBYHAT/src/com/obyhat/reporte/asignacion/reportAsignacion.jasper
            this.ruta    = "/com/obyhat/reporte/asignacion/reportAsignacion.jasper";
            this.url     = this.getClass().getResource(ruta);
            this.archivo = new File(this.url.toURI());
            System.out.println("Cargando desde: " + this.archivo);

            if(archivo == null){
                JOptionPane.showMessageDialog(
                    null,"Surgio un problema al intentar encontrar"
                        + "el archivo de reporte, verifique\n", 
                            "Generar Reporte",JOptionPane.ERROR_MESSAGE);

            }
        } catch (Exception e1) {

            System.out.println("Error del reporte \n" + e1);
        }

            try {
               
                this.reporte = (JasperReport) JRLoader.loadObject(this.archivo);
                
                this.parametro= new HashMap();
                this.parametro.put("obra",              obra);
                this.parametro.put("encargado",         encargado);
                this.parametro.put("codigo",            codigo);
                this.parametro.put("fechaAsignacion",   fechaAsignacion);
                this.parametro.put("idAsignacion",      idAsignacion);
               

                this.printReport = JasperFillManager.fillReport(
                        reporte,parametro,miConexion.obtenerConexion());
                
                this.viewReport  = new JasperViewer(this.printReport,false);
                viewReport.setTitle("Reporte");
            viewReport.setVisible(true);
                
            } catch (Exception f) {
                f.printStackTrace();
                JOptionPane.showMessageDialog(
                        null,"Error al generar reporte: "+f.getMessage(),
                            "Generar Reporte",JOptionPane.ERROR_MESSAGE);
            }
    }
    
//    public static void main(String[] args) {
//        reporteAsignacion rp =new reporteAsignacion();
//        rp.generarReporte("s","s","s","s","1");
//    }
}
