package com.rafael.mycafe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint

class ActiveLogin : AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


    }

}
