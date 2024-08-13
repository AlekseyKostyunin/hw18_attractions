package com.alekseykostyunin.hw18_attractions.domain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alekseykostyunin.hw18_attractions.data.AppDatabase
import com.alekseykostyunin.hw18_attractions.data.PhotoDao
import com.alekseykostyunin.hw18_attractions.entity.Photo
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch

class ListPhotoViewModel(application: Application) : AndroidViewModel(application){

    private val db = AppDatabase.getInstance(application)

    val allPhotos = db.photoDao().getAllPhotos()
        .shareIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            replay = 1
        )

}