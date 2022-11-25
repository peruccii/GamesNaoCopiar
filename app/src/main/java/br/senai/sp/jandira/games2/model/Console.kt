package br.senai.sp.jandira.games2.model

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_console")
class Console {

    @PrimaryKey(autoGenerate = true) var id = 0

    var nome = ""
    var fabricante = ""
    var descricao = ""
    //var photo: Drawable? = null
    var anoLancamento = 0
}