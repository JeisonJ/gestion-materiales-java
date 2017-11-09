package com.obyhat.vista.paneles;

import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.obyhat.controlador.usuario.BotonesUsuario;
import com.obyhat.modelo.dto.UsuarioDTO;
import com.obyhat.resources.components.txt;
import com.obyhat.resources.components.Botones;
import com.obyhat.resources.components.Separator;
import com.obyhat.resources.components.labelTitulo;

/**
 * @author Jeis
 */
public class PanelUsuarios extends JPanel {

    // Componentes para JTable Usuarios.
    private JTable tablaUsuarios;
    private String[] column = {"idUsuario", "Usuario", "Tipo de Usuario"};
    private String[][] datos = {};
    private DefaultTableModel modeloTabla;

    private JPasswordField txtContrasena;
    private JScrollPane scrollPane, scrollPane2;
    private JPanel panelCentral, panelIzquierdo,
            panelContenedor;
    private JComboBox<UsuarioDTO> comboTipoUsuario;

    // Componentes personalizados.
    private txt txtNombreUsuario, txtCodigo;
    private labelTitulo labelTitulo2;
    private Botones btnActualizar, btnCancelar, btnBuscar,
            btnEliminar, btnAgregar, btnModificar;
    private GridBagConstraints gbc = new GridBagConstraints();
    public static final Color COLOR_FONDO = new Color(52, 73, 94);

    // Controladores.
    private BotonesUsuario BU = new BotonesUsuario(this);

    public PanelUsuarios() {

        setLayout(new GridLayout(1, 0, 0, 0));
        scrollPane = new JScrollPane();
        panelContenedor = new JPanel();
        panelContenedor.setLayout(new BorderLayout(0, 0));
        panelContenedor.setPreferredSize(new Dimension(950, 600));
        PanelCentral();
        PanelIzquierdo();
        panelContenedor.add(panelIzquierdo, BorderLayout.WEST);
        panelContenedor.add(panelCentral, BorderLayout.CENTER);
        scrollPane.setViewportView(panelContenedor);
        add(scrollPane);

        /**
         * Metodos en la clase encargados de llenar el JComboBox de tipos de
         * usuarios y la Tabla de usuarios con la consulta la base de datos.
         */
        this.BU.obtenerUsuarios();
        this.BU.getUserType(comboTipoUsuario);
    }

    private void PanelIzquierdo() {

        panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BorderLayout());
        panelIzquierdo.setBackground(new Color(46, 64, 83));
        panelIzquierdo.setPreferredSize(new Dimension(300, 0));
        panelIzquierdo.setBorder(new LineBorder(new Color(42, 59, 80), 3, true));

        JPanel panel1 = new JPanel();
        panel1.setOpaque(false);
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelIzquierdo.add(panel1, BorderLayout.NORTH);

