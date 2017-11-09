package com.obyhat.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.obyhat.interfaces.CRUD;
import com.obyhat.modelo.conexion.Conexion;
import com.obyhat.modelo.dto.AsignarDTO;
import com.obyhat.modelo.dto.CategoriaDTO;

public class AsignarDAO implements CRUD<AsignarDTO> {

    private static final String SQL_INSERT    = "INSERT INTO asignar (fechaAsignacion, idObra) VALUES (?,?)";
    private static final String SQL_DELETE    = "DELETE FROM asignar WHERE idOrdenSalida = ?";
    private static final String SQL_UPDATE    = "UPDATE asignar SET idOrdenSalida = ?, fechaAsignacion = ?, cantidad = ? WHERE idOrdenSalida = ?";
    private static final String SQL_READ      = "SELECT fechaAsignacion, cantidad FROM asignar WHERE idOrdenSalida = ?";
    private static final String SQL_READALL   = "SELECT fechaAsignacion, cantidad FROM asignar";
    private static final String SQL_READLAST  = "SELECT idAsignacion FROM asignar ORDER BY idAsignacion DESC LIMIT 1";
    private static final String SQL_INSERTDET = "INSERT INTO detalleAsignar (cantidad, idMaterial, idAsignacion) VALUES (?, ?, ?)";
    private static final String SQL_TOTAL_ASI = "SELECT  asignar.idAsignacion, asignar.fechaAsignacion, `nombre`, encargado, SUM(detalleAsignar.cantidad)\n"
            + "FROM `obra`\n"
            + "INNER JOIN asignar USING (idObra)\n"
            + "INNER JOIN detalleAsignar USING (idAsignacion)\n"
            + "GROUP BY detalleAsignar.idAsignacion  \n"
            + "ORDER BY `asignar`.`fechaAsignacion` DESC";
    private static final String SQL_TOTAL_MAT = "SELECT obra.`nombre`, asignar.idAsignacion, asignar.fechaAsignacion, material.nombreMaterial,detalleAsignar.cantidad \n"
            + "FROM `obra`\n"
            + "INNER JOIN asignar USING (idObra)\n"
            + "INNER JOIN detalleAsignar USING (idAsignacion)\n"
            + "INNER JOIN material USING (idMaterial)\n"
            + "WHERE asignar.idAsignacion = ?  \n"
            + "ORDER BY `material`.`nombreMaterial` ASC";

    private static final Conexion miConexion = Conexion.saberEstado();
    private PreparedStatement pStatement = null;
    private ResultSet res;

    @Override
    public boolean Ingresar(AsignarDTO datos) {

        try {

            // Los numeros representan mis signos de interrogacion.
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_INSERT);
            pStatement.setString(1, datos.getFechaAsignacion());
            pStatement.setInt(2, datos.getIdObra());

            // Retornar el valor boolean si esto se ejecuto.
            if (pStatement.executeUpdate() > 0) {

                //JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente", null, JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Procesado exitosamente.");
                return true;
            }

            pStatement.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al registrar todo esto.", null, JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Error al registrar todo esto. \n" + e);
        } finally {

            miConexion.Desconectar();
        }

        return false;
    }

    public boolean insertarDetalles(AsignarDTO datos) {

        try {

            // Los numeros representan mis signos de interrogacion.
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_INSERTDET);
            pStatement.setInt(1, datos.getCantidadSeleccionada());
            pStatement.setInt(2, datos.getIdMaterial());
            pStatement.setInt(3, datos.getIdAsignacion());

            // Retornar el valor boolean si esto se ejecuto.
            if (pStatement.executeUpdate() > 0) {

                //JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente", null, JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Procesado exitosamente.");
                return true;
            }

            pStatement.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al registrar todo esto.", null, JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Error al registrar todo esto. \n" + e);
        } finally {

            miConexion.Desconectar();
        }

        return false;
    }

    @Override
    public AsignarDTO Consultar(Object key) {

        AsignarDTO asignar = null;

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READ);
            pStatement.setString(1, key.toString());

            res = pStatement.executeQuery();

            while (res.next()) {

                //asignar = new AsignarDTO(res.getString(1),res.getInt(2)); 
            }

            return asignar;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al intentar consultar la Categoria. \n" + e, null, JOptionPane.INFORMATION_MESSAGE);
        } finally {

            miConexion.Desconectar();
        }

        return asignar;
    }

    public int obtenerUltimaAsig() {

        int ultimaAsig = 0;

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READLAST);

            res = pStatement.executeQuery();

            while (res.next()) {

                ultimaAsig = res.getInt(1);
            }

            return ultimaAsig;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al intentar consultar la Categoria. \n" + e, null, JOptionPane.INFORMATION_MESSAGE);
        } finally {

            miConexion.Desconectar();
        }

        return ultimaAsig;
    }

    @Override
    public List<AsignarDTO> ConsultarTodos() {

        ArrayList<AsignarDTO> asignar = new ArrayList<>();

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_TOTAL_ASI);

            res = pStatement.executeQuery();

            while (res.next()) {

                asignar.add(new AsignarDTO(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5)));
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al intentar consultar todas las Categorias. \n" + e, null, JOptionPane.INFORMATION_MESSAGE);
        } finally {

            miConexion.Desconectar();
        }

        return asignar;
    }

    public List<AsignarDTO> materialesAsignados(Object key) {

        ArrayList<AsignarDTO> materialesAsig = new ArrayList<>();

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_TOTAL_MAT);
            pStatement.setString(1, key.toString());

            res = pStatement.executeQuery();

            while (res.next()) {

                materialesAsig.add(new AsignarDTO(res.getString(1), res.getInt(2), res.getString(3), res.getString(4), res.getInt(5)));
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al intentar consultar los materiales asignados. \n" + e, null, JOptionPane.INFORMATION_MESSAGE);
        } finally {

            miConexion.Desconectar();
        }

        return materialesAsig;
    }

    @Override
    public boolean Actualizar(AsignarDTO datos) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean Eliminar(Object key) {
        // TODO Auto-generated method stub
        return false;
    }
    
    public static void main(String[] args) {
        AsignarDAO asignarDAO = new AsignarDAO();
        System.out.println(asignarDAO.obtenerUltimaAsig());
    }
}
