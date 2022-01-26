package com.example.foody

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.foody.ui.MainActivity
import com.example.foody.ui.fragments.recipes.RecipesFragment
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnlogin: Button
    private lateinit var btnsignup: Button
    private lateinit var btnlogin2: Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var edtname: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth= FirebaseAuth.getInstance()
        edtname=findViewById(R.id.username_register)
        edtEmail = findViewById(R.id.email_register)
        edtPassword = findViewById(R.id.password_register)
        btnlogin = findViewById(R.id.signup_button)
        btnsignup = findViewById(R.id.signup_button_signup)
        btnlogin2 = findViewById(R.id.login_button_signup)

        mAuth = FirebaseAuth.getInstance()

        btnsignup.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            signup(email,password);
        }

        Already_have_an_account_register.setOnClickListener {
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }
        login_button_signup.setOnClickListener {
            val intent1 = Intent(this,Login:: class.java)
            startActivity(intent1)

        }
        signup_button_signup.setOnClickListener {
            val intent2 = Intent(this,Register::class.java)
            startActivity(intent2)
        }
    }
    private fun signup(email :String,password:String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this@Register, RecipesFragment::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this@Register,"Some Error occurred",Toast.LENGTH_SHORT).show()

                }
            }
    }
}