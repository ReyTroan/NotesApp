package com.example.notesapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notesapp.MainActivity
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentLoginBinding
import com.example.notesapp.ui.notelist.NoteListFragment

class LoginFragment: Fragment() {

    private var binding : FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.enterLogin?.setOnClickListener{
            (activity as MainActivity).binding?.buttonToFragment?.visibility = View.VISIBLE
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, NoteListFragment())
                .commit()
        }
    }


}