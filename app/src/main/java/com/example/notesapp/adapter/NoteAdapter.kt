package com.example.notesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.model.NoteData

class NoteAdapter(var noteList: ArrayList<NoteData>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.nTitle)
        val subtitle = view.findViewById<TextView>(R.id.nSubTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val itemList = noteList[position]
        holder.title.text = itemList.noteName
        holder.subtitle.text = itemList.noteDescription
    }

    override fun getItemCount() = noteList.size
}

