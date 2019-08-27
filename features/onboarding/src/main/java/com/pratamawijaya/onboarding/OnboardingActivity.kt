package com.pratamawijaya.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.ajalt.timberkt.d

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        d { "activity onboarding" }
    }
}