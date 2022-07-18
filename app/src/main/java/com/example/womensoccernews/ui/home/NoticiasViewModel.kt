package com.example.womensoccernews.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NoticiasViewModel : ViewModel() {

    private val _noticias = MutableLiveData<List<Noticia>>().apply {

        // Remover mock de notícias
        value = listOf(
            Noticia("Título 1", "Texto 1"),
            Noticia("Título 2", "Texto 2"),
            Noticia("Título 3", "Texto 3"),
            Noticia("Título 4", "Texto 4")
        )
    }
    val listaNoticias: LiveData<List<Noticia>> = _noticias
}