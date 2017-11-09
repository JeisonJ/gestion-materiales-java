package com.obyhat.resources.components;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

public class PanelJDateChooser extends JPanel {

  JDateChooser fecha;
  Calendar fechaActual;
  JLabel labelTitulo;
  Separator separator;
  String titulo;
  /**
   * Ancho del JDateChooser
   */
  int ancho = 260;
  /**
   * Alto del JDateChooser
   */
  int alto  = 28;

  public PanelJDateChooser() {
    
	  setLayout(null);
	  setOpaque(false);
	  setBackground(Color.BLUE);
	  setPreferredSize(new Dimension(280,60));
	  
	  labelTitulo = new JLabel();
      labelTitulo.setText(titulo);
      labelTitulo.setForeground(new Color(31,31,31));
      labelTitulo.setBounds(5, 0, 212, 25);
      add(labelTitulo);
	  
	  fecha = new JDateChooser();
	  fecha.setBounds(5, 26, 260, 28);
	  add(fecha);
	  
	  separator = new Separator();
	  separator.setBounds(5, 56, 261, 14);
	  add(separator);
	  
	  fechaActual = new GregorianCalendar();
	  fecha.setCalendar(fechaActual);
  }

  /**
   * Metodo que obtiene la fecha seleccionada y le da
   * el formato que acepta MySQL ("yy-MM-dd")
   * @return fecha como dato de tipo String.
   */
  public String getDateFormatSQL() {
    String fecha = "";

    try {

      int year  = this.fecha.getCalendar().get(Calendar.YEAR);
      int month = this.fecha.getCalendar().get(Calendar.MONTH) + 1;
      int day   = this.fecha.getCalendar().get(Calendar.DAY_OF_MONTH);

      fecha = year + "-" + month + "-" + day;

      return fecha;

    } catch (Exception e) {

      return fecha;
    }
  }

  public void setLabelTitulo(JLabel labelTitulo) {
    this.labelTitulo = labelTitulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
  
  public void setAncho(int ancho) {
    this.ancho = ancho;
  }

  public void setAlto(int alto) {
    this.alto = alto;
  }
}
