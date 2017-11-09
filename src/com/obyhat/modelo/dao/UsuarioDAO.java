package com.obyhat.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.obyhat.interfaces.CRUD;
import com.obyhat.modelo.conexion.Conexion;
import com.obyhat.modelo.dto.UsuarioDTO;
import com.obyhat.resources.components.JOptionPaneMenssage;

public class UsuarioDAO implements CRUD<UsuarioDTO> {

    private static final String SQL_INSERT = "INSERT INTO usuario (nombre, password, idTipo) VALUES (?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE idUsuario = ?";
    private static final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, password = ?, idTipo =? WHERE idUsuario = ?";
    private static final String SQL_READ = "SELECT * FROM usuario WHERE nombre = ?";
    private static final String SQL_READALL = "SELECT usuario.idUsuario, usuario.nombre, usuario.password, usuario.idTipo, tipo_de_usuario.nombre "
                                            + "FROM usuario INNER JOIN tipo_de_usuario USING(idTipo) ORDER BY usuario.nombre";
    private static final String SQL_READALL_T_USUARIOS = "SELECT idTipo, nombre FROM tipo_de_usuario ORDER BY idTipo";

    private static final Conexion miConexion = Conexion.saberEstado();
    private PreparedStatement pStatement;
    private ResultSet resultados;

    @Override
    public boolean Ingresar(UsuarioDTO datos) {

        try {

            // Los numeros representan mis signos de interrogacion.
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_INSERT);
            pStatement.setString(1, datos.getNombre());
            pStatement.setString(2, datos.getContrasena());
            pStatement.setInt(   3, datos.getIdTipoUsuario());

            // Retornar el valor boolean si esto se ejecuto.
            if (pStatement.executeUpdate() > 0) {

                JOptionPaneMenssage.Message("Usuario registrado exitosamente",
                        "Registro exitoso");

                return true;
            }
            pStatement.close();
        } catch (SQLException e) {
            
            JOptionPaneMenssage.Exception_Message(
                    "Usuario DAO: Ingresar \n" + "Error al registrar un nuevo Usuario. \n",
                    e.getMessage(), "SQLException");
            
        } finally {
            miConexion.Desconectar();
        }
        return false;
    }

    /**
     * Metodo para consultar un usuario segun el parametro que se le indique.
     *
     * @param key - Parametro para usar como condicion en la consulta SQL.
     * @return usuario - Retorna un objeto de tipo UsuarioDTO si encuentra algun
     * resultado. De lo contrario usuario sera null.
     */
    @Override
    public UsuarioDTO Consultar(Object key) {

        UsuarioDTO usuario = null;
        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READ);
            pStatement.setString(1, key.toString());

            resultados = pStatement.executeQuery();

            while (resultados.next()) {
                usuario
                        = new UsuarioDTO(resultados.getInt(1), resultados.getString(2),
                                resultados.getString(3), resultados.getInt(4));
            }
            return usuario;
        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "Usuario DAO: Consultar \n" + "Error al intentar consultar el usuario. \n",
                    e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }

        return usuario;
    }

    @Override
    public boolean Actualizar(UsuarioDTO datos) {

        try {

            // Los numeros representan mis signos de interrogacion.
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_UPDATE);
            pStatement.setString(1, datos.getNombre());
            pStatement.setString(2, datos.getContrasena());
            pStatement.setInt(   3, datos.getIdTipoUsuario());
            pStatement.setInt(   4, datos.getIdUsuario());

            // Retornar el valor boolean si esto se ejecuto.
            if (pStatement.executeUpdate() > 0) {

                JOptionPaneMenssage.Message("El usuario ha sido actualizado exitosamente",
                        "Actualizacion exitosa");
                return true;
            }

        } catch (SQLException e) {
            JOptionPaneMenssage.Exception_Message(
                    "Usuario DAO: Actualizar \n" + "Error al intentar actualizar el usuario. \n",
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

                JOptionPaneMenssage.Message("Usuario eliminado exitosamente",
                        "Borrado exitoso");
                return true;
            }
        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "Usuario DAO: Eliminar \n" + "Error al intentar borrar el usuario. \n",
                    e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }

        return false;
    }

    @Override
    public List<UsuarioDTO> ConsultarTodos() {

        ArrayList<UsuarioDTO> usuarios = new ArrayList<>();

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READALL);

            resultados = pStatement.executeQuery();

            while (resultados.next()) {

                usuarios.add(new UsuarioDTO(resultados.getInt(1), resultados.getString(2),
                        resultados.getString(3), resultados.getInt(4), resultados.getString(5)));
            }

        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "Usuario DAO: ConsultarTodos \n" + "Error al intentar consultar todos los usuarios. \n",
                    e.getMessage(), "SQLException");
        } finally {

            miConexion.Desconectar();
        }

        return usuarios;
    }

    /**
     * Metodo para obtener los tipos de usuarios registrados en la base de
     * datos.
     *
     * @return tipodeUsuarios - Almacenara todos los tipos de usuarios en
     * ArrayList de tipo UsuarioDTO.
     */
    public List<UsuarioDTO> getUserType() {

        ArrayList<UsuarioDTO> tipodeUsuarios = new ArrayList<>();

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READALL_T_USUARIOS);

            resultados = pStatement.executeQuery();

            while (resultados.next()) {

                tipodeUsuarios.add(new UsuarioDTO(resultados.getInt(1), resultados.getString(2)));
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null, "Usuario DAO: getUserType \n" + "Error al intentar consultar todos los tipos de usuarios.",
                    null,
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Error al intentar consultar todos los tipos de usuarios. \n" + e);
        } finally {

            miConexion.Desconectar();
        }

        return tipodeUsuarios;
    }

}
