package com.example.notesapp.ui.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.notesapp.model.NoteData
import com.example.notesapp.databinding.FragmentAddNoteBinding
import com.example.notesapp.ui.notelist.NoteListViewModel

class AddNoteFragment : Fragment() {

    private var binding: FragmentAddNoteBinding? = null

    private val viewModel: NoteListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.addButton?.setOnClickListener {
            val noteData = NoteData(binding?.noteName?.text.toString(), binding?.noteDescription?.text.toString())


            val list = arrayListOf<NoteData>()
            list.addAll(viewModel.noteList.value!!)
            list.add(noteData)
            viewModel.noteList.value = list


            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}