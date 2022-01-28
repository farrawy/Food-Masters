package com.example.foody.ui.ActivitiesPackage.Register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.foody.R
import com.example.foody.ui.ActivitiesPackage.Login.LoginActivity
import com.example.foody.ui.MainActivity
import org.w3c.dom.Text

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_register)

        val sign_up_btn = findViewById<Button>(R.id.sign_up_btn)
        val register_login_textView = findViewById<TextView>(R.id.register_login_textView)

        sign_up_btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        register_login_textView.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}