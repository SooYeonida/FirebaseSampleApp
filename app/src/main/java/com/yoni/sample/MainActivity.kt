package com.yoni.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.yoni.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase Auth
        auth = Firebase.auth

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        val email = binding.editEmail.text.toString()
        val pwd = binding.editPwd.text.toString()

        binding.btnJoin.setOnClickListener {
            auth.createUserWithEmailAndPassword(email, pwd)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this,"join success",Toast.LENGTH_SHORT).show()
                    } else {
                        println(task.result)
                        Toast.makeText(this,"join fail",Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }

}