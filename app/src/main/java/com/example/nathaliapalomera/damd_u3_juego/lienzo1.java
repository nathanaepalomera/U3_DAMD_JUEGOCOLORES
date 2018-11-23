package com.example.nathaliapalomera.damd_u3_juego;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class lienzo1 extends View {

    img icono1, icono2, icono3, icono4, icono5, icono6, icono7;
    Main2Activity apuntador;

    public lienzo1(Context context) {
        super(context);

        icono1 = new img(R.drawable.blue, 100, 250, this);
        icono2 = new img(R.drawable.red, 600, 250, this);
        icono3 = new img(R.drawable.green, 100, 700, this);
        icono4 = new img(R.drawable.yellow, 600, 700, this);
        icono5 = new img(R.drawable.orange, 100, 1150, this);
        icono6 = new img(R.drawable.black, 600, 1150, this);
        icono7 = new img(R.drawable.regresar, 650, 1650, this);

        apuntador = (Main2Activity) context;
    }

    public void onDraw(Canvas c) {


        Paint p = new Paint();
        p.setTextSize(65);
        p.setColor(Color.BLACK);
        c.drawColor(Color.CYAN);
        c.drawText("TOCA Y ESCUCHA EL COLOR", 120, 120, p);
        icono1.pintar(c, p);
        icono2.pintar(c, p);
        icono3.pintar(c, p);
        icono4.pintar(c, p);
        icono5.pintar(c, p);
        icono6.pintar(c, p);
        icono7.pintar(c, p);
    }

    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX();
        float yp = e.getY();


        switch (e.getAction()) {

            case MotionEvent.ACTION_DOWN:
                if (icono1.estaenarea(xp,yp)) {
                    apuntador.iconoazul();
                }

                if (icono2.estaenarea(xp,yp)) {
                    apuntador.iconorojo();
                }

                if(icono3.estaenarea(xp,yp)){
                   apuntador.iconoverde();
                }

                if(icono4.estaenarea(xp,yp)){
                    apuntador.iconoamarillo();
                }

                if(icono5.estaenarea(xp,yp)){
                    apuntador.icononaranja();
                }

                if(icono6.estaenarea(xp,yp)){
                    apuntador.icononegro();
                }

                if(icono7.estaenarea(xp,yp)){
                    apuntador.abrir();
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
