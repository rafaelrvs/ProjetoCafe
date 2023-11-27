package com.rafael.mycafe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActiveSobre : AppCompatActivity() {

    private lateinit var btnVoltarSobre :Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre)
        btnVoltarSobre = findViewById(R.id.voltarSobre)




        btnVoltarSobre.setOnClickListener {
            val menuPrincipal = Intent(this,MainActivity::class.java)

            startActivity(menuPrincipal)
            finish()
        }



    }

}
