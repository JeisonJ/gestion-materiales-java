package com.obyhat.vista.paneles;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.obyhat.controlador.BotonesHistorialAsig;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

public class HistorialAsignaciones extends JFrame {

  private DefaultTableModel modeloTablaTot, modeloTablaMat;
  private String[][] datosMat = {};
  private String[][] datosTot = {};
  private String[]   columnTot = {"Codigo","Fecha", "Obra", "Encargado", "Total despachado"};
  private String[]   columnMat = {"Material", "Cantidad"};
  private JTable     tablaTotalAsig,tablaMat;

  private JScrollPane scrollPane;
  private JPanel      contentPane, panelTablaAsig, panelTablaTotalMat;
  private JLabel      tituloVentanaAsig,lnombreObra,lfechaAsignacion;
  private JButton     btnMostrar, btnAtras, btnReporte;
  
  private BotonesHistorialAsig BH = new BotonesHistorialAsig(this);

  public static final Color Color = new Color(46, 64, 83);

  /** Launch the application. */
  public static void main(String[] args) {
    EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            try {
              HistorialAsignaciones frame = new HistorialAsignaciones();
              frame.setVisible(true);
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
  }

  /** Create the frame. */
  public HistorialAsignaciones() {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    setBounds(100, 100, 785, 475);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);

    JPanel PO = new JPanel();
    PO.setPreferredSize(new Dimension(50, 10));
    PO.setBackground(Color);
    contentPane.add(PO, BorderLayout.WEST);
    JPanel PE = new JPanel();
    PE.setPreferredSize(new Dimension(50, 10));
    PE.setBackground(Color);
    contentPane.add(PE, BorderLayout.EAST);
    JPanel PN = new JPanel();
    PN.setPreferredSize(new Dimension(10, 20));
    PN.setBackground(Color);
    contentPane.add(PN, BorderLayout.NORTH);
    JPanel PS = new JPanel();
    

    JPanel PC = new JPanel();
    PC.setBackground(Color.GRAY);
    contentPane.add(PC, BorderLayout.CENTER);
    PC.setLayout(null);

    panelTablaAsig = new JPanel();
    panelTablaAsig.setBounds(0, 0, 671, 339);
    panelTablaAsig.setBackground(Color.PINK);
    panelTablaAsig.setLayout(new BorderLayout(0, 0));
    PC.add(panelTablaAsig);

    JPanel datos2 = new JPanel();
    datos2.setLayout(new FlowLayout());
    datos2.setPreferredSize(new Dimension(10, 50));
    panelTablaAsig.add(datos2, BorderLayout.NORTH);
    
    tituloVentanaAsig = new JLabel("Historial de asignaciones");
    datos2.add(tituloVentanaAsig);
    
    modeloTablaTot = new DefaultTableModel(null, columnTot);
    scrollPane = new JScrollPane();
    tablaTotalAsig = new JTable();
    tablaTotalAsig.getTableHeader().setFont(new Font("Acme", 1, 15)); // Encabezado de tablaTotalAsig.
    tablaTotalAsig.setModel(modeloTablaTot);
    scrollPane.setViewportView(tablaTotalAsig);
    panelTablaAsig.add(scrollPane, BorderLayout.CENTER);

    /**/
    
    panelTablaTotalMat = new JPanel();
    panelTablaTotalMat.setBounds(0, 0, 671, 339);
    panelTablaTotalMat.setBackground(Color.PINK);
    panelTablaTotalMat.setLayout(new BorderLayout(0, 0));
    PC.add(panelTablaTotalMat);

    JPanel datos = new JPanel();
    datos.setLayout(new FlowLayout());
    datos.setPreferredSize(new Dimension(10, 50));
    panelTablaTotalMat.add(datos, BorderLayout.NORTH);
    
    lnombreObra = new JLabel("Obra tal");
    datos.add(lnombreObra);
    lfechaAsignacion = new JLabel("Fecha cual");
    datos.add(lfechaAsignacion);

    modeloTablaMat = new DefaultTableModel(null, columnMat);
    scrollPane = new JScrollPane();
    tablaMat = new JTable();
    tablaMat.getTableHeader().setFont(new Font("Acme", 1, 15)); // Encabezado de tablaMat.
    tablaMat.setModel(modeloTablaMat);
    scrollPane.setViewportView(tablaMat);
    panelTablaTotalMat.add(scrollPane, BorderLayout.CENTER);
    
    /**/
    
    PS.setPreferredSize(new Dimension(10, 80));
    PS.setBackground(Color);
    contentPane.add(PS, BorderLayout.SOUTH);

    btnMostrar = new JButton("Mostrar cantidad de materiales");
    btnMostrar.addActionListener(BH);
    PS.add(btnMostrar);

    btnReporte = new JButton("Generar reporte");
    btnReporte.addActionListener(BH);
    PS.add(btnReporte);
    
    btnAtras = new JButton("Atras");
    btnAtras.addActionListener(BH);
    PS.add(btnAtras);
    
    this.BH.obtenerAsignaciones();
  }

  public void insertarTabla(Object[] datos){
	
	  this.modeloTablaTot.addRow(datos);
  }
  

  public void insertarTablaMat(Object[] datos){
		
	  this.modeloTablaMat.addRow(datos);
  }
  
  public void limpiarTabla() {
  	
  	for (int i = 0; i < tablaMat.getRowCount(); i++) {
          
          modeloTablaMat.removeRow(i);
          i-=1;
      }
  }
  
  public JButton getBtnMostrar() {
    return btnMostrar;
  }

  public void setBtnMostrar(JButton btnMostrar) {
    this.btnMostrar = btnMostrar;
  }

  public JButton getBtnReporte() {
    return btnReporte;
 }

  public JButton getBtnAtras() {
    return btnAtras;
  }

  public void setBtnAtras(JButton btnAtras) {
    this.btnAtras = btnAtras;
  }

  public JPanel getPanelTablaAsig() {
    return panelTablaAsig;
  }

  public void setPanelTablaAsig(JPanel panelTablaAsig) {
    this.panelTablaAsig = panelTablaAsig;
  }

  public JPanel getPanelTablaTotalMat() {
    return panelTablaTotalMat;
  }

  public void setPanelTablaTotalMat(JPanel panelTablaTotalMat) {
    this.panelTablaTotalMat = panelTablaTotalMat;
  }

  public JTable getTablaTotalAsig() {
    return tablaTotalAsig;
  }

  public void setTablaTotalAsig(JTable tablaTotalAsig) {
    this.tablaTotalAsig = tablaTotalAsig;
  }

  public JTable getTablaMat() {
    return tablaMat;
  }

  public void setTablaMat(JTable tablaMat) {
    this.tablaMat = tablaMat;
  }

  public JLabel getLnombreObra() {
    return lnombreObra;
  }

  public void setLnombreObra(JLabel lnombreObra) {
    this.lnombreObra = lnombreObra;
  }

  public JLabel getLfechaAsignacion() {
    return lfechaAsignacion;
  }

  public void setLfechaAsignacion(JLabel lfechaAsignacion) {
    this.lfechaAsignacion = lfechaAsignacion;
  }
  
}
