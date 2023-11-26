package com.rafael.mycafe

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity




class MenuStore : AppCompatActivity(){

    private lateinit var  card01 :View
    private lateinit var  card02 :View
    private lateinit var  card03 :View
    private lateinit var  card04 :View
    private lateinit var  card05 :View
    private lateinit var  card06 :View
    private var rotationDegrees = 0f
    private fun rotateView(view: View, degrees: Float, duration: Long) {
        view.animate().rotationY(degrees).setDuration(duration).start()
    }






    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?){


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)




        card01 = findViewById(R.id.card01)
        card02 = findViewById(R.id.card02)
        card03 = findViewById(R.id.card03)
        card04 = findViewById(R.id.card04)
        card05 = findViewById(R.id.card05)
        card06 = findViewById(R.id.card06)

        card01.setOnClickListener { view ->

            val duration = 1000L
            rotationDegrees += 180f
            rotateView(view, rotationDegrees, duration)



        }
        card02.setOnClickListener { view ->
            val duration = 1000L
            rotationDegrees += 180f
            rotateView(view, rotationDegrees, duration)



        }
        card03.setOnClickListener { view ->

            val duration = 1000L
            rotationDegrees += 180f
            rotateView(view, rotationDegrees, duration)





        }
        card04.setOnClickListener { view ->
            val duration = 1000L
            rotationDegrees += 180f
            rotateView(view, rotationDegrees, duration)




        }
        card05.setOnClickListener { view ->
            val duration = 1000L
            rotationDegrees += 180f
            rotateView(view, rotationDegrees, duration)



        }
        card06.setOnClickListener { view ->

            val duration = 1000L
            rotationDegrees += 180f
            rotateView(view, rotationDegrees, duration)




        }

    }


}
