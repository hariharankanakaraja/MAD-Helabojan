package com.nibm.hari.helabojan.ui.home

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nibm.hari.helabojan.R
import com.nibm.hari.helabojan.databinding.ActivityHomeBinding
import com.nibm.hari.helabojan.databinding.ActivitySignInBinding

class HomeActivity : Activity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}