package com.example.parcial1;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Reproductor extends AppCompatActivity {

    Button regresar;

    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 4, posicion = 0;

    MediaPlayer vectormp[] = new MediaPlayer[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        Button bregresar = (Button) findViewById(R.id.btnvolver);
        bregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Reproductor.this, Menu.class);
                startActivity(i);
            }
        });

        play_pause = (Button) findViewById(R.id.btnplay);
        btn_repetir = (Button) findViewById(R.id.btnrepetir);
        iv = (ImageView) findViewById(R.id.imageView2);

        vectormp[0] = MediaPlayer.create(this, R.raw.adoreyou);
        vectormp[1] = MediaPlayer.create(this, R.raw.letmeloveyou);
        vectormp[2] = MediaPlayer.create(this, R.raw.calla);
        vectormp[3] = MediaPlayer.create(this, R.raw.cancioncitas);
        vectormp[4] = MediaPlayer.create(this, R.raw.levitating);
    }


    public void PLayPause(View view) {
        if (vectormp[posicion].isPlaying()) {
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
        } else {
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }


    // Método para el botón Stop
    public void Stop(View view) {
        if (vectormp[posicion] != null) {
            vectormp[posicion].stop();

            vectormp[0] = MediaPlayer.create(this, R.raw.adoreyou);
            vectormp[1] = MediaPlayer.create(this, R.raw.letmeloveyou);
            vectormp[2] = MediaPlayer.create(this, R.raw.calla);
            vectormp[3] = MediaPlayer.create(this, R.raw.cancioncitas);
            vectormp[4] = MediaPlayer.create(this, R.raw.levitating);
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.adore);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }

    // Método repetir pista
    public void Repetir(View view) {
        if (repetir == 1) {
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping((false));
            repetir = 2;
        } else {
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping((true));
            repetir = 1;
        }
    }


    //Método siguiente
    public void Siguiente(View view) {
        if (posicion < vectormp.length - 1) {
            if (vectormp[posicion].isPlaying()) {
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();
                if (posicion == 0) {
                    iv.setImageResource(R.drawable.adore);
                } else if (posicion == 1) {
                    iv.setImageResource(R.drawable.letme);
                } else if (posicion == 2) {
                    iv.setImageResource(R.drawable.callaita);
                } else if (posicion == 3) {
                    iv.setImageResource(R.drawable.amor);
                } else if (posicion == 4) {
                    iv.setImageResource(R.drawable.levitating);
                }

            } else {
                posicion++;
                if (posicion == 0) {
                    iv.setImageResource(R.drawable.adore);
                } else if (posicion == 1) {
                    iv.setImageResource(R.drawable.letme);
                } else if (posicion == 2) {
                    iv.setImageResource(R.drawable.callaita);
                } else if (posicion == 3) {
                    iv.setImageResource(R.drawable.amor);
                } else if (posicion == 4) {
                    iv.setImageResource(R.drawable.levitating);
                }
            }
        } else {
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
        }
    }

    // Método para regresar a la canción anterior
    public void Anterior(View view) {

        if (posicion >= 1) {

            if (vectormp[posicion].isPlaying()) {
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this, R.raw.adoreyou);
                vectormp[1] = MediaPlayer.create(this, R.raw.letmeloveyou);
                vectormp[2] = MediaPlayer.create(this, R.raw.calla);
                vectormp[3] = MediaPlayer.create(this, R.raw.cancioncitas);
                vectormp[4] = MediaPlayer.create(this, R.raw.levitating);
                posicion--;

                if (posicion == 0) {
                    iv.setImageResource(R.drawable.adore);
                } else if (posicion == 1) {
                    iv.setImageResource(R.drawable.letme);
                } else if (posicion == 2) {
                    iv.setImageResource(R.drawable.callaita);
                } else if (posicion == 3) {
                    iv.setImageResource(R.drawable.amor);
                } else if (posicion == 4) {
                    iv.setImageResource(R.drawable.levitating);
                }

                vectormp[posicion].start();

            } else {
                posicion--;
                if (posicion == 0) {
                    iv.setImageResource(R.drawable.adore);
                } else if (posicion == 1) {
                    iv.setImageResource(R.drawable.letme);
                } else if (posicion == 2) {
                    iv.setImageResource(R.drawable.callaita);
                } else if (posicion == 3) {
                    iv.setImageResource(R.drawable.amor);
                } else if (posicion == 4) {
                    iv.setImageResource(R.drawable.levitating);
                }
            }
        } else {
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
        }
    }
}
