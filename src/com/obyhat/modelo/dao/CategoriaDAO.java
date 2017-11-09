package com.obyhat.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.obyhat.interfaces.CRUD;
import com.obyhat.modelo.conexion.Conexion;
import com.obyhat.modelo.dto.CategoriaDTO;
import com.obyhat.modelo.dto.ObrasDTO;
import com.obyhat.resources.components.JOptionPaneMenssage;

public class CategoriaDAO implements CRUD<CategoriaDTO> {

    private static final String SQL_INSERT  = "INSERT INTO categoriaMaterial (nombre, descripcion) VALUES (?, ?)";
    private static final String SQL_UPDATE  = "UPDATE categoriaMaterial SET nombre = ?, descripcion = ? WHERE idCategoria = ?";
    private static final String SQL_DELETE  = "DELETE FROM categoriaMaterial WHERE nombre = ?";
    private static final String SQL_READ    = "SELECT * FROM categoriaMaterial WHERE nombre = ?";
    private static final String SQL_READALL = "SELECT * FROM categoriaMaterial";

    private static final Conexion miConexion = Conexion.saberEstado();
    private PreparedStatement pStatement;
    private ResultSet res;

    @Override
    public boolean Ingresar(CategoriaDTO datos) {

        try {
            // Los numeros representan mis signos de interrogacion.
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_INSERT);
            pStatement.setString(1, datos.getNombreCategoria());
            pStatement.setString(2, datos.getDesCategoria());

            // Retornar el valor boolean si esto se ejecuto.
            if (pStatement.executeUpdate() > 0) {
                    JOptionPaneMenssage.Message("Categoria registrada exitosamente",
                        "Registro exitoso");
                    
                return true;
            }
            pStatement.close();
        } catch (SQLException e) {
            
            JOptionPaneMenssage.Exception_Message(
                    "Categoria DAO: Ingresar \n" + "Error al registrar una nueva Categoria. \n",
                        e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }
        return false;
    }

    @Override
    public boolean Actualizar(CategoriaDTO datos) {

        try {

            // Los numeros representan mis signos de interrogacion.
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_UPDATE);
            pStatement.setString(1, datos.getNombreCategoria());
            pStatement.setString(2, datos.getDesCategoria());
            pStatement.setInt(   3, datos.getIdCategoria());

            // Retornar el valor boolean si esto se ejecuto.
            if (pStatement.executeUpdate() > 0) {
                    JOptionPaneMenssage.Message("Categoria actualizada exitosamente",
                        "Registro exitoso");
                    
                return true;
            }

        } catch (SQLException e) {

              JOptionPaneMenssage.Exception_Message(
                    "Categoria DAO: Actualizar \n" + "Error al intentar actualizar la laategoria. \n",
                        e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }
        return false;
    }

    @Override
    public boolean Eliminar(Object key) {

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_DELETE);
            pStatement.setString(1, key.toString());

            if (pStatement.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Categoria eliminada exitosamente.", null, JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } catch (Exception e) {
            
            JOptionPaneMenssage.Exception_Message(
                    "Categoria DAO: Eliminar \n" + "Error al intentar borrar la categoria. \n",
                    e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }
        return false;
    }

    @Override
    public CategoriaDTO Consultar(Object key) {

        CategoriaDTO categoria = null;

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READ);
            pStatement.setString(1, key.toString());

            res = pStatement.executeQuery();

            while (res.next()) {

                categoria = new CategoriaDTO(res.getInt(1), res.getString(2), res.getString(3));
            }

            return categoria;
        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "Categoria DAO: Consultar \n" + "Error al intentar consultar la categoria. \n",
                    e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }
        return categoria;
    }

    @Override
    public List<CategoriaDTO> ConsultarTodos() {

        ArrayList<CategoriaDTO> categorias = new ArrayList<>();

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READALL);

            res = pStatement.executeQuery();

            while (res.next()) {

                categorias.add(new CategoriaDTO(res.getInt(1), res.getString(2),
                        res.getString(3)));
            }

        } catch (Exception e) {
            
            JOptionPaneMenssage.Exception_Message(
                    "Categoria DAO: ConsultarTodos \n" 
                            + "Error al intentar consultar todas las categorias. \n",
                                e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }
        return categorias;
    }
}
