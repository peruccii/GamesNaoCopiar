package br.senai.sp.jandira.games2.repository

import android.content.Context
import br.senai.sp.jandira.games2.dao.GamesDB
import br.senai.sp.jandira.games2.model.Console
import br.senai.sp.jandira.games2.model.Games
import br.senai.sp.jandira.games2.model.User

class gamesRepository(context: Context) {

    private val db = GamesDB.getDatabase(context).gamesDao()

    fun saveUser(user: User):Long{
        return db.saveUser(user)
    }

    fun updateUser(user: User): Int{
        return db.updateUser(user)
    }

    fun deleteUser(user: User): Int{
        return db.deleteUser(user)
    }

    fun saveGame(games: Games):Long{
        return db.saveGame(games)
    }

    fun updateGame(games: Games): Int{
        return db.updateGame(games)
    }

    fun deleteGame(games: Games): Int{
        return db.deleteGame(games)
    }

    fun getAllGames(): List<Games>{
        return db.getAllGames()
    }

    fun saveConsole(console: Console):Long{
        return db.saveConsole(console)
    }

    fun updateConsole(console: Console): Int{
        return db.updateConsole(console)
    }

    fun deleteConsole(console: Console): Int{
        return db.deleteConsole(console)
    }

    fun getAllConsole(): List<String>{
        return db.getAllConsole()
    }
}