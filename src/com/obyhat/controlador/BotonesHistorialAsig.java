package com.obyhat.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.obyhat.modelo.dao.AsignarDAO;
import com.obyhat.modelo.dao.MaterialesDAO;
import com.obyhat.modelo.dto.AsignarDTO;
import com.obyhat.reporte.asignacion.reporteAsignacion;
import com.obyhat.vista.paneles.HistorialAsignaciones;

public class BotonesHistorialAsig implements ActionListener {

    private HistorialAsignaciones historialAsignaciones;
    private MaterialesDAO         materiales;
    private AsignarDAO            asignarDAO;
    private reporteAsignacion     reporteAsignacion;

    public BotonesHistorialAsig(HistorialAsignaciones historialAsignaciones) {

        this.historialAsignaciones = historialAsignaciones;
        this.materiales = new MaterialesDAO();
        this.asignarDAO = new AsignarDAO();
        this.reporteAsignacion = reporteAsignacion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.historialAsignaciones.getBtnMostrar()) {

            System.out.println("Boton mostrar escuchando");

            this.historialAsignaciones.limpiarTabla();
            this.obtenerMaterialesAsig();
        }
        
        if (e.getSource() == this.historialAsignaciones.getBtnReporte()) {

            System.out.println("Boton reporte escuchando");

            this.generarReporteAsignacion();
        }

        if (e.getSource() == this.historialAsignaciones.getBtnAtras()) {

            System.out.println("Boton atras escuchando");

            historialAsignaciones.getPanelTablaTotalMat().setVisible(false);
            historialAsignaciones.getPanelTablaAsig().setVisible(true);
        }
    }

    public void obtenerMaterialesAsig() {

        int filaSelecionada = historialAsignaciones.getTablaTotalAsig().getSelectedRow();
        System.out.println(filaSelecionada);

        if (filaSelecionada != -1) {

            try {

                historialAsignaciones.getPanelTablaTotalMat().setVisible(true);
                historialAsignaciones.getPanelTablaAsig().setVisible(false);

                int idAsignacion = Integer.parseInt(historialAsignaciones.getTablaTotalAsig().getValueAt(
                        filaSelecionada, 0).toString());

                List<AsignarDTO> materialesAsig = this.asignarDAO.materialesAsignados(idAsignacion);

                this.historialAsignaciones.getLnombreObra().setText(materialesAsig.get(1).getObra() + "     ");
                this.historialAsignaciones.getLfechaAsignacion().setText("     " + materialesAsig.get(1).getFechaAsignacion());

                for (int i = 0; i < materialesAsig.size(); i++) {

                    this.historialAsignaciones.insertarTablaMat(new Object[]{
                        materialesAsig.get(i).getNombreMaterial(),
                        materialesAsig.get(i).getCantidadSeleccionada()});
                }

            } catch (Exception e2) {

                JOptionPane.showMessageDialog(null, 
                        "Error al obtener los datos de los materiales asignados", 
                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {

            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }

    public void obtenerAsignaciones() {

        try {

            List<AsignarDTO> asignaciones = this.asignarDAO.ConsultarTodos();

            for (int i = 0; i < asignaciones.size(); i++) {

                this.historialAsignaciones.insertarTabla(new Object[]{
                    asignaciones.get(i).getIdAsignacion(),
                    asignaciones.get(i).getFechaAsignacion(),
                    asignaciones.get(i).getObra(),
                    asignaciones.get(i).getEncargadoObra(),
                    asignaciones.get(i).getSumaMaterialesAsig()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener las asignaciones \n" + e);
        }
    }
    
    public void generarReporteAsignacion() {

        int filaSeleccionada = this.historialAsignaciones.getTablaTotalAsig().getSelectedRow();

        if (filaSeleccionada != -1) {

            String codigo    = this.historialAsignaciones.getTablaTotalAsig().getValueAt(
                    filaSeleccionada, 0).toString();
            String fecha     = this.historialAsignaciones.getTablaTotalAsig().getValueAt(
                    filaSeleccionada, 1).toString();
            String obra      = this.historialAsignaciones.getTablaTotalAsig().getValueAt(
                    filaSeleccionada, 2).toString();
            String encargado = this.historialAsignaciones.getTablaTotalAsig().getValueAt(
                    filaSeleccionada, 3).toString();
           
            
            this.reporteAsignacion = new reporteAsignacion();
            this.reporteAsignacion.generarReporte(obra,encargado,codigo,fecha,
                    codigo);
            
        } else {

            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }
}
