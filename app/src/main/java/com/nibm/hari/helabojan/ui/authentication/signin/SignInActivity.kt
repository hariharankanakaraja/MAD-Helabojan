package com.nibm.hari.helabojan.ui.authentication.signin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.nibm.hari.helabojan.R
import com.nibm.hari.helabojan.databinding.ActivitySignInBinding
import com.nibm.hari.helabojan.databinding.ActivityWelcomeBinding
import com.google.firebase.auth.auth
import com.google.firebase.Firebase
import com.nibm.hari.helabojan.ui.home.GPSActivity
import com.nibm.hari.helabojan.ui.home.HomeActivity


class SignInActivity : Activity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.btnSignIn.setOnClickListener{

            val email = binding.usernameInp.text.toString().trim()
            val password = binding.passwordInp.text.toString().trim()


            if(email.isNotEmpty() && password.isNotEmpty()){
                //signin in with firebase email auth
                signInWithEmail(email, password)
            }

        }

    }

    fun signInWithEmail(email: String, password: String){

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    navigateHomeActivity()
                } else {
                }
            }
    }

    fun navigateHomeActivity(){
        val intent = Intent(this, GPSActivity::class.java)
        startActivity(intent)
    }

}