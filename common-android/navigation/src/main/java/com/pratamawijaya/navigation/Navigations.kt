package com.pratamawijaya.navigation

import android.content.Context
import android.content.Intent
import com.github.ajalt.timberkt.d

object Navigations {

    fun openOnboarding(context: Context): Intent {
        d { "open onboarding ${context.packageName}" }
        return internalIntent(context, "navigations.onboarding.open")
    }

    fun openHomepage(context: Context): Intent {
        d { "open homepage ${context.packageName}" }
        return internalIntent(context, "navigations.homepage.open")
    }

    fun openNewsApiList(context: Context): Intent {
        return internalIntent(context, "navigations.newsapi.open")
    }

    fun openOpenDotaApi(context: Context): Intent {
        return internalIntent(context, "navigations.opendota.open")
    }

    private fun internalIntent(context: Context, action: String) = Intent(action).setPackage(context.packageName)
}
