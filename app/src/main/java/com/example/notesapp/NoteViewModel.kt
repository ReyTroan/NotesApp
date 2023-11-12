package com.example.notesapp

import androidx.lifecycle.ViewModel
import com.example.notesapp.model.NoteData
import androidx.lifecycle.MutableLiveData

class NoteViewModel : ViewModel() {
    val noteList = MutableLiveData<ArrayList<NoteData>>().apply {
        value = ArrayList()
    }
}