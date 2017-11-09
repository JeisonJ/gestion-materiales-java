package com.obyhat.modelo.dto;

public class CategoriaDTO {

    private int idCategoria;
    private String nombreCategoria;
    private String desCategoria;

    public CategoriaDTO() {

    }

    public CategoriaDTO(int idCategoria) {

        this.idCategoria = idCategoria;
    }

    public CategoriaDTO(int idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public CategoriaDTO(String nombreCategoria) {

        this.nombreCategoria = nombreCategoria;
    }

    public CategoriaDTO(String nombreCategoria, String desCategoria) {
        super();
        this.nombreCategoria = nombreCategoria;
        this.desCategoria = desCategoria;
    }

    public CategoriaDTO(int idCategoria, String nombreCategoria, String desCategoria) {

        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.desCategoria = desCategoria;
    }

    public final Object[] toArray() {

        Object[] datos = new Object[3];

        //datos[0] = this.idCategoria;
        datos[0] = this.nombreCategoria;
        datos[1] = this.desCategoria;

        return datos;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDesCategoria() {
        return desCategoria;
    }

    public void setDesCategoria(String desCategoria) {
        this.desCategoria = desCategoria;
    }

    @Override
    public String toString() {
        return this.nombreCategoria;
    }
    
}
