package com.alekseykostyunin.hw18_attractions.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.alekseykostyunin.hw18_attractions.data.AppDatabase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn

class ListPhotoViewModel(application: Application) : AndroidViewModel(application){

    private val db = AppDatabase.getInstance(application)

    val allPhotos = db.photoDao().getAllPhotos()
        .shareIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            replay = 1
        )

}