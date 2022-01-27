package com.example.foody

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.foody.R
import com.example.foody.ui.MainActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class Login: AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnlogin: Button
    private lateinit var btnsignup:Button
    private lateinit var btnlogin2:Button
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
        btnlogin2.setOnClickListener {
            val intent1 = Intent(this, Login::class.java)
            startActivity((intent1))
        }
        Not_a_member_login.setOnClickListener {
        val intent= Intent(this, Register::class.java)
            startActivity(intent);

        }





    }
    private fun login(email: String,password :String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent = Intent(this@Login, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this@Login,"Loging in to your Account",Toast.LENGTH_SHORT).show()

                } else {
                    // If sign in fails, display a message to the user.
                   Toast.makeText(this@Login, "User does not exsit",Toast.LENGTH_SHORT).show()
                }
            }

    }
}