package com.example.onboarding_hw_5_5.ui.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.onboarding_hw_5_5.ui.model.Onboarding
import com.example.onboarding_hw_5_5.databinding.ItemOnboardingBinding

class OnboardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    private val list = arrayListOf(
        Onboarding("", "1", "1"),
        Onboarding("", "2", "2"),
        Onboarding("", "3", "3"),
        Onboarding("", "4", "4")
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
            binding.topText.text = boarding.title
            binding.bottomText.text = boarding.description
            binding.btnStart.isVisible = position == list.lastIndex
            binding.btnSkip.isVisible = position != list.lastIndex
            binding.btnStart.setOnClickListener { onClick() }
            binding.btnSkip.setOnClickListener { onClick() }
        }
    }
}