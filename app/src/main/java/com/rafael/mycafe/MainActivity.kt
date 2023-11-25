package com.rafael.mycafe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    private  lateinit var btnLogin:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
           val login = Intent(this,ActiveLogin::class.java)

            startActivity(login)
            finish()
        }

    }
}

