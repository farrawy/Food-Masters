package com.example.foody.ui.ActivitiesPackage.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.foody.R
import com.example.foody.ui.ActivitiesPackage.Register.RegisterActivity
import com.example.foody.ui.MainActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnlogin: Button
    private lateinit var btnsignup:Button
    private lateinit var btnlogin2:Button
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)

        mAuth= FirebaseAuth.getInstance()

        edtEmail = findViewById(R.id.email_login)
        edtPassword = findViewById(R.id.password_login)
        btnlogin = findViewById(R.id.login_button)
        btnsignup = findViewById(R.id.signup_button_login)
        btnlogin2 = findViewById(R.id.login_button_login)

        btnlogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            login(email,password);
        }
        btnsignup.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
        btnlogin2.setOnClickListener {
            val intent1 = Intent(this, LoginActivity::class.java)
            startActivity(intent1)
            finish()
        }




    }
    private fun login(email: String,password :String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this@LoginActivity,"Loging in to your Account", Toast.LENGTH_SHORT).show()

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this@LoginActivity, "User does not exsit", Toast.LENGTH_SHORT).show()
                }
            }

    }
}