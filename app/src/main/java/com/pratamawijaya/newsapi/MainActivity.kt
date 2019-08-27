package com.pratamawijaya.newsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pratamawijaya.navigation.Navigations

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Navigations.openOnboarding(this)
    }
}
