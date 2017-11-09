
package com.obyhat.modelo.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.obyhat.interfaces.CRUD;
import com.obyhat.modelo.dto.MaterialesDTO;
import com.obyhat.modelo.conexion.Conexion;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jafeht
 */
public class MaterialesDAO implements CRUD<MaterialesDTO>{
    
   
    
    private static final String SQL_INSERT = "INSERT INTO `material`(`nombreMaterial`, `cantidadMaterial`, `fechaRegistro`) VALUES (?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM material WHERE nombreMaterial = ?";
    private static final String SQL_UPDATE = "UPDATE `material` SET `nombreMaterial`=?,`cantidadMaterial`=?,`fechaRegistro`=? WHERE nombreMaterial = ?";
    private static final String SQL_UPDATE_DOS = "UPDATE `material` SET `cantidadMaterial`=(cantidadMaterial - ?) WHERE idMaterial = ?";
    private static final String SQL_READ = "SELECT * FROM `material` WHERE nombreMaterial = ?";
    private static final String SQL_READALL = "SELECT `nombreMaterial`, `cantidadMaterial`, `fechaRegistro` FROM `material`";
    
    
    // Corrigiendo fallos Panel Asignar.
    private static final String SQL_GETALL = "SELECT * FROM `material`";
    
    
    private static final Conexion miConexion = Conexion.saberEstado();
	
	private PreparedStatement pStatement = null;
	private ResultSet res = null;
    

    @Override
    public boolean Ingresar(MaterialesDTO datos) {
        try {
           
            // Los numeros representan mis signos de interrogacion.
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_INSERT);
            pStatement.setString(1, datos.getNombreMaterial());       
            pStatement.setInt(2, datos.getCantidadMaterial());
            pStatement.setString(3, datos.getFechaRegistro());
            
           
            // Retornar el valor boolean si esto se ejecuto.
            if (pStatement.executeUpdate() > 0) {
               
                JOptionPane.showMessageDialog(null, "Material registrado exitosamente", null, JOptionPane.INFORMATION_MESSAGE);
               
                return true;
            }
           
            pStatement.close();
           
        } catch (SQLException e) {
           
            JOptionPane.showMessageDialog(null, "Error al registrar un nuevo material. \n"+e, null, JOptionPane.INFORMATION_MESSAGE);
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

                JOptionPane.showMessageDialog(null, "Material eliminado exitosamente.", null, JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Material eliminado exitosamente.");
                return true;
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al intentar borrar el material.", null, JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Error al intentar borrar el material. \n" + e);
        } finally {
            miConexion.Desconectar();
        }

        return false;
    }

    @Override
    public MaterialesDTO Consultar(Object key) {
        MaterialesDTO OB = null;

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READ);
            pStatement.setString(1, key.toString());

            res = pStatement.executeQuery();

            while (res.next()) {
                OB = new MaterialesDTO(res.getString(2), res.getInt(3), res.getString(6));

            }
            return OB;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al intentar consultar la obra.", null, JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Error al intentar consultar la obra. \n" + e);
        } finally {
            miConexion.Desconectar();
        }

        return OB;
    }

    
    @Override
    public List<MaterialesDTO> ConsultarTodos() {
        ArrayList<MaterialesDTO> materiales = new ArrayList<>();
		
		try {
			
			pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READALL);
			
			res = pStatement.executeQuery();
			
			while (res.next()) {
				
				materiales.add(new MaterialesDTO(res.getString(1),res.getInt(2),res.getString(3)));
			}
                        
                        
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Error al intentar consultar todos los materiales. \n"+e, null, JOptionPane.INFORMATION_MESSAGE);
		} finally {
			
			miConexion.Desconectar();
		}
		
		return materiales;
    }
    
    
    // Corrigiendo fallos Panel Asignar.
    // Consulta para llenar el panel Material
    // @Author: Jeison 10/05/2017
    
    public List<MaterialesDTO> ConsultarTodosAsig() {
        
    	ArrayList<MaterialesDTO> materiales = new ArrayList<>();
		
			try {
				
				pStatement = miConexion.obtenerConexion().prepareStatement(SQL_GETALL);
				res = pStatement.executeQuery();
				
				while (res.next()) {
					
					materiales.add(new MaterialesDTO(res.getInt(1),res.getString(2),res.getInt(3)));
				}
	                        
	                        
			} catch (Exception e) {
				
				JOptionPane.showMessageDialog(null, "Error al intentar consultar todos los materiales. \n"+e, null, JOptionPane.INFORMATION_MESSAGE);
			} finally {
			
				miConexion.Desconectar();
			}
		
		return materiales;
    }

    public boolean Actualizar(MaterialesDTO datos, String nombreMaterial) {
        try {

            // Los numeros representan mis signos de interrogacion.
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_UPDATE);
            pStatement.setString(1, datos.getNombreMaterial());
            pStatement.setInt(2, datos.getCantidadMaterial());
            pStatement.setString(3, datos.getFechaRegistro());
            pStatement.setString(4, nombreMaterial);

            // Retornar el valor boolean si esto se ejecuto.
            if (pStatement.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Obra actualizada exitosamente", null, JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Obra actualizada exitosamente.");
                return true;
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al actualizar la obra.", null, JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Error al actualizar la obra. \n" + e);
        } finally {

            miConexion.Desconectar();
        }

        return false;
    }

    @Override
    public boolean Actualizar(MaterialesDTO datos) {
        try {

            // Los numeros representan mis signos de interrogacion.
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_UPDATE_DOS);
            pStatement.setInt(1, datos.getCantidadMaterial());
            pStatement.setInt(2, datos.getIdMaterial());

            // Retornar el valor boolean si esto se ejecuto.
            if (pStatement.executeUpdate() > 0) {

                //JOptionPane.showMessageDialog(null, "material actualizada exitosamente", null, JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Material actualizado exitosamente.");
                return true;
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al actualizar el material.", null, JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Error al actualizar el material. \n" + e);
        } finally {

            miConexion.Desconectar();
        }

        return false;
    }

}
