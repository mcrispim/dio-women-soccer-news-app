package com.example.womensoccernews.ui.noticias

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Noticia(
    @PrimaryKey
    val id: Int,
    val titulo: String,
    val texto: String,
    val imagem: String,
    val link: String,
    var isFavorite: Boolean
)
