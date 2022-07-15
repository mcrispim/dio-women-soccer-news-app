package com.example.womensoccernews.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoritosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Este é o fragmento Favoritos"
    }
    val text: LiveData<String> = _text
}