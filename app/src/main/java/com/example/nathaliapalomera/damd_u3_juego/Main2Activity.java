package com.example.nathaliapalomera.damd_u3_juego;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {
    MediaPlayer audio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new lienzo1(this));
    }


    public void iconoazul(){
        audio= MediaPlayer.create(this,R.raw.blu);
        audio.start();
    }

    public void iconorojo(){
        audio = MediaPlayer.create(this, R.raw.red);
        audio.start();
    }

    public void iconoverde() {
        audio = MediaPlayer.create(this, R.raw.green);
        audio.start();
    }

    public void iconoamarillo() {
        audio = MediaPlayer.create(this, R.raw.yellow);
        audio.start();
    }

    public void icononaranja() {
        audio = MediaPlayer.create(this, R.raw.orange);
        audio.start();
    }

    public void icononegro() {
        audio = MediaPlayer.create(this, R.raw.black);
        audio.start();
    }

    public void abrir(){

        Intent abrir = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(abrir);
    }
}
