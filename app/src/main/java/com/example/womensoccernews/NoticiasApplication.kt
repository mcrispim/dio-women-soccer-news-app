package com.example.womensoccernews

import android.app.Application
import android.content.Context

class NoticiasApplication: Application() {
    init { app = this }
    companion object {
        private lateinit var app: NoticiasApplication
        fun getAppContext(): Context = app.applicationContext
    }
}