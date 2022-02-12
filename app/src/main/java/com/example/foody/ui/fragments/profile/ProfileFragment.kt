package com.example.foody.ui.fragments.profile

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.foody.R
import com.example.foody.databinding.ActivityRegisterBinding
import com.example.foody.ui.ActivitiesPackage.Login.LoginActivity
import com.example.foody.ui.ActivitiesPackage.Register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {
    private lateinit var binding:ProfileFragment


    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        mAuth = FirebaseAuth.getInstance()



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)


    }




}