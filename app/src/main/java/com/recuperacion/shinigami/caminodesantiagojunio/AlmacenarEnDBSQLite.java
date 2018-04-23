package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Shinigami on 01/04/2018.
 */

public class AlmacenarEnDBSQLite extends SQLiteOpenHelper implements Almacen {


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

        sqLiteDatabase.execSQL("INSERT INTO Municipio values(" + idMunicipio + ",'" + nombreMunicipio + "'," + numHabitantes + ",'" + descripcion + "')");

        Toast.makeText(null, "Municipio añadido correctamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void aniadirAlbergue(Albergue albergue) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        int idAlbergue = albergue.getId();
        String descripcion = albergue.getDescripcion();
        String nombreAlbergue = albergue.getNombre();
        int valoracionSum = albergue.getValoracionSum();
        int votos = albergue.getVotos();
        double precio = albergue.getPrecio();

        int idMunicipioDelAlbergue = albergue.getId_Municipio();

        sqLiteDatabase.execSQL("INSERT INTO Albergue values(" + idAlbergue + ",'" + nombreAlbergue + "','" + descripcion + "'," + valoracionSum + "," + votos + "," + precio + "," + idMunicipioDelAlbergue + ")");
        Toast.makeText(null, "Municipio añadido correctamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void aniadirMonumento(Monumento monumento) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        int idMonumento = monumento.getId();
        String nombre = monumento.getNombre();
        String descripcion = monumento.getDescripcion();
        String horario = monumento.getHorario();
        double precioEntrada = monumento.getPrecioEntrada();

        int idMunicipioDelMonumento = monumento.getId_Municipio();

        sqLiteDatabase.execSQL("INSERT INTO Monumento values(" + idMonumento + ",'" + nombre + "','" + descripcion + "','" + horario + "'," + precioEntrada + "," + idMunicipioDelMonumento + ")");
        Toast.makeText(null, "Municipio añadido correctamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void modificarMunicipio(Municipio municipio) {
        Municipio municipioAModificar = municipio;
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues nuevosValores = new ContentValues();

        int idMunicipio = municipio.getId();
        // nuevosValores.put("_id",municipioAModificar.getId());

        nuevosValores.put("nombre", municipioAModificar.getNombre());
        nuevosValores.put("habitantes", municipioAModificar.getHabitantes());
        nuevosValores.put("descripcionMunicipio", municipioAModificar.getDescripcion());

        int numModificados = 0;
        numModificados = sqLiteDatabase.update("Municipio", nuevosValores, "_id = " + idMunicipio, null);
        if (numModificados > 0) {
            Toast.makeText(null, "Municipio Modificado correctamente", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void modificarAlbergue(Albergue albergue) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues nuevosValores = new ContentValues();
        int idAlbergue = albergue.getId();

        //nuevosValores.put("_id",albergueAModificar.getNombre());

        nuevosValores.put("nombre", albergue.getNombre());
        nuevosValores.put("descripcion", albergue.getDescripcion());
        nuevosValores.put("valoracionSum", albergue.getValoracionSum());
        nuevosValores.put("votos", albergue.getVotos());
        nuevosValores.put("precio", albergue.getPrecio());
        nuevosValores.put("id_Municipio", albergue.getId_Municipio());

        int numModificados = 0;
        numModificados = sqLiteDatabase.update("Albergue", nuevosValores, "_id = " + idAlbergue, null);
        if (numModificados > 0) {
            Toast.makeText(null, "Albergue Modificado correctamente", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void modificarMonumento(Monumento monumento) {


        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues nuevosValores = new ContentValues();
        int idMonumento = monumento.getId();

        //nuevosValores.put("_id",MonumentoAModificar.getNombre());

        nuevosValores.put("nombre", monumento.getNombre());
        nuevosValores.put("descripcion", monumento.getDescripcion());
        nuevosValores.put("horario", monumento.getHorario());
        nuevosValores.put("precio_Entrada", monumento.getPrecioEntrada());
        nuevosValores.put("id_Municipio", monumento.getId_Municipio());

        int numModificados = 0;
        numModificados = sqLiteDatabase.update("Monumento", nuevosValores, "_id = " + idMonumento, null);
        if (numModificados > 0) {
            Toast.makeText(null, "Monumento Modificado correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(null, "Monumento NO Modificado.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void eliminarMunicipio(Municipio municipio) {

        int idMunicipio = municipio.getId();

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        int eliminados = sqLiteDatabase.delete("Municipio", "_id = " + idMunicipio, null);
        if (eliminados > 0) {
            Toast.makeText(null, "Municipio eliminado correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(null, "No se ha eliminado ningún Municipio.", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void eliminarAlbergue(Albergue albergue) {
        int idAlbergue = albergue.getId();

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        int eliminados = sqLiteDatabase.delete("Albergue", "_id = " + idAlbergue, null);
        if (eliminados > 0) {
            Toast.makeText(null, "Albergue eliminado correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(null, "No se ha eliminado ningún Albergue.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void eliminarMonumento(Monumento monumento) {

        int idMonumento = monumento.getId();

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        int eliminados = sqLiteDatabase.delete("Monumento", "_id = " + idMonumento, null);
        if (eliminados > 0) {
            Toast.makeText(null, "Monumento eliminado correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(null, "No se ha eliminado ningún Monumento.", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public ArrayList<Municipio> cargarMunicipios() {

        ArrayList<Municipio> listaMunicipios = new ArrayList<Municipio>();

        Municipio municipio;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Munipio", null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String nombre = cursor.getString(1);
            int numHabitantes = cursor.getInt(2);
            String descripcion = cursor.getString(3);
            municipio = new Municipio(id, nombre, numHabitantes, descripcion);
            listaMunicipios.add(municipio);
        }
        cursor.close();
        sqLiteDatabase.close();
        Toast.makeText(null, "Municipios cargados Correctamente", Toast.LENGTH_SHORT).show();
        return listaMunicipios;

    }

    @Override
    public ArrayList<Municipio> cargarMunicipios(int numHabitantes) {

        ArrayList<Municipio> listaMunicipios = new ArrayList<Municipio>();

        Municipio municipio;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Munipio", null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String nombre = cursor.getString(1);
            int numeroHabitantes = cursor.getInt(2);
            String descripcion = cursor.getString(3);
            municipio = new Municipio(id, nombre, numeroHabitantes, descripcion);

            if (municipio.getHabitantes() > numHabitantes) {
                listaMunicipios.add(municipio);
            } else {

            }
        }
        cursor.close();
        sqLiteDatabase.close();
        Toast.makeText(null, "Municipios cargados Correctamente", Toast.LENGTH_SHORT).show();
        return listaMunicipios;

    }

    @Override
    public ArrayList<Municipio> cargarMunicipios(int numHabitantes, String descripcionABuscar) {

        ArrayList<Municipio> listaMunicipios = new ArrayList<Municipio>();

        Municipio municipio;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Munipio", null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String nombre = cursor.getString(1);
            int numeroHabitantes = cursor.getInt(2);
            String descripcionMunicipio = cursor.getString(3);
            municipio = new Municipio(id, nombre, numeroHabitantes, descripcionMunicipio);

            if (municipio.getHabitantes() > numHabitantes && descripcionMunicipio.startsWith(descripcionABuscar)) {
                listaMunicipios.add(municipio);
            } else {

            }
        }
        cursor.close();
        sqLiteDatabase.close();
        Toast.makeText(null, "Municipios cargados Correctamente", Toast.LENGTH_SHORT).show();
        return listaMunicipios;

    }

    @Override
    public ArrayList<Municipio> cargarMunicipios(int numHabitantes, String descripcionABuscar, boolean tieneAlbergues) {

        ArrayList<Municipio> listaMunicipios = new ArrayList<Municipio>();

        Municipio municipio;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Munipio", null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String nombre = cursor.getString(1);
            int numeroHabitantes = cursor.getInt(2);
            String descripcionMunicipio = cursor.getString(3);
            municipio = new Municipio(id, nombre, numeroHabitantes, descripcionMunicipio);

            if (municipio.getHabitantes() > numHabitantes && descripcionMunicipio.startsWith(descripcionABuscar) && tieneAlbergues == true) {
                listaMunicipios.add(municipio);
            } else {

            }
        }
        cursor.close();
        sqLiteDatabase.close();
        Toast.makeText(null, "Municipios cargados Correctamente", Toast.LENGTH_SHORT).show();
        return listaMunicipios;

    }

    @Override
    public ArrayList<Albergue> cargarAlbergues(Municipio municipio) {

        ArrayList<Albergue> listaAlbergues = new ArrayList<Albergue>();
        int idMunicipio = municipio.getId();
        Albergue albergue;

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Albergue WHERE id_Municipio =" + idMunicipio, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String nombre = cursor.getString(1);
            String descripcion = cursor.getString(2);
            int valoracionSum = cursor.getInt(3);
            int votos = cursor.getInt(4);
            double precio = cursor.getDouble(5);
            int id_municipio = cursor.getInt(6);
            albergue = new Albergue(id, descripcion, nombre, valoracionSum, votos, precio, id_municipio);

            listaAlbergues.add(albergue);

        }

        return listaAlbergues;
    }

    @Override
    public ArrayList<Monumento> cargarMonumentos(Municipio municipio) {
        ArrayList<Monumento> listaMonumentos = new ArrayList<Monumento>();
        int idMunicipio = municipio.getId();
        Monumento monumento;

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Monumento WHERE id_Municipio =" + idMunicipio, null);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String nombre = cursor.getString(1);
            String descripcion = cursor.getString(2);
            String horario = cursor.getString(3);
            double precioEntrada = cursor.getDouble(4);
            int id_municipio = cursor.getInt(5);

            monumento = new Monumento(id, descripcion, nombre, horario, precioEntrada, id_municipio);

            listaMonumentos.add(monumento);

        }

        return listaMonumentos;


    }

    @Override
    public void guardarValoracion(Albergue albergue, float valoracion) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues nuevosValores = new ContentValues();

        int idAlbergue = albergue.getId();
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
