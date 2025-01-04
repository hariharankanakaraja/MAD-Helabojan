package com.nibm.hari.helabojan.ui.home

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.nibm.hari.helabojan.R
import com.nibm.hari.helabojan.databinding.ActivityGpsactivityBinding
import com.nibm.hari.helabojan.databinding.ActivityHomeBinding
import java.util.concurrent.TimeUnit

class GPSActivity : Activity() {

    private  lateinit var binding: ActivityGpsactivityBinding
    private lateinit var client: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationResponse: LocationCallback
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGpsactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        client = LocationServices.getFusedLocationProviderClient(this)

        locationRequest = LocationRequest().apply {
            interval = TimeUnit.SECONDS.toMillis(60)
            fastestInterval = TimeUnit.SECONDS.toMillis(30)
            maxWaitTime = TimeUnit.SECONDS.toMillis(2)
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }

        locationResponse = object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult) {
                super.onLocationResult(p0)
                var latitude = p0.lastLocation?.latitude
                var longitude = p0.lastLocation?.longitude
            }
        }
    }


    fun isLocationPermissionGranted(): Boolean{
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ){
            binding.locate.visibility = View.VISIBLE
            return true
        }
        ActivityCompat.requestPermissions(this, arrayOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
        ), 100)
        binding.locate.visibility = View.INVISIBLE
        return false
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 100 ){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                binding.locate.visibility = View.VISIBLE
            }
            else{
                binding.locate.visibility = View.INVISIBLE
            }
        }
    }
}