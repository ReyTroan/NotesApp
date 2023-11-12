package com.example.notesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.notesapp.model.NoteData
import androidx.fragment.app.viewModels
import com.example.notesapp.databinding.FragmentAddNoteBinding

class AddNoteFragment : Fragment() {

    private var binding: FragmentAddNoteBinding? = null

    private val viewModel: NoteViewModel by viewModels()

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

            viewModel.noteList.value?.add(noteData)
            viewModel.noteList.value = viewModel.noteList.value

            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}