package co.edu.unimagdalena.apmoviles.universidad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class EstudianteController {
    private BaseDatos bd;
    private Context c;
    public EstudianteController( Context c) {
        this.bd = new BaseDatos(c,1);
        this.c = c;
    }
    public void agregarEstudiante(Estudiante e){
        try {
            SQLiteDatabase sql = bd.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(DefBD.col_codigo, e.getCodigo());
            valores.put(DefBD.col_nombre, e.getNombre());
            valores.put(DefBD.col_programa, e.getPrograma());
            long id = sql.insert(DefBD.tabla_est, null, valores);
            //sql.execSQL("insert into " + DefBD.tabla_est + " values (" + e.getCodigo() + "," + e.getNombre() + "," + e.getPrograma() +");");
            Toast.makeText(c, "Estudiante registrado", Toast.LENGTH_LONG).show();
        }
        catch(Exception ex){
            Toast.makeText(c, "Error agregando estudiante " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public boolean buscarEstudiante(Estudiante e){
        String args[] = new String[] {e.getCodigo()};
        String[] columnas = {DefBD.col_codigo,DefBD.col_nombre};
        String col[] = new String[] {DefBD.col_codigo,DefBD.col_nombre};
        SQLiteDatabase sql = bd.getReadableDatabase();
      Cursor c = sql.query(DefBD.tabla_est,null,"codigo=?",args,null,null,null);
        if (c.getCount()>0){
            bd.close();
            return true;
        }
        else{
            bd.close();
            return false;
        }
    }

    public Cursor allEstudiantes(){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
 Cursor c = sql.query(DefBD.tabla_est,null,null,null,null,null,null);
            return c;
        }
        catch (Exception ex){
            Toast.makeText(c, "Error consulta estudiantes " + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public Cursor allEstudiantes2(){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            Cursor cur = sql.rawQuery("select codigo as _id , nombre, programa from estudiante", null);
            return cur;
        }
        catch (Exception ex){
            Toast.makeText(c, "Error consulta estudiantes " + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public void eliminarEstudiante(String cod){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            String[] args = {cod};
           sql.delete(DefBD.tabla_est,"codigo=?",args);
            Toast.makeText(c, "Estudiante eliminado", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            Toast.makeText(c, "Error eliminar estudiantes " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void actualizarEstudiante(Estudiante e){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            String[] args = {e.getCodigo()};
            ContentValues valores = new ContentValues();
            valores.put(DefBD.col_nombre, e.getNombre());
            valores.put(DefBD.col_programa, e.getPrograma());
            sql.update(DefBD.tabla_est,valores,"codigo=?",args);
            Toast.makeText(c, "Estudiante actualizado", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            Toast.makeText(c, "Error actualizar estudiantes " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
   }


