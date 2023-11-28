package com.rafael.mycafe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.google.android.material.snackbar.Snackbar

class ActiveLogin : AppCompatActivity(){



    private lateinit var btnProsseguir : Button
    private lateinit var campoEmail : LinearLayout
    private  lateinit var campoSenha : LinearLayout
    private lateinit var voltarCampoSenha : Button
    private lateinit var  btnvoltarMenu :Button
    private  lateinit var continuebtn :Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnProsseguir = findViewById(R.id.btnProsseguir)
        campoEmail = findViewById(R.id.campoEmail)
        campoSenha = findViewById(R.id.campoSenha)
        voltarCampoSenha = findViewById(R.id.voltarCampoSenha)

        btnvoltarMenu = findViewById(R.id.btnvoltarMenu)

        continuebtn = findViewById(R.id.continuebtn)






        btnProsseguir.setOnClickListener { view ->
            campoEmail.visibility = View.GONE
            campoSenha.visibility = View.VISIBLE


        }
        voltarCampoSenha.setOnClickListener {
            campoEmail.visibility = View.VISIBLE
            campoSenha.visibility = View.GONE
        }


        btnvoltarMenu.setOnClickListener {

            val menu = Intent(this,MainActivity::class.java)

            startActivity(menu)
            finish()
        }

        continuebtn.setOnClickListener {view ->

            if (campoEmail.text.toString().isEmpty() || campoSenha.text.toString().isEmpty()) {
                val mensagem1 =
                    Snackbar.make(view, "Preencha todos os campos", Snackbar.LENGTH_SHORT)
                mensagem1.setBackgroundTint((Color.RED))
                mensagem1.show()


                val menuStore = Intent(this, MenuStore::class.java)

                startActivity(menuStore)
                finish()
            }
        }
    }

}
