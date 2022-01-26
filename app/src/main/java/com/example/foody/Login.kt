package com.example.foody

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_login.*

class Login: AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnlogin: Button
    private lateinit var btnsignup:Button
    private lateinit var btnlogin2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        edtEmail = findViewById(R.id.email_login)
        edtPassword = findViewById(R.id.password_login)
        btnlogin = findViewById(R.id.login_button)
        btnsignup = findViewById(R.id.signup_button_login)
        btnlogin2 = findViewById(R.id.login_button_login)

        btnsignup.setOnClickListener {
            val intent = Intent(this,Register::class.java)
            startActivity(intent)
        }
        btnlogin2.setOnClickListener {
            val intent1 = Intent(this,Login::class.java)
            startActivity((intent1))
        }
        Not_a_member_login.setOnClickListener {
        val intent= Intent(this,Register::class.java)
            startActivity(intent)

        }




    }
}