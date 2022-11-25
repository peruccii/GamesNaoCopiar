package br.senai.sp.jandira.games2.model

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_user")
class User {

    @PrimaryKey(autoGenerate = true) var id = 0

    var name = ""
    //var photo: Drawable? = null
    var email = ""
    var password = ""
    var city = ""
    var birthDate = ""
    var sex = 'I'
    var console = ""
    var level = EnumLevel.BEGINNER
}