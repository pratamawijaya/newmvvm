package com.pratamawijaya.navigation

import android.content.Context
import android.content.Intent
import com.github.ajalt.timberkt.d

object Navigations {

    fun openOnboarding(context: Context): Intent {
        d { "open onboarding ${context.packageName}" }
        return internalIntent(context, "com.pratamawijaya.newsapi.onboarding.open")
    }

    fun openHomepage(context: Context): Intent {
        d { "open homepage ${context.packageName}" }
        return internalIntent(context, "com.pratamawijaya.homepage.open")
    }

    fun openHackerNewsList(context: Context): Intent {
        return internalIntent(context, "com.pratamawijaya.hackernewslist.open")
    }

    private fun internalIntent(context: Context, action: String) = Intent(action).setPackage(context.packageName)
}