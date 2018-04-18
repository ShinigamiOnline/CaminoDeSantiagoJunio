package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Shinigami on 01/04/2018.
 */

public class AlmacenarEnDBSQLite extends SQLiteOpenHelper implements Almacen{


    public AlmacenarEnDBSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Municipios", null, 1);
    }

    @Override
    public void aniadirMunicipio(Municipio municipio) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Municipio municipioNuevo = municipio;
        int idMunicipio = municipioNuevo.getId();
        String nombreMunicipio = municipioNuevo.getNombre();
        int numHabitantes = municipioNuevo.getHabitantes();
        String descripcion = municipioNuevo.getDescripcion();
        
        sqLiteDatabase.execSQL("INSERT INTO Municipio values("+idMunicipio+",'"+nombreMunicipio+"',"+numHabitantes+",'"+descripcion+"')");

        Toast.makeText(null, "Municipio añadido correctamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void aniadirAlbergue(Albergue albergue) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Albergue albergueNuevo = albergue;

        int idAlbergue = albergueNuevo.getId();
        String descripcion = albergueNuevo.getDescripcion();
        String nombreAlbergue = albergueNuevo.getNombre();
        int valoracionSum = albergueNuevo.getValoracionSum();
        int votos = albergueNuevo.getVotos();
        double precio = albergueNuevo.getPrecio();

        Municipio municipioDelAlbergue = albergueNuevo.getMunicipio();
        int idMunicipioDelAlbergue = municipioDelAlbergue.getId();

        sqLiteDatabase.execSQL("INSERT INTO Albergue values("+idAlbergue+",'"+nombreAlbergue+"','"+descripcion+"',"+valoracionSum+","+votos+","+precio+","+idMunicipioDelAlbergue+")");
        Toast.makeText(null, "Municipio añadido correctamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void aniadirMonumento(Monumento monumento) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Monumento monumentoNuevo = monumento;

        int idMonumento = monumentoNuevo.getId();
        String nombre = monumentoNuevo.getNombre();
        String descripcion = monumentoNuevo.getDescripcion();
        String horario = monumentoNuevo.getHorario();
        double precioEntrada = monumentoNuevo.getPrecioEntrada();

        Municipio municipioDelMonumento = monumentoNuevo.getMunicipio();
        int idMunicipioDelMonumento = municipioDelMonumento.getId();

        sqLiteDatabase.execSQL("INSERT INTO Monumento values("+idMonumento+",'"+nombre+"','"+descripcion+"','"+horario+"',"+precioEntrada+","+idMunicipioDelMonumento+")");
        Toast.makeText(null, "Municipio añadido correctamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void modificarMunicipio(Municipio municipio) {
        Municipio municipioAModificar = municipio;
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues nuevosValores = new ContentValues();

        int idMunicipio = municipio.getId();
       // nuevosValores.put("_id",municipioAModificar.getId());

        nuevosValores.put("nombre",municipioAModificar.getNombre());
        nuevosValores.put("habitantes",municipioAModificar.getHabitantes());
        nuevosValores.put("descripcionMunicipio",municipioAModificar.getDescripcion());

        int numModificados = 0;
        numModificados = sqLiteDatabase.update("Municipio",nuevosValores,"_id = " + idMunicipio,null);
        if (numModificados > 0 ) {
            Toast.makeText(null, "Municipio Modificado correctamente", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void modificarAlbergue(Albergue albergue) {

        Albergue albergueAModificar = albergue;
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues nuevosValores = new ContentValues();
        Municipio municipioDelAlbergue = albergueAModificar.getMunicipio();
        int idAlbergue = albergueAModificar.getId();
        int idMunicipio = municipioDelAlbergue.getId();

        //nuevosValores.put("_id",albergueAModificar.getNombre());

        nuevosValores.put("nombre", albergueAModificar.getNombre());
        nuevosValores.put("descripcion", albergueAModificar.getDescripcion());
        nuevosValores.put("valoracionSum", albergueAModificar.getValoracionSum());
        nuevosValores.put("votos", albergueAModificar.getVotos());
        nuevosValores.put("precio", albergueAModificar.getPrecio());
        nuevosValores.put("id_Municipio", idMunicipio);

        int numModificados = 0;
        numModificados = sqLiteDatabase.update("Albergue", nuevosValores, "_id = " + idAlbergue, null);
        if (numModificados > 0) {
            Toast.makeText(null, "Albergue Modificado correctamente", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void modificarMonumento(Monumento monumento) {


        Monumento monumentoAModificar = monumento;
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues nuevosValores = new ContentValues();
        Municipio municipioDelMonumento = monumentoAModificar.getMunicipio();
        int idMunicipio = municipioDelMonumento.getId();
        int idMonumento = monumentoAModificar.getId();

        //nuevosValores.put("_id",MonumentoAModificar.getNombre());

        nuevosValores.put("nombre", monumentoAModificar.getNombre());
        nuevosValores.put("descripcion", monumentoAModificar.getDescripcion());
        nuevosValores.put("horario", monumentoAModificar.getHorario());
        nuevosValores.put("precio_Entrada", monumentoAModificar.getPrecioEntrada());
        nuevosValores.put("id_Municipio", idMunicipio);

        int numModificados = 0;
        numModificados = sqLiteDatabase.update("Monumento", nuevosValores, "_id = " + idMonumento, null);
        if (numModificados > 0) {
            Toast.makeText(null, "Monumento Modificado correctamente", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void eliminarMunicipio(Municipio municipio) {

        int idMunicipio = municipio.getId();

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        int eliminados = sqLiteDatabase.delete("Municipio","_id = "+idMunicipio,null);
        if (eliminados > 0 ){
            Toast.makeText(null, "Municipio eliminado correctamente", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void eliminarAlbergue(Albergue albergue) {
        int idAlbergue = albergue.getId();

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        int eliminados = sqLiteDatabase.delete("Albergue","_id = "+idAlbergue,null);
        if (eliminados > 0 ){
            Toast.makeText(null, "Albergue eliminado correctamente", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void eliminarMonumento(Monumento monumento) {

        int idMonumento = monumento.getId();

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        int eliminados = sqLiteDatabase.delete("Monumento","_id = "+idMonumento,null);
        if (eliminados > 0 ){
            Toast.makeText(null, "Monumento eliminado correctamente", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void cargarMunicipios(Municipio municipio) {


    }

    @Override
    public void cargarMunicipios(Municipio municipio, int numHabitantes) {

    }

    @Override
    public void cargarMunicipios(Municipio municipio, int numHabitatnes, String descripcion) {

    }

    @Override
    public void cargarAlbergues(Municipio municipio) {

    }

    @Override
    public void cargarMonumentos(Municipio municipio) {

    }

    @Override
    public void guardarValoracion(Albergue albergue, float valoracion) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues nuevosValores = new ContentValues();

        Municipio municipioDelAlbergue = albergue.getMunicipio();
        int idAlbergue = albergue.getId();
        int idMunicipio = municipioDelAlbergue.getId();

        nuevosValores.put("valoracionSum", albergue.getValoracionSum());

        int numModificados = 0;
        numModificados = sqLiteDatabase.update("Albergue", nuevosValores, "_id = " + idAlbergue, null);

        if (numModificados > 0) {
            Toast.makeText(null, "Valoracion modificado correctamente", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE Municipio (_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT,habitantes INTEGER, descripcionMunicipio TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE Albergue (_id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT, descripcion TEXT,valoracionSum INTEGER,votos INTEGER, precio REAL, id_Municipio INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE Monumento (_id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT, descripcion TEXT,horario TEXT,precio_Entrada REAL, id_Municipio INTEGER)");


        sqLiteDatabase.execSQL("INSERT INTO Municipio values(null,'Najera',3000,'Antigua capital del Reino de Nájera')");
        sqLiteDatabase.execSQL("INSERT INTO Albergue values(null,'Hostal pepito','Albergue juvenil o albergue de juventud es un cuerno de establecimiento hostelero, orientado a los jóvenes, con precios económicos y el objetivo de promocinar o alentar actividades de intercambio cultural entre promociones de distintos países. En la mayoría de las ciudades del mundo, principalmente las capitales',10,3,23.3,0)");
        sqLiteDatabase.execSQL("INSERT INTO Albergue values(null,'Hostal pepito 2','Albergue juvenil o albergue de juvenomocinar o alentar actividades de inter',13,3,13.3,0)");
        sqLiteDatabase.execSQL("INSERT INTO Albergue values(null,'Hostal pepito 3','Albergue juvenil o albergue de juvenomocinar o alentar actividades de inter',3,3,3.3,0)");
        sqLiteDatabase.execSQL("INSERT INTO Municipio values(null,'Logroño',120000,'Capital de la Rioja')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