        labelTitulo l1 = new labelTitulo("  Registrar usuarios");
        panel1.add(l1);

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridBagLayout());
        panelIzquierdo.add(panel);
        gbc.insets = new Insets(5, 0, 5, 0);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JPanel P0 = new JPanel();
        P0.setOpaque(false);
        P0.setLayout(null);
        P0.setPreferredSize(new Dimension(280, 60));
        JLabel l0 = new JLabel("Codigo");
        l0.setForeground(Color.WHITE);
        l0.setBounds(5, 0, 212, 25);
        P0.add(l0);
        txtCodigo = new txt();
        txtCodigo.setBounds(5, 26, 261, 28);
        txtCodigo.setEditable(false);
        P0.add(txtCodigo);
        Separator S0 = new Separator();
        S0.setBounds(5, 56, 261, 14);
        P0.add(S0);
        panel.add(P0, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JPanel P2 = new JPanel();
        P2.setOpaque(false);
        P2.setLayout(null);
        P2.setPreferredSize(new Dimension(280, 60));
        JLabel l2 = new JLabel("Usuario");
        l2.setForeground(Color.WHITE);
        l2.setBounds(5, 0, 212, 25);
        P2.add(l2);
        txtNombreUsuario = new txt();
        txtNombreUsuario.setBounds(5, 26, 261, 28);
        P2.add(txtNombreUsuario);
        Separator S2 = new Separator();
        S2.setBounds(5, 56, 261, 14);
        P2.add(S2);
        panel.add(P2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JPanel P3 = new JPanel();
        P3.setOpaque(false);
        P3.setLayout(null);
        P3.setPreferredSize(new Dimension(280, 60));
        JLabel l3 = new JLabel("Contrasena");
        l3.setForeground(Color.WHITE);
        l3.setBounds(5, 0, 212, 25);
        P3.add(l3);
        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(5, 26, 261, 28);
        P3.add(txtContrasena);
        Separator S3 = new Separator();
        S3.setBounds(5, 56, 261, 14);
        P3.add(S3);
        panel.add(P3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JPanel P4 = new JPanel();
        P4.setOpaque(false);
        P4.setLayout(null);
        P4.setPreferredSize(new Dimension(280, 60));
        JLabel l4 = new JLabel("Tipo de usuario");
        l4.setForeground(Color.WHITE);
        l4.setBounds(5, 0, 212, 25);
        P4.add(l4);
        comboTipoUsuario = new JComboBox();
        comboTipoUsuario.setBounds(5, 26, 261, 28);
        P4.add(comboTipoUsuario);
        Separator S4 = new Separator();
        S4.setBounds(5, 56, 261, 14);
        P4.add(S4);
        panel.add(P4, gbc);

        gbc.insets = new Insets(45, 0, 5, 0);

        // JPanel Contenedor de botones
        gbc.gridx = 0;
        gbc.gridy = 4;
        JPanel PCB = new JPanel();
        //PCB.setPreferredSize(new Dimension(300, 50));
        //PCB.setBounds(10,24,850, 50);
        PCB.setOpaque(false);
        PCB.setLayout(new FlowLayout());
        panel.add(PCB, gbc);

        btnAgregar = new Botones("Agregar");
        //btnAgregar.setEnabled(false);
        btnAgregar.setPreferredSize(new java.awt.Dimension(90, 35));
        btnAgregar.addActionListener(BU);
        PCB.add(btnAgregar);

        btnActualizar = new Botones("Actualizar");
        //btnActualizar.setEnabled(false);
        btnActualizar.setPreferredSize(new java.awt.Dimension(90, 35));
        btnActualizar.addActionListener(BU);
        PCB.add(btnActualizar);

        btnCancelar = new Botones("Cancelar");
        //btnCancelar.setEnabled(false);
        btnCancelar.setPreferredSize(new java.awt.Dimension(90, 35));
        btnCancelar.addActionListener(BU);
        PCB.add(btnCancelar);
    }

    private void PanelCentral() {

        // CONSTANTES
        //Ancho del Panel Este y Panel Oeste.
        int PEO = 15;

        //Alto del Panel Norte y Panel Sur.
        int PNS = 140;

        panelCentral = new JPanel();
        //panelCentral.setBackground(new Color(52, 73, 94));
        panelCentral.setLayout(new BorderLayout());

        JPanel PN = new JPanel();
        PN.setLayout(new BorderLayout());
        PN.setBackground(new Color(52, 73, 94));
        dimension(0, PNS, PN);
        labelTitulo2 = new labelTitulo("Usuarios Registrados");
        labelTitulo2.setBounds(23, 47, 295, 25);
        panelCentral.add(labelTitulo2);
        panelCentral.add(PN, BorderLayout.NORTH);

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
        PS.setLayout(null);
        PS.setBackground(new Color(52, 73, 94));
        dimension(0, PNS, PS);

        //JPanel Contenedor de botones
        JPanel PCB = new JPanel();
        PCB.setBounds(10, 24, 850, 50);
        PCB.setOpaque(false);
        PCB.setLayout(new FlowLayout(FlowLayout.LEFT));

        btnModificar = new Botones("Modificar usuario");
        //btnModificar.setEnabled(false);
        btnModificar.setPreferredSize(new java.awt.Dimension(180, 35));
        btnModificar.addActionListener(BU);
        PCB.add(btnModificar);

        btnEliminar = new Botones("Eliminar usuario");
        //btnEliminar.setEnabled(false);
        btnEliminar.setPreferredSize(new java.awt.Dimension(180, 35));
        btnEliminar.addActionListener(BU);
        PCB.add(btnEliminar);
        PS.add(PCB);

        panelCentral.add(PS, BorderLayout.SOUTH);
    }

    public JScrollPane Creandotabla(JScrollPane scrollPane) {

        modeloTabla = new DefaultTableModel(datos, column);

        scrollPane = new JScrollPane();
        tablaUsuarios = new JTable();
        tablaUsuarios.getTableHeader().setFont(new Font("Acme", 0, 16));
        tablaUsuarios.setModel(modeloTabla);
        scrollPane.setViewportView(tablaUsuarios);

        // Enviaando los datos requeridos por el metodo para ocultar
        // las filas.
        // Quiero ocultar las filas 0.
        setOcultarColumnasJTable(tablaUsuarios, new int[]{0});

        return scrollPane;
    }

    private void setOcultarColumnasJTable(JTable tbl, int columna[]) {

        // Recibe como parametro la Tabla y las filas a ocultar.
        for (int i = 0; i < columna.length; i++) {

            tbl.getColumnModel().getColumn(columna[i]).setMaxWidth(0);
            tbl.getColumnModel().getColumn(columna[i]).setMinWidth(0);
            tbl.getTableHeader().getColumnModel().getColumn(columna[i]).setMaxWidth(0);
            tbl.getTableHeader().getColumnModel().getColumn(columna[i]).setMinWidth(0);
        }
    }

    public void vaciarFormulario() {

        this.txtCodigo.setText("");
        txtNombreUsuario.setText("");
        txtContrasena.setText("");
        comboTipoUsuario.setSelectedIndex(0);
    }

    public void llenarFormulario(UsuarioDTO datos, int posicion) {

        this.txtCodigo.setText(String.valueOf(datos.getIdUsuario()));
        txtNombreUsuario.setText(datos.getNombre());
        txtContrasena.setText(datos.getContrasena());
        comboTipoUsuario.setSelectedIndex(posicion);

    }

    public void limpiarTabla() {

        for (int i = 0; i < tablaUsuarios.getRowCount(); i++) {

            modeloTabla.removeRow(i);
            i -= 1;
        }
    }

    public final void insertarTabla(Object data[]) {

        this.modeloTabla.addRow(data);
    }

    public int getCodigoInt() {

        try {
            return Integer.parseInt(this.txtCodigo.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public UsuarioDTO ObtenerDatos() {

        return new UsuarioDTO(
                this.getCodigoInt(),
                this.txtNombreUsuario.getText(),
                this.obtenerPassword(),
                this.comboTipoUsuario.getItemAt(
                        comboTipoUsuario.getSelectedIndex()).getIdTipoUsuario());
    }

    public String obtenerPassword() {

        char[] arrayC = txtContrasena.getPassword();
        String pass = new String(arrayC);

        return pass;
    }

    private void dimension(int x, int y, JPanel p) {

        Dimension panelD = new Dimension(x, y);
        p.setPreferredSize(panelD);
        p.setMaximumSize(panelD);
    }

    public Botones getBtnActualizar() {
        return btnActualizar;
    }

    public Botones getBtnCancelar() {
        return btnCancelar;
    }

    public Botones getBtnBuscar() {
        return btnBuscar;
    }

    public Botones getBtnEliminar() {
        return btnEliminar;
    }

    public Botones getBtnAgregar() {
        return btnAgregar;
    }

    public Botones getBtnModificar() {
        return btnModificar;
    }

    public JTable getTablaUsuarios() {
        return tablaUsuarios;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public JComboBox<UsuarioDTO> getComboTipoUsuario() {
        return comboTipoUsuario;
    }
//
//    public static void main(String args[]) {
//        JFrame frame = new JFrame("Probando panel individual...");
//        frame.setLayout(new GridLayout());
//        PanelUsuarios PA = new PanelUsuarios();
//        frame.add(PA);
//        frame.getContentPane().setBackground(Color.WHITE);
//        frame.setBackground(Color.WHITE);
//        frame.setSize(1300, 650);
//        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
}
