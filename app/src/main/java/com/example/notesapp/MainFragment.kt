package com.example.notesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.adapter.NoteAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.notesapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null

    private val viewModel: NoteViewModel by viewModels()

    private var noteAdapter = NoteAdapter(ArrayList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val noteList = viewModel.noteList.value
        if (noteList != null) {
            noteAdapter = NoteAdapter(noteList)
            binding?.recyclerView?.adapter = noteAdapter
        } else {
            Toast.makeText(context, "Заметки еще не добавлены", Toast.LENGTH_SHORT).show()
        }
        binding?.recyclerView?.layoutManager = LinearLayoutManager(context)

        binding?.button?.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AddNoteFragment())
                .addToBackStack(null)
                .commit()
        }

        viewModel.noteList.observe(viewLifecycleOwner) { newList ->
            noteAdapter.noteList = newList ?: ArrayList()
            noteAdapter.notifyDataSetChanged()
        }
    }
}
