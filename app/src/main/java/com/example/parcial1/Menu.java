package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button Opcion1;
    Button Opcion2;
    Button Opcion3;
    Button Opcion4;
    Button Opcion5;
    Button Opcion6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        Button bOpcion1 = (Button) findViewById(R.id.btOpcion1);
        Button bOpcion2 = (Button) findViewById(R.id.btOpcion2);
        Button bOpcion3 = (Button) findViewById(R.id.btOpcion3);
        Button bOpcion4 = (Button) findViewById(R.id.btOpcion4);
        Button bOpcion5 = (Button) findViewById(R.id.btOpcion5);
        Button bOpcion6 = (Button) findViewById(R.id.btOpcion6);

        bOpcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, EnviarDatos.class);
                startActivity(i);
            }
        });

        bOpcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, Tablas.class);
                startActivity(i);
            }
        });

        bOpcion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, Proximidad.class);
                startActivity(i);
            }
        });
        bOpcion4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, Acelerometro.class);
                startActivity(i);
            }
        });
        bOpcion5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, Reproductor.class);
                startActivity(i);
            }
        });
        bOpcion6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, Info.class);
                startActivity(i);
            }
        });
    }
}