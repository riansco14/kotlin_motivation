package com.curso.motivation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.curso.motivation.R
import com.curso.motivation.infra.SecurityPreferences
import com.curso.motivation.databinding.ActivityMainBinding
import com.curso.motivation.infra.MotivationConstants


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        supportActionBar?.hide()


        setContentView(viewBinding.root)

        viewBinding.buttonNewPhrase.setOnClickListener(this)

        val securityPreferences = SecurityPreferences(this)
        val name = securityPreferences.getString(MotivationConstants.KEY.USER_NAME)

        if(name != ""){
            viewBinding.textHelloKotlin.setText("Olá, ${name}")
        }
    }

    override fun onClick(view: View) {
       if(R.id.button_new_phrase == view.id){
          var s = ""

       }
    }
}