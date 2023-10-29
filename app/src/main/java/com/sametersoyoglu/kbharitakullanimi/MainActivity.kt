package com.sametersoyoglu.kbharitakullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sametersoyoglu.kbharitakullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , OnMapReadyCallback {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.buttonKonumaGit.setOnClickListener {

            val konum = LatLng(41.0370013, 28.974792)
            mMap.addMarker(MarkerOptions().position(konum).title("Taksim")) // marker demek.
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(konum,15f))
            mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE

        }


    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val konum = LatLng(38.0648841, 29.797302)
        mMap.addMarker(MarkerOptions().position(konum).title("Ankara")) // marker demek.
        mMap.moveCamera(CameraUpdateFactory.newLatLng(konum))

    }
}