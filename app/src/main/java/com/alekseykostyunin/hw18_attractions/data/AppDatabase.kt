package com.alekseykostyunin.hw18_attractions.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alekseykostyunin.hw18_attractions.entity.Photo

@Database(entities = [Photo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    companion object{
        private var db: AppDatabase? = null
        private const val DB_NAME = "db"
        private val LOCK = Any()

        fun getInstance(context: Context):AppDatabase{
            synchronized(LOCK){
                db?.let {return it}
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DB_NAME
                ).build()
                db = instance
                return instance
            }
        }
    }

    abstract fun photoDao() : PhotoDao
}