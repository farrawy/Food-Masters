package com.example.foody.ui.ActivitiesPackage.Welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.foody.R
import com.example.foody.ui.ActivitiesPackage.Login.LoginActivity
import com.example.foody.ui.ActivitiesPackage.Register.RegisterActivity
import com.example.foody.ui.MainActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_welcome)

        val welcome_login_btn = findViewById<Button>(R.id.welcome_login_btn)
        val welcome_sign_up_btn = findViewById<Button>(R.id.welcome_sign_up_btn)
        val welcome_signing_up = findViewById<TextView>(R.id.welcome_signing_up)

        welcome_login_btn.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        welcome_sign_up_btn.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        welcome_signing_up.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}