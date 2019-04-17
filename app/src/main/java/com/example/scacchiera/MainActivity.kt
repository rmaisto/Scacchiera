package com.example.scacchiera

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        ScacchieraV.setOnTouchListener(View.OnTouchListener {_,motionEvent->
            when(motionEvent.action){

                MotionEvent.ACTION_UP ->{
                    var x= motionEvent.x.toInt()
                    var y= motionEvent.y.toInt()
                    Toast.makeText(this@MainActivity, "X: " +x+ "Y: "+y, Toast.LENGTH_SHORT).show()
                }
            }
            return@OnTouchListener true
        })
    }
}
