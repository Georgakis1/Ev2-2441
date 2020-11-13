package cl.inacap.examenescovid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cl.inacap.examenescovid.dao.PacientesDAO;
import cl.inacap.examenescovid.dao.PacientesDAOSQLite;
import cl.inacap.examenescovid.dto.Paciente;

public class MainActivity extends AppCompatActivity {

    private List<Paciente> pacientes = new ArrayList<>();
    private Button iniciarSesion;
    private EditText rutTxt = findViewById(R.id.rutTxt);
    private EditText passTxt = findViewById(R.id.passwordTxt);


    private PacientesDAO pacientesDAO = new PacientesDAOSQLite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.iniciarSesion = findViewById(R.id.iniciarSesionBtn);

        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> errores = new ArrayList<>();
                boolean rutValido= false;
                boolean passValido = false;
                String password = passTxt.getText().toString().trim();
                String rut = rutTxt.getText().toString().trim();

                if (rut.isEmpty()) {
                    errores.add("-el rut no puede estar vacio");


                    }else{

                    if( !(rutValido(rut)) ){
                        errores.add("el rut debe ser valido");
                    }

                }
                if (password.isEmpty()) {
                    errores.add("Ingrese una contraseña");
                }else{
                    if(!(passwordValida(password,rut))){
                        errores.add("-la contraseña es incorrecta");
                    }
                }

                if(errores.isEmpty()){
                    Intent  intent = new Intent(MainActivity.this,PrincipalActivity.class);
                    startActivity(intent);

                }else{
                    mostrarErrores(errores);
                }



            }
        });

    }

    private void mostrarErrores(List<String> errores) {
        String mensaje ="";
        for(String e: errores){
            mensaje+= "-"+ e + "\n";
        }
        AlertDialog.Builder alertBuilder =  new AlertDialog.Builder();
        alertBuilder.setTitle("Error de validacion")
                .setMessage(mensaje)
                .setPositiveButton("Aceptar",null)
                .create()
                .show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        pacientes = pacientesDAO.getAll();


    }

    public boolean rutValido(String rut){
        Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
        Matcher matcher = pattern.matcher(rut);
        if ( !(matcher.matches() == false) ){
            return true;
        }else{
            return false;
        }

    }
    public boolean passwordValida(String pass, String rut){
        boolean passValida = false;
        String passEsperada = rut.substring(4,8);
        if (pass.equals(passEsperada)) {
            passValida=true;
        }



        return passValida;
    }
}