package com.example.onboarding_hw_5_5.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.onboarding_hw_5_5.R
import com.example.onboarding_hw_5_5.databinding.ItemOnboardingBinding
import com.example.onboarding_hw_5_5.module.Onboarding

class OnboardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    private val list = arrayListOf(
        Onboarding(R.raw.lottie_json, "1", "1"),
        Onboarding(R.raw.lottie_json_2, "2", "2"),
        Onboarding(R.raw.lottie_json, "3", "3"),
        Onboarding(R.raw.lottie_json_2, "4", "4")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        return OnboardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    inner class OnboardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {
        fun bind(boarding: Onboarding, position: Int) {
            with(binding) {
                topText.text = boarding.title
                bottomText.text = boarding.description
                btnStart.isVisible = position == list.lastIndex
                btnSkip.isVisible = position != list.lastIndex
                btnStart.setOnClickListener { onClick() }
                btnSkip.setOnClickListener { onClick() }
            }
            showLottieAnimation(boarding.lottieAnimationView)
        }

        private fun showLottieAnimation(animationRes: Int) {
            binding.ivOnboard.setAnimation(animationRes)
            binding.ivOnboard.playAnimation()
        }
    }
}