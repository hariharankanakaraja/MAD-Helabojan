package com.nibm.hari.helabojan.ui.authentication.signin

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nibm.hari.helabojan.R
import com.nibm.hari.helabojan.databinding.ActivitySignInBinding
import com.nibm.hari.helabojan.databinding.ActivityWelcomeBinding

class SignInActivity : Activity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}