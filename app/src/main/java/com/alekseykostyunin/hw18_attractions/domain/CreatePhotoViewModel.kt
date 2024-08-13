package com.alekseykostyunin.hw18_attractions.domain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.alekseykostyunin.hw18_attractions.data.AppDatabase
import kotlinx.coroutines.launch

class CreatePhotoViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)

    fun insertPhoto(uri: String, date: String) {
        viewModelScope.launch {
            db.photoDao().insertPhoto(uri, date)
        }
    }
}