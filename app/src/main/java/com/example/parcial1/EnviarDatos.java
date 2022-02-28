package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnviarDatos extends AppCompatActivity {

    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enviardatos);

        siguiente = (Button)findViewById(R.id.btn1);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(EnviarDatos.this, EnviarTodo.class);
                startActivity(siguiente);
            }
        });

        final EditText tNombre = (EditText)this.findViewById(R.id.etNombre);
        final EditText tApellido = (EditText)this.findViewById(R.id.etApellido);
        Button bDatos = (Button)this.findViewById(R.id.btEnviarDatos);

        bDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = tNombre.getText().toString();
                String ape = tApellido.getText().toString();
                Toast.makeText(getApplicationContext(), "Tu nombre es: "+nom+" "+ape,Toast.LENGTH_LONG).show();
            }
        });

    }

}