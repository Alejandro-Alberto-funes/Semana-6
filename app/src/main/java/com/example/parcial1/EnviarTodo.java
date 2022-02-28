package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnviarTodo extends AppCompatActivity {

    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enviartodo);

        final EditText eNombreuno = (EditText)findViewById(R.id.etNombreuno);
        final EditText eEdad = (EditText)findViewById(R.id.etEdad);
        Button bEnviar = (Button)findViewById(R.id.btn2);

        bEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = eNombreuno.getText().toString();
                String edad = eEdad.getText().toString();
                Bundle pasarDatos = new Bundle();
                pasarDatos.putString("pNombre",nombre);
                pasarDatos.putString("pEdad",edad);
                Intent siga = new
                        Intent(EnviarTodo.this, RecibirDatos.class);
                siga.putExtras(pasarDatos);
                startActivity(siga);
            }
        });

        siguiente = (Button)findViewById(R.id.btn3);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(EnviarTodo.this, Menu.class);
                startActivity(siguiente);
            }
        });



    }
}