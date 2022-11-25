package br.senai.sp.jandira.games2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.games2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.textSignup.setOnClickListener{
            val openSignupActivity = Intent(this, SignUpActivity::class.java)
            startActivity(openSignupActivity)
        }

        binding.buttonLogin.setOnClickListener {

            if(inputValidate()){
                login()
            }


            val openUserActivity = Intent(this, UserActivity::class.java)
            startActivity(openUserActivity)
        }
    }

    private fun inputValidate(): Boolean {
        if (binding.editTextTextEmailAddress.text.isEmpty()){
            binding.editTextTextEmailAddress.error = "E-mail is required"
            return false
        }
        if (binding.editTextTextPassword.text.isEmpty()){
            binding.editTextTextPassword.error = "Password is required"
            return false
        }

        return true
    }

    private fun login() {
        TODO("Not yet implemented")
    }
}