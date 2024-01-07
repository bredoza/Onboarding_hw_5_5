package com.example.onboarding_hw_5_5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.onboarding_hw_5_5.databinding.ActivityMainBinding
import com.example.onboarding_hw_5_5.ui.data.Pref

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val pref: Pref by lazy {
        Pref(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        if (!pref.isOnboardingHide()) {
            navController.navigate(R.id.fragment_onboarding)
        }
    }
}