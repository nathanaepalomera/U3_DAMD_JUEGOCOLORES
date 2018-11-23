package com.example.nathaliapalomera.damd_u3_juego;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import org.w3c.dom.Text;

public class lienzo extends View {

    imagen icono1, icono2, icono3;
    MainActivity apunta;

    public lienzo(Context context) {
        super(context);

        icono1 = new imagen(R.drawable.start, 500, 1150, this);
        icono2 = new imagen(R.drawable.play, 500, 1450, this);
        icono3 = new imagen(R.drawable.cara, 180, 300, this);
        apunta =(MainActivity) context;

        }


    public void onDraw(Canvas c) {


        Paint p = new Paint();
        p.setTextSize(80);
        p.setColor(Color.WHITE);
        c.drawColor(Color.BLUE);
        c.drawText("BIENVENIDO/WELCOME", 100, 200, p);
        icono1.pintar(c, p);
        icono2.pintar(c, p);
        icono3.pintar(c, p);
    }

    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()) {

            case MotionEvent.ACTION_DOWN:
                if (icono1.estaenarea(xp,yp)) {
                    apunta.abrir();
                }

                if (icono2.estaenarea(xp,yp)) {
                   apunta.abrirnatha();
                }

                break;
               /* if (icono1.estaenarea(xp,yp)) {
                    icono1.mover(xp,yp);
                }
                if (icono2.estaenarea(xp,yp)) {
                    icono2.mover(xp,yp);
                }*/



        }
        invalidate();
        return true;
    }
}