package cl.inacap.examenescovid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Calendar;

import cl.inacap.examenescovid.dao.PacientesDAO;
import cl.inacap.examenescovid.dto.Paciente;

public class RegistrarActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private int dia, mes, anio ;
    private Button fechaBtn = findViewById(R.id.fechaBtn);
    private EditText fechaTxt = findViewById(R.id.fechaTxt);
    private Switch switchSintoma;
    private Switch switchtos;
    PacientesDAO pacientesDAO;

    private EditText nombreTxt = findViewById(R.id.nombreTxtR);
    private EditText rutTxt = findViewById(R.id.rutTxtR);
    private EditText apellidoTxt = findViewById(R.id.apellidoTxtR);
    private EditText fechaExamen = findViewById(R.id.rutTxtR);
    private Spinner areaSpn = findViewById(R.id.areaSpn);
    private Switch sintomas = findViewById(R.id.sintomasSw);

    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        this.toolbar = findViewById(R.id.toolbarRegistrar);
        switchSintoma = (Switch)findViewById(R.id.sintomasSw);
        switchtos = (Switch)findViewById(R.id.tosSw);
        this.setSupportActionBar(this.toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);

        ArrayList<String> areaTrabajo = new ArrayList<>();
        areaTrabajo.add("Atencion a publico");
        areaTrabajo.add("Otro");

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,areaTrabajo);

        fechaBtn = (Button)findViewById(R.id.fechaBtn);
        fechaTxt = (EditText)findViewById(R.id.fechaTxt);
        fechaBtn.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick (View v){
        if(v==fechaBtn){
            final Calendar c= Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            anio=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    fechaTxt.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            },anio,mes,dia);

            datePickerDialog.show();

        }

    }

    public void registrarPaciente(View v){
        ArrayList<String> errores = new ArrayList<>();

            String rut = this.rutTxt.getText().toString().trim();


            String nombre = this.nombreTxt.getText().toString().trim();


            String apellido = this.apellidoTxt.getText().toString().trim();


            String fechaExamen = this.fechaTxt.getText().toString().trim();


            String areaTrabajo = this.areaSpn.getSelectedItem().toString().trim();


           








        if (errores.isEmpty()) {
            Paciente p = new Paciente();
            p.setRut(rut);
            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setFechaExamen(fechaExamen);
            p.setAreaTrabajo(areaTrabajo);
            p.setSintomasInt(sintomasInt);
            p.setTos(tos);
            p.setTemperatura(temperatura);
            p.setPresionArterial(presion);

            pacientesDAO.save(p);



        }else{

        }




    }


}