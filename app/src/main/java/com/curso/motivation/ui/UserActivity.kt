package com.curso.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.curso.motivation.R
import com.curso.motivation.infra.SecurityPreferences
import com.curso.motivation.databinding.ActivityUserBinding
import com.curso.motivation.infra.MotivationConstants

class UserActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verifyUserName()


        viewBinding =  ActivityUserBinding.inflate(layoutInflater)

        supportActionBar?.hide()

        setContentView(viewBinding.root)

        viewBinding.buttonSave.setOnClickListener { handleSave() }
    }

    private fun verifyUserName(){
        val securityPreferences = SecurityPreferences(this)
        val name = securityPreferences.getString(MotivationConstants.KEY.USER_NAME)

        if(name != ""){
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
            finish()
        }
    }

    fun handleSave(){
        val name = viewBinding.editName.text.toString()

        val security: SecurityPreferences = SecurityPreferences(this)


        if(name != ""){


            val intent = Intent(this, MainActivity::class.java)

            security.storeString(MotivationConstants.KEY.USER_NAME, name)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this, R.string.validation_name_exception, Toast.LENGTH_SHORT).show()
        }
    }

}