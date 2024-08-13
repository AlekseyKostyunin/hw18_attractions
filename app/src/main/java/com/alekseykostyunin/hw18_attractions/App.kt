package com.alekseykostyunin.hw18_attractions

import android.app.Application
import androidx.room.Room
import com.alekseykostyunin.hw18_attractions.data.AppDatabase

class App : Application(){
    lateinit var db: AppDatabase

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "db"
        ).build()
    }
}