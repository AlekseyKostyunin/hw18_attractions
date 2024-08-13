package com.alekseykostyunin.hw18_attractions.data

import androidx.room.Dao
import androidx.room.Query
import com.alekseykostyunin.hw18_attractions.entity.Photo
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDao {

    @Query("SELECT * FROM photos")
    fun getAllPhotos(): Flow<List<Photo>>

    @Query("INSERT INTO photos (uri, date) VALUES (:uri, :date)")
    suspend fun insertPhoto(uri: String, date: String)
}