package com.recuperacion.shinigami.caminodesantiagojunio;

import java.io.Serializable;

/**
 * Created by Shinigami on 01/04/2018.
 */

public class Albergue implements Serializable {
    private int id;
    private String descripcion;
    private String nombre;
    private int valoracionSum;
    private int votos;
    private double precio;
    private int id_Municipio;

    public Albergue(int id, String descripcion, String nombre, int valoracionSum, int votos, double precio, int id_Municipio) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.valoracionSum = valoracionSum;
        this.votos = votos;
        this.precio = precio;
        this.id_Municipio = id_Municipio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValoracionSum() {
        return valoracionSum;
    }

    public void setValoracionSum(int valoracionSum) {
        this.valoracionSum = valoracionSum;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_Municipio() {
        return id_Municipio;
    }

    public void setId_Municipio(int id_Municipio) {
        this.id_Municipio = id_Municipio;
    }

    @Override
    public String toString() {
        return getId() + " - " + getNombre();
    }
}