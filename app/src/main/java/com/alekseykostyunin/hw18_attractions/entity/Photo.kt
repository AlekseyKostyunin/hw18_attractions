package com.alekseykostyunin.hw18_attractions.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class Photo(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "uri")
    val uri: String,

    @ColumnInfo(name = "date")
    val date: String
)
