package com.example.notesapp.ui.notelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.ItemNoteBinding
import com.example.notesapp.model.NoteData

class NoteListAdapter(var noteList: ArrayList<NoteData>) :
    RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>() {

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

