package com.obyhat.controlador;
 
import com.obyhat.modelo.dao.ProveedorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.obyhat.modelo.dto.ProveedorDTO;
import com.obyhat.vista.paneles.PanelProveedores;
import java.util.List;
 
public class BotonesProveedor implements ActionListener {
   
    private PanelProveedores PP;
    private ProveedorDAO proveedorDAO;
    private String nombreProveedor;
    
   
    public BotonesProveedor(PanelProveedores PP) {
       
        this.PP = PP;
        this.proveedorDAO = new ProveedorDAO();
        
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == PP.getBtnAgregar()) {
           
            System.out.println("Boton Guardar escuchando a Skrillex");
           
          try {		
		if(ValidarDatos().equals("")){                                          
			try {		
			      this.proveedorDAO.Ingresar(this.PP.ObtenerDatos());
			      this.PP.LimpiarCampos();
					} catch (Exception e2) {		
					  System.out.println("Error al insertar "+e2);
					}
				}				
				else{
					
	                    JOptionPane.showMessageDialog(null, "ERROR!! \n" + ValidarDatos(), "Validando Datos",JOptionPane.ERROR_MESSAGE);
	            }		
		} catch(Exception e1){
	           
	            JOptionPane.showMessageDialog(null, "Error en Eventos del Boton Agregar. \n" + e1, "Error",JOptionPane.ERROR_MESSAGE);
	      }
         
         this.ObtenerProveedor();
        }  
        
      if (e.getSource() == PP.getBtnActualizar()) {
                
        	System.out.println("Boton Actualizar Escuchando");
        	 this.actualizarUsuario();
        	 this.PP.getBtnAgregar().setEnabled(true);
       	  	 this.PP.getBtnActualizar().setEnabled(false);
        }
        
        if (e.getSource()==PP.getBtnBuscarMat()) {
            System.out.println("Escuchando boton actualizar");
            ObtenerProveedor();
        }
        
        if (e.getSource() == PP.getBtnModificar()) {
			
			System.out.println("Boton 'Modificar' escuchando Rock!");
			
			//Obtenet la Fila seleccionada.
            int filaSeleccionada = PP.getTablaProvedorReg().getSelectedRow();
            
                if (filaSeleccionada >= 0) {

                        this.nombreProveedor = PP.getTablaProvedorReg().getValueAt(filaSeleccionada, 0).toString();
                        System.err.println(nombreProveedor);
                          
                	int opc = JOptionPane.showConfirmDialog(null, " Desea modificar el material: "+nombreProveedor+"? ", "Confirmar modificacion ",
                	        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    /*
                	 * Le preguntare al usuario si en realidad desea modificar la categoria.
                	 */

                    if (opc == 0) {
                    
	                    try {
	    					
	                    	PP.getModeloTabla().removeRow(filaSeleccionada);
	                    	ProveedorDTO consultarMaterial = proveedorDAO.Consultar(nombreProveedor);
	                    	PP.llenarFormulario(consultarMaterial);
                                //JOptionPane.showConfirmDialog(null,consultarMaterial.getNombreMaterial()+"\n"+consultarMaterial.getCantidadMaterial()+"\n"+consultarMaterial.getFechaRegistro());
	                    	
	                    	PP.getBtnAgregar().setEnabled(true);
	                    	PP.getBtnActualizar().setEnabled(true);
	                    	
	                    	//nombre = consultarMaterial.getNombreMaterial();
	                    	
	                    	this.getNombre(nombreProveedor);
	                    	
	                    	
	    				} catch (Exception e2) {
	    					
	    					JOptionPane.showMessageDialog(null, "La cedula no existe", "Informacion", JOptionPane.INFORMATION_MESSAGE);
	    				}
                }
                }
                else{
                
                    JOptionPane.showMessageDialog(null, "Seleccione la fila a eliminar");
                }
		}
        
        if (e.getSource() == PP.getBtnEliminar()) {
	
			System.out.println("Boton 'Eliminar' escuchando Rock!");
			
			int filaSelecionada = PP.getTablaProvedorReg().getSelectedRow();
			
			if(filaSelecionada != -1){

                String nombreProveedor = PP.getTablaProvedorReg().getValueAt(filaSelecionada, 1).toString();
                

            	int opc = JOptionPane.showConfirmDialog(null, " Desea eliminar permanentemente el proveedor: "+nombreProveedor+"? ", "Confirmar eliminacion ",
            	        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                /*
            	 * Le preguntare al usuario si en realidad desea modificar la categoria.
            	 */

                if (opc == 0) {
                
	                try {
						
	                	PP.getModeloTabla().removeRow(filaSelecionada);
	                	this.proveedorDAO.Eliminar(nombreProveedor);
					} catch (Exception e2) {
						
						JOptionPane.showMessageDialog(null, "La cedula no existe", "Informacion", JOptionPane.INFORMATION_MESSAGE);
					}
                }    
			}
			else{
				
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            }
		}
        
    }
    
    
    public String ValidarDatos() {//Metodo para comprobar que los datos esten completos.
        
         String msj = "";
		
        if (this.PP.getTxtRif().getText().equals("")) {
            msj += "Por favor escriba un nombre. \n";
        }
        if(this.PP.getTxtNombreRazon().getText().equals("")){
         msj += "Por favor escriba una cantidad. \n";
        }
        if(this.PP.getTxtTelefono().getText().equals("")){
         msj += "Por favor escriba una cantidad. \n";
        }
        if(this.PP.getTxtDireccion().getText().equals("")){
         msj += "Por favor escriba una cantidad. \n";
        }
        if(this.PP.getTxtEmail().getText().equals("")){
         msj += "Por favor escriba una cantidad. \n";
        }
        
           
        return msj;//devuelve msj.
    }
    
    //logica con el llenado de la tabla
    public void ObtenerProveedor() {
        List<ProveedorDTO> proveedor = this.proveedorDAO.ConsultarTodos();
    	
    	PP.limpiarTabla();
        
        for (int i = 0; i < proveedor.size(); i++) {
            System.out.println(proveedor.get(i).getRif()+""+proveedor.get(i).getRazonSocial()+""+proveedor.get(i).getTelefono()+""+proveedor.get(i).getDireccion()+""+proveedor.get(i).getEmail()+""+proveedor.get(i).getMaterialProvee());
           // PP.llenarTabla(proveedor.get(i).toArray());
            this.PP.insertarTabla(proveedor.get(i).toArray());
        
        
    }
  }
    
     
    
    
    public void actualizarUsuario() {
		
		try {
			
			if (ValidarDatos().equals("")) {
				/*
				 *  Si el medoto ValidarDatos devuelve "", es decir, 
				 *  nada es porque los dos campos estan llenos. 
				 *  
				 */
				
				try {
					
					proveedorDAO.Actualizar(this.PP.ObtenerDatos(),this.nombreProveedor);
					PP.LimpiarCampos();
					
					this.ObtenerProveedor();
				
				} catch (Exception e2) {
					
					System.out.println("Error al insertar "+e2);
				}
			}
				
			else{
				/*
				 * de lo contrario emite el mensaje
				 */
	            
                JOptionPane.showMessageDialog(null, "ERROR!! \n" + ValidarDatos(), "Validando Datos",
                    JOptionPane.ERROR_MESSAGE);
            }
			
		} catch(Exception e1){
           
            JOptionPane.showMessageDialog(null, "Error en Eventos del Boton Agregar. \n" + e1, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
	}
    
    private String getNombre(String nombre) {
	
		return nombre; 	
	}
       
}