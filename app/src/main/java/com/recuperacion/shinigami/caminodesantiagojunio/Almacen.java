package com.recuperacion.shinigami.caminodesantiagojunio;

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

    void cargarMunicipios(Municipio municipio);
    void cargarMunicipios(Municipio municipio, int numHabitantes);
    void cargarMunicipios(Municipio municipio,int numHabitatnes, String descripcion);

    void cargarAlbergues(Municipio municipio);

    void cargarMonumentos(Municipio municipio);

    void guardarValoracion(Albergue albergue,float valoracion);

}
