package com.recuperacion.shinigami.caminodesantiagojunio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Shinigami on 01/04/2018.
 */

public class Municipio implements Serializable{
    private int id;
    private String nombre;
    private int habitantes;
    private String descripcion;
    private ArrayList<Albergue> listaAlbergues = new ArrayList<Albergue>();
    private ArrayList<Monumento> listaMonumentos = new ArrayList<Monumento>();

    public Municipio(int id, String nombre, int habitantes, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.habitantes = habitantes;
        this.descripcion = descripcion;
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

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Albergue> getListaAlbergues() {
        return listaAlbergues;
    }

    public void setListaAlbergues(ArrayList<Albergue> listaAlbergues) {
        this.listaAlbergues = listaAlbergues;
    }

    public ArrayList<Monumento> getListaMonumentos() {
        return listaMonumentos;
    }

    public void setListaMonumentos(ArrayList<Monumento> listaMonumentos) {
        this.listaMonumentos = listaMonumentos;
    }

    @Override
    public String toString() {
        return getId() +" - " + getNombre();
    }
}
