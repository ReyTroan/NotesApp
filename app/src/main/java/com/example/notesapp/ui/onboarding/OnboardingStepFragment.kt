package com.example.notesapp.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.notesapp.R
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
                    binding?.title?.text = "One device - multiple users"
                    binding?.imageView?.setImageResource(R.drawable.onboarding2)
                }
                STEP_2 -> {
                    binding?.title?.text = "All your thoughts in one app"
                    binding?.imageView?.setImageResource(R.drawable.onboarding3)

                }
                STEP_3 -> {
                    binding?.title?.text = "Minimalism and usability"
                    binding?.imageView?.setImageResource(R.drawable.onboarding1)

                }

                else -> {}
            }
        }
    }
    companion object {
        fun getFragment(step : Int): OnbordingStepFragment {
            return OnbordingStepFragment().apply {
                arguments = bundleOf(STEP_EXTRA to step)
            }
        }
    }

}