package com.rafael.mycafe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class ActiveLogin : AppCompatActivity() {


    private lateinit var btnProsseguir: Button
    private lateinit var campoEmail: LinearLayout
    private lateinit var campoSenha: LinearLayout
    private lateinit var voltarCampoSenha: Button
    private lateinit var btnvoltarMenu: Button
    private lateinit var continuebtn: Button
    private lateinit var campoEmailLogin: EditText
    private lateinit var campoSenhaLogin: EditText
    private val auth = FirebaseAuth.getInstance()


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
        campoEmailLogin = findViewById(R.id.campoEmailLogin)
        campoSenhaLogin = findViewById(R.id.campoSenhaLogin)







        btnProsseguir.setOnClickListener { view ->


            if (campoEmailLogin.text.toString().isEmpty()) {
                val mensagem1 =
                    Snackbar.make(view, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                mensagem1.setBackgroundTint((Color.RED))
                mensagem1.show()
            } else {
                campoEmail.visibility = View.GONE
                campoSenha.visibility = View.VISIBLE
            }


        }
        voltarCampoSenha.setOnClickListener {
            campoEmail.visibility = View.VISIBLE
            campoSenha.visibility = View.GONE
        }


        btnvoltarMenu.setOnClickListener {

            val menu = Intent(this, MainActivity::class.java)

            startActivity(menu)
            finish()
        }

        continuebtn.setOnClickListener { view ->


            if (campoSenhaLogin.text.toString().isEmpty()) {
                val mensagem1 =
                    Snackbar.make(view, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                mensagem1.setBackgroundTint((Color.RED))
                mensagem1.show()


            } else {
                val addOnFailureListener = auth.signInWithEmailAndPassword(
                    campoEmailLogin.text.toString(),
                    campoSenhaLogin.text.toString()
                ).addOnCompleteListener { login ->
                    if (login.isSuccessful) {
                        navegarTelaPricipal()
                    }
                }.addOnFailureListener { exception ->
                    val mensagemErro = when (exception) {
                        is FirebaseAuthWeakPasswordException -> "Digite uma senha com no mínimo 6 caracteres"
                        is FirebaseAuthInvalidCredentialsException -> "Digite um e-mail válido"
                        is FirebaseNetworkException -> "Sem conexão com a Internet"
                        else -> "Erro ao fazer o Login"
                    }
                    val mensagem1 =
                        Snackbar.make(view, mensagemErro, Snackbar.LENGTH_SHORT)
                    mensagem1.setBackgroundTint(Color.RED)
                    mensagem1.show()
                }

            }
        }
    }
    private fun navegarTelaPricipal(){
        val intent = Intent(this, MenuStore::class.java)
        startActivity(intent)
        finish()
    }
}

       
            
        



