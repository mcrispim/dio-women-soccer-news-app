package com.example.womensoccernews.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.womensoccernews.ui.noticias.Noticia

@Database(
    entities = [Noticia::class],
    version = 1,
    exportSchema = false)

abstract class NoticiasDb : RoomDatabase() {
    abstract val dao: NoticiasDao

    companion object {
        @Volatile
        private var INSTANCE: NoticiasDao? = null
        fun getDaoInstance(context: Context): NoticiasDao
        {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = buildDatabase(context).dao
                    INSTANCE = instance
                }
                return instance
            }
        }

        private fun buildDatabase(context: Context): NoticiasDb =
            Room.databaseBuilder(
                context.applicationContext,
                NoticiasDb::class.java,
                "noticias_database")
                .fallbackToDestructiveMigration()
                .build()
    }

}