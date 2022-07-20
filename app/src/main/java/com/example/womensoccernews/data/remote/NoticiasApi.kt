package com.example.womensoccernews.data.remote

import com.example.womensoccernews.ui.noticias.Noticia
import retrofit2.Call
import retrofit2.http.GET

interface NoticiasApi {
    @GET("news.json")
    fun getNoticias(): Call<List<Noticia>>
}