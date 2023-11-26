package com.example.notesapp.ui.notelist

import androidx.lifecycle.ViewModel
import com.example.notesapp.model.NoteData
import androidx.lifecycle.MutableLiveData

class NoteListViewModel : ViewModel() {
    val noteList = MutableLiveData<ArrayList<NoteData>>().apply {
        value = ArrayList()
    }
}