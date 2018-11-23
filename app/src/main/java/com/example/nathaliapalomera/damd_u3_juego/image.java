package com.example.nathaliapalomera.damd_u3_juego;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;

public class image {
    private Bitmap icono;
    private float x,y;
    private boolean visible;
    int incrementox, incrementoy;
    private CountDownTimer tiempo;

    public image(int resource, float _x,float _y, lienzo2 l)
    {
        icono = BitmapFactory.decodeResource(l.getResources(), resource);
        x = _x;
        y = _y;
        visible = true;

    }

    public void pintar (Canvas c, Paint p)
    {
        if(visible)
        {
            c.drawBitmap(icono,x,y,p);
        }

    }
    public void hacervisible (boolean v)
    {

        visible = v;
    }
    public boolean estaenarea (float xp, float yp){
        if (!visible) return false;

        float x2, y2;
        x2 = x+icono.getWidth();
        y2 = y+icono.getHeight();

        if (xp >= x && xp <= x2){
            if (yp >= y && yp <= y2){
                return true;
            }
        }

        return false;

    }
    public void mover(float xp, float yp){
        x = xp - (icono.getWidth()/2);
        y = yp - (icono.getHeight()/2);
    }

    public boolean colision(image objetoB){
        float x2 = x+icono.getWidth();
        float y2 = y+icono.getHeight();

        if (objetoB.estaenarea(x2,y)){
            return true;
        }

        if (objetoB.estaenarea(x,y)){//caso 2
            return true;
        }

        if (objetoB.estaenarea(x2,y2)){//caso 3
            return true;
        }

        if (objetoB.estaenarea(x,y2)){//caso 4
            return true;
        }

        return false;
    }

    public void desplazamiento (final float x1, final float y1,final lienzo2 l) {
        x = x1;
        y = y1;
        final float x2 = x + icono.getWidth();
        final float y2 = y + icono.getHeight();
        incrementox = 5;
        incrementoy = 5;

        tiempo = new CountDownTimer(1000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                x+= incrementox;
                y+= incrementoy;

                if (x1 >= x2){
                    incrementox *= -1;
                }

                if (y1 >= y2){
                    incrementoy *= -1;
                }

                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };
    }
}
