package com.rafael.mycafe

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException


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
    private val auth = FirebaseAuth.getInstance()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        FirebaseApp.initializeApp(this)

        CadastrobtnProsseguir = findViewById(R.id.CadastrobtnProsseguir)
        cadastroBtnvoltarMenu = findViewById(R.id.cadastroBtnvoltarMenu)
        inputEmail = findViewById(R.id.inputEmail)
        campoEmail = findViewById(R.id.campoEmail)
        campoSenhaCadastro = findViewById(R.id.campoSenhaCadastro)
        senha = findViewById(R.id.senhacadastro)
        confirmarSenha = findViewById(R.id.confirmarSenha)
        continuebtnCadastro = findViewById(R.id.continuebtnCadastro)
        voltarCampoSenhaCadastro = findViewById(R.id.voltarCampoSenhaCadastro)








        continuebtnCadastro.setOnClickListener {view ->
            val email = inputEmail.text.toString().trim()
            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                inputEmail.error = "Digite um e-mail válido"
                return@setOnClickListener
            }

            // Validação do campo de senha
            val senha = senha.text.toString().trim()

            if (senha.length < 6) {
                exibirPopup()
                return@setOnClickListener
            }

            // Validação do campo de confirmação de senha
            val confirmacaoSenha = confirmarSenha.text.toString().trim()
            if (confirmacaoSenha != senha) {
                confirmarSenha.error = "As senhas não coincidem"
                return@setOnClickListener
            }
            if (email.isEmpty() || senha.isEmpty()) {
                val mensagem =
                    Snackbar.make(view, "Preencha todos os campos", Snackbar.LENGTH_SHORT)
                mensagem.setBackgroundTint(Color.RED)
                mensagem.show()

            }
            else{



                auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener {cadastro ->
                    if (cadastro.isSuccessful){
                        val mensagem =
                            Snackbar.make(view, "Cadastro realizado", Snackbar.LENGTH_LONG)
                        mensagem.setBackgroundTint(Color.BLUE)
                        mensagem.show()
                        inputEmail.setText("")

                        val cadOK = Intent (this,MainActivity::class.java )
                        startActivity(cadOK)
                        finish()
                    }



                }.addOnFailureListener{exception ->
                    val mensagemErro = when (exception){
                        is FirebaseAuthWeakPasswordException -> getString(R.string.ErroSenha)
                        is FirebaseAuthInvalidCredentialsException -> getString(R.string.ErroEmail)
                        is FirebaseAuthUserCollisionException -> "Essa conta já existe"
                        is FirebaseNetworkException -> "Sem conexão com a Internet"
                        else -> "Erro ao cadastrar usuário"
                    }

                    val mensagem =
                        Snackbar.make(view, mensagemErro, Snackbar.LENGTH_SHORT)
                    mensagem.setBackgroundTint(Color.RED)
                    mensagem.show()
                }
            }




        }

        cadastroBtnvoltarMenu.setOnClickListener {




            val home = Intent(this,MainActivity::class.java)

            startActivity(home)
            finish()


        }
        CadastrobtnProsseguir.setOnClickListener {

            val email = inputEmail.text.toString().trim()
            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                inputEmail.error = "Digite um e-mail válido"
                return@setOnClickListener
            }




            campoSenhaCadastro.visibility = View.VISIBLE
            campoEmail.visibility = View.GONE


        }
        voltarCampoSenhaCadastro.setOnClickListener {
            campoSenhaCadastro.visibility = View.GONE
            campoEmail.visibility = View.VISIBLE


        }



    }
    private fun exibirPopup() {
        val builder = AlertDialog.Builder(this)

        builder.setTitle("Senha invalida")
        builder.setMessage("Deve ser maior do que 6 digitos")

        builder.setPositiveButton("OK") { dialog, which ->
            dialog.dismiss()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()

    }




}

