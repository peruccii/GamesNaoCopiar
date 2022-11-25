package br.senai.sp.jandira.games2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games2.R
import br.senai.sp.jandira.games2.adapter.GamesAdapter
import br.senai.sp.jandira.games2.dao.GamesDao

class UserActivity : AppCompatActivity() {

    lateinit var rvGames: RecyclerView
    lateinit var adapterGames: GamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_user)

        rvGames = findViewById(R.id.rv_games)
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //adapterGames = GamesAdapter(this)
        //adapterGames.updateGamesList(GamesDao.getGames(this))

        //rvGames.adapter = adapterGames
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_user, menu)

        return true
    }
}