package br.senai.sp.jandira.games2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import br.senai.sp.jandira.games2.R
import br.senai.sp.jandira.games2.databinding.ActivityMainBinding
import br.senai.sp.jandira.games2.databinding.ActivitySignUpBinding
import br.senai.sp.jandira.games2.model.Console
import br.senai.sp.jandira.games2.model.EnumLevel
import br.senai.sp.jandira.games2.model.User
import br.senai.sp.jandira.games2.repository.gamesRepository
import com.google.android.material.slider.Slider

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    lateinit var userRepository: gamesRepository
    lateinit var user: User
    lateinit var console: Console

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //console = Console()
        //cadastro()
        userRepository = gamesRepository(this)

        val lista = userRepository.getAllConsole()

        val arrayAdapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, lista)
        binding.spinner.adapter = arrayAdapter

        binding.enumLevel.text = EnumLevel.BEGINNER.toString()

        binding.slider.addOnChangeListener { _, value, _ ->
            if (value.toInt() == 1){
                binding.enumLevel.text = EnumLevel.BEGINNER.toString()
            } else if (value.toInt() == 2){
                binding.enumLevel.text = EnumLevel.BASIC.toString()
            }else if (value.toInt() == 3){
                binding.enumLevel.text = EnumLevel.CASUAL.toString()
            }else if (value.toInt() == 4){
                binding.enumLevel.text = EnumLevel.ADVANCED.toString()
            }
        }
    }

    private fun cadastro() {
        console.anoLancamento = 2013
        console.descricao = "O PlayStation 4, ou PS4 (como é mais conhecido) é um video game da Sony lançado em 2013. O console tem três versões principais: fat, slim e Pro. A primeira (e original) tem esse nome por causa do peso e conta com 500 GB de armazenamento."
        console.fabricante = "Sony"
        console.nome = "Playstation 4"

        userRepository = gamesRepository(this)


        val id = userRepository.saveConsole(console)

        Toast.makeText(this, "ID: $id", Toast.LENGTH_LONG).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_new_user, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.menu_save){
            user = User()
            save()
            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
            return true
        }else if(item.itemId == R.id.menu_setting){
            Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()
            return true
        } else{
            Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
            return true
        }
    }



    private fun save() {

        user.email = binding.editEmail.text.toString()
        user.password = binding.editEmail.text.toString()
        user.name = binding.editName.text.toString()
        user.city = binding.editCity.text.toString()

        val op = binding.radioGroup!!.checkedRadioButtonId

        user.sex = op.toChar()
        user.console = binding.spinner.selectedItem.toString()

        userRepository = gamesRepository(this)


        val id = userRepository.saveUser(user)

        Toast.makeText(this, "ID: $id", Toast.LENGTH_LONG).show()


        finish()
    }
}