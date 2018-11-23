package com.example.nathaliapalomera.damd_u3_juego;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class lienzo2 extends View {
    image icono1, icono2, icono3, icono4, icono5, icono6, icono7, punto;
    Main3Activity apuntador;
    String mensaje;

    public lienzo2(Context context) {

        super(context);
        icono1 = new image(R.drawable.blue, 100, 300, this);
        icono2 = new image(R.drawable.texblack, 600, 350, this);
        icono3 = new image(R.drawable.red, 100, 750, this);
        icono4 = new image(R.drawable.texblue, 600, 800, this);
        icono5 = new image(R.drawable.black, 100, 1200, this);
        icono6 = new image(R.drawable.texred, 600, 1250, this);
        icono7 = new image(R.drawable.regresar, 650,1650,this);
        mensaje ="";
        punto = null;

        icono2.desplazamiento(600,350,this);
        icono4.desplazamiento(600,800,this);
        icono6.desplazamiento(600,1250,this);

        apuntador = (Main3Activity) context;
    }

    public void onDraw(Canvas c) {

        super.onDraw(c);
        Paint p = new Paint();
        p.setTextSize(40);
        p.setColor(Color.BLACK);
        c.drawColor(Color.CYAN);
        c.drawText("ARRASTRA EL TEXTO AL COLOR QUE CORESPONDE", 80, 120, p);
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

                if(icono7.estaenarea(xp,yp)){
                    apuntador.abrir();
                }

                if(icono2.estaenarea(xp,yp)) {
                    mensaje ="tocaste el texto";

                    punto = icono2;
                }

                if (icono4.estaenarea(xp,yp)) {
                    mensaje ="tocaste el texto";

                    punto = icono4;
                }

                if(icono6.estaenarea(xp,yp)) {
                    mensaje = "tacaste el texto";

                    punto = icono6;
                }
                break;

                    case MotionEvent.ACTION_MOVE:
                        if (punto!= null){
                            punto.mover(xp,yp);

                            if (punto.colision(icono1) && punto == icono4){
                                icono1.hacervisible(false);
                                icono4.hacervisible(false);
                            }
                        }

                        if (punto!= null){
                            punto.mover(xp,yp);

                            if (punto.colision(icono3) && punto == icono6){
                                icono3.hacervisible(false);
                                icono6.hacervisible(false);
                            }
                        }

                        if (punto!= null){
                            punto.mover(xp,yp);

                            if (punto.colision(icono5) && punto == icono2){
                                icono5.hacervisible(false);
                                icono2.hacervisible(false);
                            }
                        }
                        break;

                    case MotionEvent.ACTION_UP:
                        punto = null;
                        break;
                }
                invalidate();
                return true;
            }

}
