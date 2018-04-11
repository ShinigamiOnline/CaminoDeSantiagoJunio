package com.recuperacion.shinigami.caminodesantiagojunio;

/**
 * Created by Shinigami on 01/04/2018.
 */

public class Albergue {
    private int id;
    private String descripcion;
    private String nombre;
    private int valoracionSum;
    private int votos;
    private double precio;
    private Municipio municipio;

    public Albergue(int id, String descripcion, String nombre, int valoracionSum, int votos, double precio, Municipio municipio) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.valoracionSum = valoracionSum;
        this.votos = votos;
        this.precio = precio;
        this.municipio = municipio;
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

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}