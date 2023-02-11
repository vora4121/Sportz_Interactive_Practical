package com.android.sportz.interactive.practical.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.sportz.interactive.practical.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}