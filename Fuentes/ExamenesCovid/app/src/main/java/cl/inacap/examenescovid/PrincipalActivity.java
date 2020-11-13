package cl.inacap.examenescovid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import cl.inacap.examenescovid.adapters.PacientesArrayAdapter;
import cl.inacap.examenescovid.dao.PacientesDAO;
import cl.inacap.examenescovid.dto.Paciente;

public class PrincipalActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView pacientesLv;
    private List<Paciente> pacientes;
    private PacientesArrayAdapter adaptador;
    private PacientesDAO pacientesDAO ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        this.setSupportActionBar(this.toolbar);

    }
    @Override
    protected void onResume() {
        super.onResume();

        this.toolbar = findViewById(R.id.toolbarPrincipal);
        pacientes = pacientesDAO.getAll();
        adaptador = new PacientesArrayAdapter(this, R.layout.examenes_list,pacientes);
        pacientesLv = findViewById(R.id.examenes_lv);
        pacientesLv.setAdapter(adaptador);
        pacientesLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(PrincipalActivity.this, VerActivity.class);
                Paciente pacienteActual = pacientes.get(i);
                intent.putExtra("Paciente",pacienteActual);
                startActivity(intent);
            }
        });
    }
}