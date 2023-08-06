package com.curso.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.curso.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        supportActionBar?.hide()


        setContentView(viewBinding.root)

        viewBinding.buttonNewPhrase.setOnClickListener(this)
    }

    override fun onClick(view: View) {
       if(R.id.button_new_phrase == view.id){
          var s = ""

       }

    }
}