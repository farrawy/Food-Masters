package com.example.foody

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.foody.ui.MainActivity
import com.example.foody.ui.fragments.recipes.RecipesFragment
import kotlinx.android.synthetic.main.activity_welcome.*



class welcome: AppCompatActivity() {
    private lateinit var btnlogin: Button
    private lateinit var btnsignup: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


        btnlogin =findViewById(R.id.login_button_welcome)
        btnsignup = findViewById(R.id.signup_button_welcome)


        btnsignup.setOnClickListener {
            val intent = Intent(this,Register::class.java)
            startActivity(intent)
        }
        btnlogin.setOnClickListener {
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }
        Continue_welcome.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }



    }
 }

