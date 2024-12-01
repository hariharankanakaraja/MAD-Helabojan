package com.nibm.hari.helabojan.ui.welcome

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nibm.hari.helabojan.R
import com.nibm.hari.helabojan.databinding.ActivityWelcomeBinding
import com.nibm.hari.helabojan.ui.authentication.signin.SignInActivity

class WelcomeActivity : Activity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        if (supportActionBar != null) {
//            supportActionBar?.hide();
//        }

        binding.start.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}