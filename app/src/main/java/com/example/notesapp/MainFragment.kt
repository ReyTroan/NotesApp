package com.example.notesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.adapter.NoteAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.notesapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null

    private val viewModel: NoteViewModel by activityViewModels()

    private val noteAdapter by lazy {
        NoteAdapter(viewModel.noteList.value ?: ArrayList())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false).apply {
            recyclerView.adapter = noteAdapter
            recyclerView.layoutManager = LinearLayoutManager(context)
            buttonToFragment.setOnClickListener { navigateToAddNoteFragment() }
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.noteList.observe(viewLifecycleOwner) { newList ->
            (newList ?: ArrayList()).also { noteAdapter.noteList = it }
            noteAdapter.notifyDataSetChanged()
        }
    }

    private fun navigateToAddNoteFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, AddNoteFragment())
            .addToBackStack(null)
            .commit()
    }
}
