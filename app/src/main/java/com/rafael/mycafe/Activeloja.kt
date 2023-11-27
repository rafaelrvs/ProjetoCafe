package com.rafael.mycafe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class Activeloja : AppCompatActivity() {



    private lateinit var btnAdicionar : Button
    private  lateinit var btnRemover : Button
    private lateinit var textCarrinho :TextView
    private lateinit var btnVoltarStore : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)
        var adicionando = 0
        textCarrinho = findViewById(R.id.textCarrinho)
        btnAdicionar = findViewById(R.id.btnAdicionar)
        btnRemover = findViewById(R.id.btnRemover)
        btnVoltarStore = findViewById(R.id.btnVoltarStore)






        btnAdicionar.setOnClickListener {


            adicionando += 1

            textCarrinho.text = adicionando.toString()


        }
        btnRemover.setOnClickListener {

            val number = textCarrinho.text.toString()
            val intNumber = number.toIntOrNull()

            if (intNumber != null) {
                if (intNumber > 1 ){
                    adicionando -= 1
                    textCarrinho.text = adicionando.toString()

                }
            }




        }
        btnVoltarStore.setOnClickListener {
            val menu = Intent(this,MenuStore::class.java)

            startActivity(menu)
            finish()

        }



    }

}
