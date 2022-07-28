package com.example.dio_women_soccer_news_app

import android.app.Application
import android.content.Context

class WomenSoccerNewsApplication: Application() {
    init { app = this }
    companion object {
        private lateinit var app: WomenSoccerNewsApplication
        fun getAppContext(): Context =
            app.applicationContext
    }
}