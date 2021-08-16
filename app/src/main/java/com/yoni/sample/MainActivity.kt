package com.yoni.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Firebase Auth
        auth = Firebase.auth

        val btnJoin = findViewById<Button>(R.id.btnJoin)
        btnJoin.setOnClickListener {
            auth.createUserWithEmailAndPassword("email@test.com", "pwd test")
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                       Toast.makeText(this,"join success",Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this,"join fail",Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

//    public override fun onStart() {
//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//        if(currentUser != null){
//            reload();
//        }
//    }
}