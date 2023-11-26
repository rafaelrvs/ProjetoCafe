package com.rafael.mycafe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    private  lateinit var btnLogin:Button
    private lateinit var btnCadastro:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btnLogin = findViewById<Button>(R.id.btnLogin)
        btnCadastro = findViewById<Button>(R.id.btnCadastro)

        btnLogin.setOnClickListener {
           val login = Intent(this,ActiveLogin::class.java)

            startActivity(login)
            finish()
        }



        btnCadastro.setOnClickListener {

            val cadastro = Intent(this,ActiveCadastro::class.java)

            startActivity(cadastro)
            finish()
        }

    }
}

