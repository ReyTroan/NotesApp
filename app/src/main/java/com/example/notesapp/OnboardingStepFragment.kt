package com.example.notesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.notesapp.databinding.FragmentOnboardingStepBinding

const val STEP_1 = 1
const val STEP_2 = 2
const val STEP_3 = 3

private const val STEP_EXTRA = "step"

class OnbordingStepFragment : Fragment() {

    private var binding: FragmentOnboardingStepBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingStepBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt(STEP_EXTRA)?.run {
            when (this) {
                STEP_1 -> {
                    binding?.title?.text = "Step1"
                }
                STEP_2 -> {
                    binding?.title?.text = "Step2"
                }
                STEP_3 -> {
                    binding?.title?.text = "Step3"
                }
            }
        }
    }
    companion object {
        fun getFragment(step : Int): OnbordingStepFragment{
            return OnbordingStepFragment().apply {
                arguments = bundleOf(STEP_EXTRA to step)
            }
        }
    }

}