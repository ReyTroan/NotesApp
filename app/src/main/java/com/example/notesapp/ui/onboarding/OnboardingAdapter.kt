package com.example.notesapp.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class OnboardingAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val list = arrayListOf(
        OnbordingStepFragment.getFragment(STEP_1),
        OnbordingStepFragment.getFragment(STEP_2),
        OnbordingStepFragment.getFragment(STEP_3),
    )
    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Fragment = list[position]
}