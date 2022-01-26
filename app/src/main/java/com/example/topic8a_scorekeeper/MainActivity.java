package com.example.topic8a_scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static  final String STATE_SCORE_1  = "puntuacion1";
    private static final String STATE_SCORE_2 = "puntuacion2" ;
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

        if (savedInstanceState != null) {
            puntuacion1 = savedInstanceState.getInt(STATE_SCORE_1);
            puntuacion2 = savedInstanceState.getInt(STATE_SCORE_2);

            //Set the score text views
            puntuacion1Vista.setText(String.valueOf(puntuacion1));
            puntuacion2Vista.setText(String.valueOf(puntuacion2));
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu from XML
        getMenuInflater().inflate(R.menu.main_menu, menu);

        //Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){

            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode){
            //Get the night mode state of the app
            int nightMode = AppCompatDelegate.getDefaultNightMode();
        //Set the theme mode for the restarted activity
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
        recreate();
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Save the scores
        outState.putInt(STATE_SCORE_1, puntuacion1);
        outState.putInt(STATE_SCORE_2, puntuacion2);
        super.onSaveInstanceState(outState);
    }
}