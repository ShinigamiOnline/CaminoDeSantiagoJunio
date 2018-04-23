package com.recuperacion.shinigami.caminodesantiagojunio;

import java.util.ArrayList;

/**
 * Created by Shinigami on 01/04/2018.
 */

public interface Almacen {

    void aniadirMunicipio(Municipio municipio);
    void aniadirAlbergue(Albergue albergue);
    void aniadirMonumento(Monumento monumento);

    void modificarMunicipio(Municipio municipio);
    void modificarAlbergue(Albergue albergue);
    void modificarMonumento(Monumento monumento);

    void eliminarMunicipio(Municipio municipio);
    void eliminarAlbergue(Albergue albergue);
    void eliminarMonumento(Monumento monumento);

    ArrayList<Municipio> cargarMunicipios();
    ArrayList<Municipio> cargarMunicipios(int numHabitantes);
    ArrayList<Municipio> cargarMunicipios(int numHabitantes, String descripcion);
    ArrayList<Municipio> cargarMunicipios(int numHabitantes, String descripcion,boolean tieneAlbergues);


    ArrayList<Albergue> cargarAlbergues(Municipio municipio);

    ArrayList<Monumento> cargarMonumentos(Municipio municipio);

    void guardarValoracion(Albergue albergue,float valoracion);

}
