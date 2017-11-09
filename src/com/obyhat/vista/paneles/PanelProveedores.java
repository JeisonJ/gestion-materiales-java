
package com.obyhat.vista.paneles;
import com.obyhat.controlador.BotonesProveedor;
import com.obyhat.controlador.TextoProveedores;
import com.obyhat.resources.components.txt;
import com.obyhat.resources.components.labelForm;
import com.obyhat.resources.components.Botones;
import com.obyhat.resources.components.labelTitulo;
import com.obyhat.modelo.dto.ProveedorDTO;
import com.obyhat.resources.components.Separator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Jafeht
 */
public class PanelProveedores extends JPanel{
    
    private DefaultTableModel modeloTabla;
    private String [][] datos = {};
    private String [] column = {"Rif","Nombre","Telefono","Dirección","Provee","Email"};
    private JTable TablaProvedorReg;
    
    private JPanel panelCentral,panelIzquierdo;
    private JScrollPane scrollPane,scrollPane2;
    
    private labelForm lNombreRazon,lRif,lDireccion,lEmail,lTelefono,lMaterialesPro;
    private txt txtNombreRazon,txtRif,txtDireccion,txtEmail,txtTelefono;
    private Separator separatorNom,separatorEnc,separatorDir,separatorTel;
    private labelTitulo labelTitulo1,labelTitulo2;
    private Botones btnAgregar,btnModificar,btnEliminar,btnBuscarMat,btnActualizar;
    
    
     
    BotonesProveedor BP = new BotonesProveedor(this);

    private void dimension(int x, int y, JPanel p) {

        Dimension panelD = new Dimension(x, y);
        p.setPreferredSize(panelD);
        p.setMaximumSize(panelD);
    }
    
    public JScrollPane Creandotabla(JScrollPane scrollPane) {

        modeloTabla = new DefaultTableModel(datos, column);

        scrollPane = new JScrollPane();
        TablaProvedorReg = new JTable();
        TablaProvedorReg.getTableHeader().setFont(new Font("Acme", 1, 16));// Encabezado de tablaObras
        //tablaObras.getTableHeader().setBackground(Color.black);
        // tablaObras.getTableHeader().setForeground(Color.BLUE);
        TablaProvedorReg.getTableHeader().setReorderingAllowed(false);// No permite que se muevan las columnas
        TablaProvedorReg.setModel(modeloTabla);
        scrollPane.setViewportView(TablaProvedorReg);

        return scrollPane;
    }
    
    
    public void LimpiarCampos() {
       
          txtRif.setText("");
          txtNombreRazon.setText("");
          txtTelefono.setText("");
          txtDireccion.setText("");
          txtEmail.setText("");
    }
    
    public PanelProveedores() {
        setLayout(new GridLayout(1, 0, 0, 0));

        scrollPane = new JScrollPane();

        JPanel panelContenedor = new JPanel();
        panelContenedor.setBackground(Color.GRAY);
        panelContenedor.setPreferredSize(new Dimension(950, 600));
        panelContenedor.setLayout(new BorderLayout(0, 0));

        PanelIzquierdo();
        PanelCentral();

        panelContenedor.add(panelIzquierdo, BorderLayout.WEST);
        panelContenedor.add(panelCentral, BorderLayout.CENTER);

        scrollPane.setViewportView(panelContenedor);
        add(scrollPane);

        Control();

        //BP.ObtenerProveedor();
    }
    

    public void Control() {

        TextoProveedores CM = new TextoProveedores(this);
        txtTelefono.addKeyListener(CM);
        btnModificar.addActionListener(BP);
        btnAgregar.addActionListener(BP);
        btnEliminar.addActionListener(BP);
        btnBuscarMat.addActionListener(BP);
        btnActualizar.addActionListener(BP);
    }

