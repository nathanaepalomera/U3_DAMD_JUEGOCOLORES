package com.example.nathaliapalomera.damd_u3_juego;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import org.w3c.dom.Text;

public class imagen {

    private Bitmap icono;
    private float x,y;
    private boolean visible;
    int incremento;

    public imagen(int resource, float _x,float _y,lienzo l)
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

        if (xp>=x && xp<= x2){
            if (yp>=y && yp<= y2){
                return true;
            }
        }

        return false;

    }

}
