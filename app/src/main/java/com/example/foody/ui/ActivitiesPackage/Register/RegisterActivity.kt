package com.example.foody.ui.ActivitiesPackage.Register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.foody.R
import com.example.foody.ui.ActivitiesPackage.Login.LoginActivity
import com.example.foody.ui.MainActivity
import com.example.foody.ui.fragments.recipes.RecipesFragment
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnsignup2: Button
    private lateinit var btnlogin: Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var edtname: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_register)

        mAuth= FirebaseAuth.getInstance()
        edtname=findViewById(R.id.Name_register)
        edtEmail = findViewById(R.id.email_register)
        edtPassword = findViewById(R.id.password_register)
        btnsignup2 = findViewById(R.id.signup_button_signup)
        btnlogin = findViewById(R.id.login_button_signup)

        mAuth = FirebaseAuth.getInstance()

        val sign_up_btn = findViewById<Button>(R.id.signup_button)
        val register_login_textView = findViewById<TextView>(R.id.register_login_textView)

        sign_up_btn.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            signup(email,password);
        }

        register_login_textView.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        login_button_signup.setOnClickListener {
            val intent1 = Intent(this, LoginActivity:: class.java)
            startActivity(intent1)
            finish()

        }
        signup_button_signup.setOnClickListener {
            val intent2 = Intent(this, RegisterActivity::class.java)
            startActivity(intent2)
            finish()
        }
    }
    private fun signup(email :String,password:String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this@RegisterActivity,"Registering your account", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(this@RegisterActivity,"Some Error occurred", Toast.LENGTH_SHORT).show()

                }
            }
    }

}