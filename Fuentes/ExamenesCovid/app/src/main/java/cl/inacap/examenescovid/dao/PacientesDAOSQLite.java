package cl.inacap.examenescovid.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.examenescovid.dto.Paciente;
import cl.inacap.examenescovid.helpers.PacientesSQLiteHelper;

public class PacientesDAOSQLite implements PacientesDAO {

    private PacientesSQLiteHelper pacHelper;

    public PacientesDAOSQLite(Context context, ){
        this.pacHelper = new PacientesSQLiteHelper(context,"DBPacientes",null, 1);

    }
    @Override
    public List<Paciente> getAll() {
        SQLiteDatabase reader = this.pacHelper.getReadableDatabase();
        List<Paciente> pacientes = new ArrayList<>();
        try{
            if (reader != null) {
                Cursor c = reader.rawQuery("SELECT rut,nombre,apellido,fechaexamen,area," +
                        "sintomas,tos,temperatura,presion FROM pacientes",null);
                if (c.moveToFirst()){
                    do{
                        Paciente p = new Paciente();
                        p.setRut(c.getString(0));
                        p.setNombre(c.getString(1));
                        p.setApellido(c.getString(2));
                        p.setFechaExamen(c.getString(3));
                        p.setAreaTrabajo(c.getString(4));
                        p.setSintomasInt(c.getInt(5));
                        p.setTosInt(c.getInt(6));
                        p.setTemperatura(c.getDouble(7));
                        p.setPresionArterial(c.getInt(8));
                        pacientes.add(p);
                    }while (c.moveToNext());
                    reader.close();
                }
            }
        }catch (Exception ex){
            pacientes=null;
        }
        return pacientes;
    }
    @NonNull
    @Override
    public Paciente save(Paciente p) {
        SQLiteDatabase writer = this.pacHelper.getWritableDatabase();
        String sql = String.format("INSTER INTO pacientes(rut,nombre,apellido,fechaexamen,area,sintomas,tos,temperatura,presion)" +
                "VALUES ('%s','%s','%s','%s','%s','%d','%d','%d','%d')",p.getRut(),p.getNombre(),p.getApellido(),p.getFechaExamen()
                , p.getAreaTrabajo(),p.isSintomas(),p.isTos(),p.getTemperatura(),p.getPresionArterial());
        writer.execSQL(sql);
        writer.close();
        return p;
    }
}
