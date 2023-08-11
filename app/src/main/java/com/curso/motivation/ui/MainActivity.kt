package com.curso.motivation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.curso.motivation.R
import com.curso.motivation.infra.SecurityPreferences
import com.curso.motivation.databinding.ActivityMainBinding
import com.curso.motivation.infra.MotivationConstants


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewBinding: ActivityMainBinding

    var categoryId: Int = MotivationConstants.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        supportActionBar?.hide()


        setContentView(viewBinding.root)

        viewBinding.buttonNewPhrase.setOnClickListener(this)
        viewBinding.imageAll.setOnClickListener(this)
        viewBinding.imageHappy.setOnClickListener(this)
        viewBinding.imageSun.setOnClickListener(this)


        handleUserName()

        handleFilter(R.id.image_all)
    }

    private fun handleUserName() {
        val securityPreferences = SecurityPreferences(this)
        val name = securityPreferences.getString(MotivationConstants.KEY.USER_NAME)

        if (name != "") {
            viewBinding.textHelloKotlin.setText("Olá, ${name}")
        }
    }

    override fun onClick(view: View) {
       if(view.id ==R.id.button_new_phrase){
          var s = ""
       } else if(view.id in listOf(R.id.image_all, R.id.image_happy, R.id.image_sun)){
           handleFilter(view.id)
       }
    }

    fun handleFilter(id: Int){
        viewBinding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        viewBinding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        viewBinding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))


        when (id) {
            R.id.image_all -> {
                viewBinding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.image_happy -> {
                viewBinding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.HAPPY
            }
            R.id.image_sun -> {
                viewBinding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUN
            }
        }
    }
}