package com.curso.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.curso.motivation.databinding.ActivityMainBinding

class UserActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding =  ActivityMainBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)
    }
}