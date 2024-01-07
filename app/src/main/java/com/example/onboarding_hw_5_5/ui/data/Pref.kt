package com.example.onboarding_hw_5_5.ui.data

import android.content.Context

class Pref(context: Context) {

    private val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun isOnboardingHide(): Boolean {
        return pref.getBoolean(HIDE_KEY, false)
    }

    fun onBoardingHide() {
        pref.edit().putBoolean(HIDE_KEY, true).apply()
    }

    companion object {
        const val PREF_NAME = "pref_name"
        const val HIDE_KEY = "hide_key"
    }
}