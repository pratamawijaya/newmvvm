package com.pratamawijaya.hackernewslist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pratamawijaya.hackernewslist.R
import com.pratamawijaya.hackernewslist.injectFeature

class HackernewsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hackernews_list)
        // load all injection from koin
        injectFeature()
    }
}
