package com.example.onboarding_hw_5_5.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onboarding_hw_5_5.ui.data.Pref
import com.example.onboarding_hw_5_5.R
import com.example.onboarding_hw_5_5.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {

    private val adapter = OnboardingAdapter(this::onClick)
    private lateinit var binding: FragmentOnboardingBinding

    private val pref: Pref by lazy {
        Pref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        binding.viewPager.adapter = adapter
        return binding.root
    }

    private fun onClick() {
        pref.onBoardingHide()
        findNavController().navigate(R.id.fragment_main)
    }
}