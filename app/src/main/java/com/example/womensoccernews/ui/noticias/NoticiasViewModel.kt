package com.example.womensoccernews.ui.noticias

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.womensoccernews.NoticiasApplication
import com.example.womensoccernews.data.local.NoticiasDao
import com.example.womensoccernews.data.local.NoticiasDb
import com.example.womensoccernews.data.remote.NoticiasApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NoticiasViewModel : ViewModel() {
    val listaNoticias = MutableLiveData<List<Noticia>>()

    var retrofit = Retrofit.Builder()
        .baseUrl("https://mcrispim.github.io/dio-women-soccer-news-api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    var api: NoticiasApi = retrofit.create(NoticiasApi::class.java)

    private var noticiasDao = NoticiasDb
        .getDaoInstance(
            NoticiasApplication.getAppContext()
        )

    init {
        getRemoteNoticias()
        noticiasDao.addAllNoticias(listaNoticias.value ?: emptyList())
    }

    private fun getRemoteNoticias() {
        api.getNoticias().enqueue(object : Callback<List<Noticia>> {
            override fun onResponse(call: Call<List<Noticia>>, response: Response<List<Noticia>>) {
                if (response.isSuccessful) {
                    listaNoticias.value = response.body()
                } else {
                    TODO("Not yet implemented")
                }
            }

            override fun onFailure(call: Call<List<Noticia>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}