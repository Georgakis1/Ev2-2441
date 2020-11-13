package cl.inacap.examenescovid.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PacientesSQLiteHelper extends SQLiteOpenHelper {

    private final String sqlCreate = "CREATE TABLE pacientes(rut TEXT PRIMARY KEY NOT NULL "+
                                    ",nombre TEXT"  +
                                    ",apellido TEXT"    +
                                    ",fechaexamen NUMERIC"  +
                                    ",area TEXT"    +
                                    ",sintomas NUMERIC"  +
                                    ",tos NUMERIC"  +
                                    ",temperatura REAL" +
                                    ",presion INTEGER";
    public PacientesSQLiteHelper(@Nullable Context context
            , @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory
            , int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
