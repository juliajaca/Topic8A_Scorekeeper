package com.example.topic8a_scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView puntuacion1Vista;
    private  TextView puntuacion2Vista;
    private ImageView botonMas1, botonMenos1, botonMas2, botonMenos2;
    private int puntuacion1 = 0;
    private int puntuacion2 = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        puntuacion1Vista = findViewById(R.id.puntuacion1);
        puntuacion2Vista = findViewById(R.id.puntuacion2);
        botonMas1 = findViewById(R.id.botonMasEquipo1);
        botonMenos1 = findViewById(R.id.botonMenosEquipo1);
        botonMas2 = findViewById(R.id.botonMasEquipo2);
        botonMenos2 = findViewById(R.id.botonMenosEquipo2);

        botonMas1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
             increaseScore(view);
            }
        });

        botonMas2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                increaseScore(view);
            }
        });

        botonMenos2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                decreaseScore(view);
            }
        });

        botonMenos1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                decreaseScore(view);
            }
        });

    }

    private void increaseScore(View v){
        int idEquipo = v.getId();
        switch (idEquipo){
            case R.id.botonMasEquipo1:
                puntuacion1++;
                puntuacion1Vista.setText(String.valueOf(puntuacion1));
                break;
            case R.id.botonMasEquipo2:
                puntuacion2++;
                puntuacion2Vista.setText(String.valueOf(puntuacion2));
                break;
            default:
                break;
        }
    }

    private void decreaseScore(View v){
        int idEquipo = v.getId();
        switch (idEquipo){
            case R.id.botonMenosEquipo1:
                puntuacion1--;
                puntuacion1Vista.setText(String.valueOf(puntuacion1));
                break;
            case R.id.botonMenosEquipo2:
                puntuacion2--;
                puntuacion2Vista.setText(String.valueOf(puntuacion2));
                break;
            default:
                break;
        }

    }



}