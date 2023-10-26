package com.example.yournight10;

public class locales {
    public int id ;
    public int imagen;
    public String nombreL;
    public String descripcion;
    public int valoracion;

    public locales(int id, int imagen, String nombreL, String descripcion, int valoracion) {
        this.id = id;
        this.imagen = imagen;
        this.nombreL = nombreL;
        this.descripcion = descripcion;
        this.valoracion = valoracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombreL() {
        return nombreL;
    }

    public void setNombreL(String nombreL) {
        this.nombreL = nombreL;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
}
