package com.nibm.hari.helabojan.ui.home

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nibm.hari.helabojan.R
import com.nibm.hari.helabojan.databinding.ActivityHomeBinding
import com.nibm.hari.helabojan.databinding.ActivitySignInBinding

class HomeActivity : Activity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navMenu
        val navController = findNavController(R.id.nav_host_fragment_view)
        navView.setupWithNavController(navController)
    }
}