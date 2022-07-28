package com.example.womensoccernews.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.womensoccernews.ui.noticias.Noticia

@Dao
interface NoticiasDao {

    @Query("SELECT * FROM noticia")
    fun getAllNoticias(): List<Noticia>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllNoticias(restaurants: List<Noticia>)

}