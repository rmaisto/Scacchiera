package com.example.scacchiera

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.support.constraint.solver.widgets.Rectangle
import android.util.AttributeSet
import android.view.View

class ScacchieraView : View { // creo una classe scacchiera view che estende la classe view
    //devo implementare un costruttore dovrei metterlo sulla riga
    // se sono piu di uno posso scriverli dopo
    constructor(context: Context) : super(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context,attrs, 0)
/* il rettangolo viene identificato da due punti quello in alto a sx e quello in basso a dx
* per questo motivo, ci muoviamo tramite x e y nella view, il punto in alto a sx lo calcolo a partire da due coordinate, left e top, quello in
* basso a dx con right and bottom*/
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var schermo = Rect()
        var div=8
        canvas?.getClipBounds(schermo)//mi dice qual è la dimensione massima e mi salva all'interno di schermo
        var dx= (schermo.right-schermo.left)/div//dimensioni del rettangolo lungo x
        var dy=(schermo.bottom-schermo.top)/div//dimensioni del rettangolo lungo y
        //le coordinatae
        //disegno un rettangolo
          var paint1 = Paint() //rappresenta il pennellino
        paint1.color = Color.BLACK//pennellino di colore nero
        //posso disegnare nel canvas
        var paint2= Paint()
        paint2.color=Color.WHITE
        for(i in 0..div-1){
            for(j in 0..div-1){
                var left=schermo.left+j*dx //punto in alto a sx del rettangolo,ho bisongo di +j*dx perché mi sposto dal lato sx a
                //+j*dx perché moltiplico j ovvero indice per dx dimensione lungo x
                var right=left+dx //il punto alla sua sinistra è ovviamente left + la dimensione lungo x
                var top=schermo.top+i*dy
                var bottom=top+dy

                var casella = Rect(left,top,right,bottom)
                if((i+j)%2==0){ //se la posizione è pari nella matrice coloralo in un modo altrimenti nell'altro
                    canvas?.drawRect(casella, paint1)// va effettuato solo se l'oggetto non è nullo, ci va ? perché
                    //canvas potrebbe essere anche nullo!
                }
                else
                    canvas?.drawRect(casella, paint2)// va effettuato solo se l'oggetto non è nullo, ci va ? perché
                //canvas potrebbe essere anche nullo!

            }
        }
        }

}