package com.example.notesapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.notesapp.repository.SharedPreferencesRepository

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val sharedPreferencesRepository =
        SharedPreferencesRepository(application.applicationContext)

    fun getIsAppOpen() = sharedPreferencesRepository.isAppOpen()

    fun setAppOpen(){
        sharedPreferencesRepository.setAppOpen()
    }
}