    private void PanelIzquierdo() {

        /*---------------------------------------------------------------------*/
 /*-------------------- Contenedor Panel Izquierdo ---------------------*/
        // CONSTANTES
        // Separacion del Borde Izquierdo.
        int SBI = 25;

        panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(new Color(46, 64, 83));
        panelIzquierdo.setLayout(null);
        panelIzquierdo.setBorder(new LineBorder(new Color(42, 59, 80), 3, true));

        labelTitulo1 = new labelTitulo("Registrar Proveedores");
        labelTitulo1.setBounds(23, 20, 245, 25);
        panelIzquierdo.add(labelTitulo1);

        lRif = new labelForm("Rif");
        lRif.setBounds(24, 80, 212, 25);
        panelIzquierdo.add(lRif);
        txtRif = new txt();
        txtRif.setBounds(25, 110, 291, 28);
        panelIzquierdo.add(txtRif);
        separatorNom = new Separator();
        separatorNom.setBounds(25, 140, 290, 14);
        panelIzquierdo.add(separatorNom);

        lNombreRazon = new labelForm("Nombre O Razon Social");
        lNombreRazon.setBounds(24, 150, 212, 25);
        panelIzquierdo.add(lNombreRazon);
        txtNombreRazon = new txt();
        txtNombreRazon.setBounds(25, 180, 291, 28);
        panelIzquierdo.add(txtNombreRazon);
        separatorDir = new Separator();
        separatorDir.setBounds(25, 210, 290, 14);
        panelIzquierdo.add(separatorDir);

        lTelefono = new labelForm("Telefono");
        lTelefono.setBounds(24, 220, 212, 25);
        panelIzquierdo.add(lTelefono);
        txtTelefono = new txt();
        txtTelefono.setBounds(25, 250, 291, 28);
        panelIzquierdo.add(txtTelefono);
        separatorDir = new Separator();
        separatorDir.setBounds(25, 280, 290, 14);
        panelIzquierdo.add(separatorDir);

        lDireccion = new labelForm("Direccion");
        lDireccion.setBounds(24, 290, 212, 25);
        panelIzquierdo.add(lDireccion);
        txtDireccion = new txt();
        txtDireccion.setBounds(25, 315, 291, 28);
        panelIzquierdo.add(txtDireccion);
        separatorDir = new Separator();
        separatorDir.setBounds(25, 345, 290, 14);
        panelIzquierdo.add(separatorDir);

        lEmail = new labelForm("Email");
        lEmail.setBounds(24, 350, 212, 25);
        panelIzquierdo.add(lEmail);
        txtEmail = new txt();
        txtEmail.setBounds(25, 380, 291, 28);
        panelIzquierdo.add(txtEmail);
        separatorDir = new Separator();
        separatorDir.setBounds(25, 410, 290, 14);
        panelIzquierdo.add(separatorDir);

        btnAgregar = new Botones("Agregar");
        btnAgregar.setBounds(25, 511, 90, 35);
        panelIzquierdo.add(btnAgregar);

        btnActualizar = new Botones("Actualizar");
        btnActualizar.setEnabled(false);
        btnActualizar.setBounds(126, 511, 90, 35);
        panelIzquierdo.add(btnActualizar);

        btnEliminar = new Botones("Eliminar");
        // btnEliminar.setEnabled(false);
        btnEliminar.setBounds(226, 511, 90, 35);
        panelIzquierdo.add(btnEliminar);

        dimension(350, 0, panelIzquierdo);

    }


    private void PanelCentral() {

        /*---------------------------------------------------------------------*/
 /*--------------------- Contenedor Panel Central ----------------------*/
        // CONSTANTES
        //Ancho del Panel Este y Panel Oeste.
        int PEO = 15;

        //Alto del Panel Norte y Panel Sur.
        int PNS = 140;

        panelCentral = new JPanel();
        //panelCentral.setBackground(new Color(52, 73, 94));
        panelCentral.setLayout(new BorderLayout());

        JPanel PN = new JPanel();
        PN.setBackground(new Color(52, 73, 94));
        dimension(0, PNS, PN);
        PN.setLayout(new BorderLayout());
        labelTitulo2 = new labelTitulo("Proveedores Registrados");
        labelTitulo2.setBounds(23, 47, 275, 25);
        panelCentral.add(labelTitulo2);
        panelCentral.add(PN, BorderLayout.NORTH);

        JPanel PN1 = new JPanel();
        PN1.setOpaque(false);
        PN1.setPreferredSize(new Dimension(0, 60));

        /*buscar = new labelForm("Buscar por nombre: ");
        PN1.add(buscar);
        txtBuscar = new txt();
        txtBuscar.addKeyListener(CT);
	txtBuscar.setPreferredSize(new Dimension(250, 28));
	PN1.add(txtBuscar);*/
        btnBuscarMat = new Botones("<---  Actualizar");
        btnBuscarMat.setPreferredSize(new Dimension(285, 35));

        PN1.add(btnBuscarMat);
        PN.add(PN1, BorderLayout.SOUTH);

        JPanel PO = new JPanel();
        PO.setBackground(new Color(52, 73, 94));
        dimension(PEO, 0, PO);
        panelCentral.add(PO, BorderLayout.WEST);

        PanelInicio PC = new PanelInicio();
        PC.setLayout(new BorderLayout());
        PC.add(Creandotabla(scrollPane2));
        panelCentral.add(PC);

        JPanel PE = new JPanel();
        PE.setBackground(new Color(52, 73, 94));
        dimension(PEO, 0, PE);
        panelCentral.add(PE, BorderLayout.EAST);

        JPanel PS = new JPanel();
        PS.setBackground(new Color(52, 73, 94));
        dimension(0, PNS, PS);
        panelCentral.add(PS, BorderLayout.SOUTH);

        btnModificar = new Botones("Modificar Proveedor");
        btnModificar.setPreferredSize(new Dimension(150, 35));
        PS.add(btnModificar);
        PS.add(PO, BorderLayout.SOUTH);

    }
     
