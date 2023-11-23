package com.rafael.mycafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    private  lateinit var btnLogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            println("text")
        }

    }
}