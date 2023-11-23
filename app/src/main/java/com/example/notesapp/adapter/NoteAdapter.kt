package com.example.notesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentAddNoteBinding
import com.example.notesapp.databinding.ItemNoteBinding
import com.example.notesapp.model.NoteData

class NoteAdapter(var noteList: ArrayList<NoteData>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val itemList = noteList[position]
        holder.bind(itemList)
    }

    override fun getItemCount() = noteList.size

    class NoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: NoteData){
            binding.nameTextView.text = note.noteName
            binding.descriptionTextView.text = note.noteDescription
        }

    }
}

