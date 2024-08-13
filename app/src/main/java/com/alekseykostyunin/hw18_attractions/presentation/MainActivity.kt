package com.alekseykostyunin.hw18_attractions.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alekseykostyunin.hw18_attractions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}