    public ProveedorDTO ObtenerDatos() {

        return new ProveedorDTO(
                this.txtRif.getText(),
                this.txtNombreRazon.getText(),
                this.txtTelefono.getText(),
                this.txtDireccion.getText(),
                this.txtEmail.getText());
                

    }

    public void llenarTabla(Object datos[]) {

        this.modeloTabla.addRow(datos);

    }

    public void limpiarTabla() {

        for (int i = 0; i < TablaProvedorReg.getRowCount(); i++) {

            getModeloTabla().removeRow(i);
            i -= 1;
        }
    }
    
    public final void insertarTabla(Object data[]) {

        this.modeloTabla.addRow(data);
    }
    
 public void llenarFormulario(ProveedorDTO datos) {
 txtRif.setText(datos.getRif());
 txtNombreRazon.setText(datos.getRazonSocial());
 txtTelefono.setText(datos.getTelefono());
 txtDireccion.setText(datos.getDireccion());
 txtEmail.setText(datos.getEmail());
 
 
 }
    
    public String[][] getDatos() {
        return datos;
    }

    public void setDatos(String[][] datos) {
        this.datos = datos;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public String[] getColumn() {
        return column;
    }

    public void setColumn(String[] column) {
        this.column = column;
    }

    public JTable getTablaProvedorReg() {
        return TablaProvedorReg;
    }

    public void setTablaProvedorReg(JTable TablaProvedorReg) {
        this.TablaProvedorReg = TablaProvedorReg;
    }

    public labelForm getlNombreRazon() {
        return lNombreRazon;
    }

    public void setlNombreRazon(labelForm lNombreRazon) {
        this.lNombreRazon = lNombreRazon;
    }

    public labelForm getlRif() {
        return lRif;
    }

    public void setlRif(labelForm lRif) {
        this.lRif = lRif;
    }

    public labelForm getlDireccion() {
        return lDireccion;
    }

    public void setlDireccion(labelForm lDireccion) {
        this.lDireccion = lDireccion;
    }

    public labelForm getlEmail() {
        return lEmail;
    }

    public void setlEmail(labelForm lEmail) {
        this.lEmail = lEmail;
    }

    public labelForm getlTelefono() {
        return lTelefono;
    }

    public void setlTelefono(labelForm lTelefono) {
        this.lTelefono = lTelefono;
    }

    public labelForm getlMaterialesPro() {
        return lMaterialesPro;
    }

    public void setlMaterialesPro(labelForm lMaterialesPro) {
        this.lMaterialesPro = lMaterialesPro;
    }

    public txt getTxtNombreRazon() {
        return txtNombreRazon;
    }

    public void setTxtNombreRazon(txt txtNombreRazon) {
        this.txtNombreRazon = txtNombreRazon;
    }

    public txt getTxtRif() {
        return txtRif;
    }

    public void setTxtRif(txt txtRif) {
        this.txtRif = txtRif;
    }

    public txt getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(txt txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public txt getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(txt txtEmail) {
        this.txtEmail = txtEmail;
    }

    public txt getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(txt txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public Botones getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(Botones btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public Botones getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(Botones btnModificar) {
        this.btnModificar = btnModificar;
    }

    public Botones getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(Botones btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public Botones getBtnBuscarMat() {
        return btnBuscarMat;
    }

    public void setBtnBuscarMat(Botones btnBuscarMat) {
        this.btnBuscarMat = btnBuscarMat;
    }

    public Botones getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(Botones btnActualizar) {
        this.btnActualizar = btnActualizar;
    }
     
     public static void main(String args[]) {
        JFrame frame = new JFrame("Probando panel individual...");
        frame.setLayout(new GridLayout());
        PanelProveedores PA = new PanelProveedores();
        frame.add(PA);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBackground(Color.WHITE);
        frame.setSize(1300, 650);
        frame.setLocation(100, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
