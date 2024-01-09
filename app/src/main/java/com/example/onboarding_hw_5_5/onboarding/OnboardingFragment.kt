package com.example.onboarding_hw_5_5.onboarding

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onboarding_hw_5_5.R
import com.example.onboarding_hw_5_5.databinding.FragmentOnboardingBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnboardingFragment : Fragment() {

    private val adapter = OnboardingAdapter(this::onClick)
    private lateinit var binding: FragmentOnboardingBinding

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        binding.viewPager.adapter = adapter
        return binding.root
    }

    private fun onClick() {
        findNavController().navigate(R.id.fragment_main)
        Toast.makeText(requireContext(), "Congratulations", Toast.LENGTH_SHORT).show()
        sharedPreferences.edit().putBoolean("onboardingHided", false).apply()
    }
}