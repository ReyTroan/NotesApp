package com.example.notesapp.ui.notelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.databinding.FragmentNotelistBinding

class NoteListFragment : Fragment() {

    private var binding: FragmentNotelistBinding? = null

    private val viewModel: NoteListViewModel by activityViewModels()

    private val noteAdapter by lazy {
        NoteListAdapter(viewModel.noteList.value ?: ArrayList())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotelistBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.recyclerView?.adapter = noteAdapter
        binding?.recyclerView?.layoutManager = LinearLayoutManager(context)

        viewModel.noteList.observe(viewLifecycleOwner) { newList ->
            (newList ?: ArrayList()).also { noteAdapter.noteList = it }
            noteAdapter.notifyDataSetChanged()
        }
    }

}
