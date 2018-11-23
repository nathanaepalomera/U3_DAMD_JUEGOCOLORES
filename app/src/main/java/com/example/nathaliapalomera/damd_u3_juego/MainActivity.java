package com.example.nathaliapalomera.damd_u3_juego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new lienzo(this));
    }

public void abrir(){

    Intent abrir = new Intent(MainActivity.this, Main2Activity.class);
    startActivity(abrir);
}


    public void abrirnatha(){

        Intent abrir = new Intent(MainActivity.this, Main3Activity.class);
        startActivity(abrir);
    }

}
