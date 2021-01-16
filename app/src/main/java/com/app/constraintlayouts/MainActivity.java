package com.app.constraintlayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox cFiebre, cTos, cCansancio, cDolorCabeza, cConjuntivitis;
    private Button btnEnviar;
    private EditText eTxtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnEnviar.setOnClickListener(click -> {
            String nombre = eTxtNombre.getText().toString();
            if (!nombre.isEmpty()){
                String textoEnviar = "El usuario " + nombre;
                textoEnviar += "\nPresenta los siguientes sintomas:\n";
                if (cFiebre.isChecked()) textoEnviar += "- Fiebre.\n";
                if (cTos.isChecked()) textoEnviar += "- Tos.\n";
                if (cCansancio.isChecked()) textoEnviar += "- Cansancio.\n";
                if (cDolorCabeza.isChecked()) textoEnviar += "- Dolor cabeza.\n";
                if (cConjuntivitis.isChecked()) textoEnviar += "- Conjuntivitis.\n";

                Intent abrir = new Intent(Intent.ACTION_SEND);
                abrir.putExtra(Intent.EXTRA_TEXT, textoEnviar);
                abrir.setType("text/plain");
                startActivity(abrir);
            }else{
                Toast.makeText(this, "Ingrese nombre", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        cFiebre = findViewById(R.id.cBoxFiebre);
        cTos = findViewById(R.id.cBoxTos);
        cCansancio = findViewById(R.id.cBoxCansancio);
        cDolorCabeza = findViewById(R.id.cBoxDolorCabeza);
        cConjuntivitis = findViewById(R.id.cBoxConjuntivitis);
        btnEnviar = findViewById(R.id.btnEnviar);
        eTxtNombre = findViewById(R.id.eTxtNombre);
    }
}