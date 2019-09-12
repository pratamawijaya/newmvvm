package com.pratamawijaya.homepage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.ajalt.timberkt.d
import com.pratamawijaya.navigation.Navigations
import kotlinx.android.synthetic.main.activity_homepage.*

class HomepageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        d { "homepage" }
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Dashboard"

        btnOpenNews.setOnClickListener {
            d { "open news api clicked" }
            startActivity(Navigations.openNewsApiList(this))
        }

        btnOpenDota.setOnClickListener {
            startActivity(Navigations.openOpenDotaApi(this))
        }

        btnMarvelHeroes.setOnClickListener {
            startActivity(Navigations.openMarvelHeroes(this))
        }
    }
}
