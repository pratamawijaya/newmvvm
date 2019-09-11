package com.pratamawijaya.newsapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.ajalt.timberkt.d
import com.pratamawijaya.navigation.Navigations

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        d { "main activity" }

        startActivity(Navigations.openHomepage(this))
    }
}
