package com.example.foody

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        signup_button.setOnClickListener {
            val email = email_register.text.toString()
            val password = password_register.text.toString()


            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "invalid email or password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Log.d("RegisterActivity","Email is :"+email)
            Log.d("RegisterActivity","Password is: $password")


        }
        Already_have_an_account_register.setOnClickListener {
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }
        login_button_signup.setOnClickListener {
            val intent1 = Intent(this,Register:: class.java)
            startActivity(intent1)

        }
        signup_button_signup.setOnClickListener {
            val intent2 = Intent(this,Register::class.java)
            startActivity(intent2)
        }
    }
}