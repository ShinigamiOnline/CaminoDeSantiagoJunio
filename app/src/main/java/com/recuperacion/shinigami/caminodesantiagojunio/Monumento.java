package com.recuperacion.shinigami.caminodesantiagojunio;

/**
 * Created by Shinigami on 01/04/2018.
 */

public class Monumento {
    private int id;
    private String nombre;
    private String descripcion;
    private String horario;
    private  double  precioEntrada;
    private int  id_Municipio;

    public Monumento(int id, String nombre, String descripcion, String horario, double precioEntrada, int id_Municipio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horario = horario;
        this.precioEntrada = precioEntrada;
        this.id_Municipio = id_Municipio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public int getId_Municipio() {
        return id_Municipio;
    }

    public void setId_Municipio(int id_Municipio) {
        this.id_Municipio = id_Municipio;
    }
}
