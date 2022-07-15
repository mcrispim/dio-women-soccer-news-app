package com.example.womensoccernews.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NoticiasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Este é o fragmento Notícias"
    }
    val text: LiveData<String> = _text
}