package com.example.notesapp

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.ui.addnote.AddNoteFragment
import com.example.notesapp.ui.login.LoginFragment
import com.example.notesapp.ui.notelist.NoteListFragment
import com.example.notesapp.ui.onboarding.OnboardingFragment

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        if (viewModel.getIsAppOpen()) {
            binding?.buttonToFragment?.setVisibility(View.GONE)
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, LoginFragment())
                .commit()
        } else {
            binding?.buttonToFragment?.setVisibility(View.GONE)
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, OnboardingFragment())
                .commit()
            viewModel.setAppOpen()
        }

        binding?.buttonToFragment?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.list -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, NoteListFragment())
                        .commit()
                    true
                }
                R.id.add -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, AddNoteFragment())
                        .commit()
                    true
                }
                R.id.profile -> {
                    true
                }
                else -> false
            }
        }

    }
}
