package com.example.nathaliapalomera.damd_u3_juego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new lienzo2(this));
    }

    public void abrir (){

        Intent abrir = new Intent(Main3Activity.this, MainActivity.class);
        startActivity(abrir);
    }
}
