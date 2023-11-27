package com.rafael.mycafe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity



class ActiveCadastro:AppCompatActivity(){
    private lateinit var CadastrobtnProsseguir :Button
    private lateinit var cadastroBtnvoltarMenu :Button
    private lateinit var inputEmail : EditText
    private lateinit var campoEmail : LinearLayout
    private lateinit var campoSenhaCadastro :LinearLayout
    private lateinit var senha : EditText
    private  lateinit var confirmarSenha : EditText
    private lateinit var continuebtnCadastro :Button
    private  lateinit var  voltarCampoSenhaCadastro : Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        CadastrobtnProsseguir = findViewById(R.id.CadastrobtnProsseguir)
        cadastroBtnvoltarMenu = findViewById(R.id.cadastroBtnvoltarMenu)
        inputEmail = findViewById(R.id.inputEmail)
        campoEmail = findViewById(R.id.campoEmail)
        campoSenhaCadastro = findViewById(R.id.campoSenhaCadastro)
        senha = findViewById(R.id.senha)
        confirmarSenha = findViewById(R.id.confirmarSenha)
        continuebtnCadastro = findViewById(R.id.continuebtnCadastro)
        voltarCampoSenhaCadastro = findViewById(R.id.voltarCampoSenhaCadastro)








        continuebtnCadastro.setOnClickListener {

            val login = Intent(this,ActiveLogin::class.java)

            startActivity(login)
            finish()
        }

        cadastroBtnvoltarMenu.setOnClickListener {


            val home = Intent(this,MainActivity::class.java)

            startActivity(home)
            finish()


        }
        CadastrobtnProsseguir.setOnClickListener {
            campoSenhaCadastro.visibility = View.VISIBLE
            campoEmail.visibility = View.GONE


        }
        voltarCampoSenhaCadastro.setOnClickListener {
            campoSenhaCadastro.visibility = View.GONE
            campoEmail.visibility = View.VISIBLE


        }



    }




}
