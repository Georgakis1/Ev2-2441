package cl.inacap.examenescovid.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import cl.inacap.examenescovid.R;
import cl.inacap.examenescovid.dto.Paciente;

public class PacientesArrayAdapter extends ArrayAdapter<Paciente> {
    private Activity activity;
    private List<Paciente> pacientes;




    public PacientesArrayAdapter(@NonNull Activity context, int resource, @NonNull List<Paciente> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.pacientes = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View fila =inflater.inflate(R.layout.examenes_list,null,true);
        TextView toString = fila.findViewById(R.id.toString_lv);
        ImageView icono = fila.findViewById(R.id.imagen_lv);
        Paciente actual = pacientes.get(position);
        toString.setText(actual.toString());
        if(actual.isSintomas()){
            Picasso.get().load("https://image.flaticon.com/icons/png/512/2854/2854642.png")
                    .resize(35,35).centerCrop().into(icono);
        }else{
            Picasso.get().load("https://image.flaticon.com/icons/png/512/2854/2854643.png")
                    .resize(35,35).centerCrop().into(icono);
        }


      return fila;
    }
}
