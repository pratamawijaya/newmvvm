package com.pratamawijaya.navigation

import android.content.Context
import android.content.Intent

object Navigations {

    fun openOnboarding(context: Context): Intent {
        return internalIntent(context, "com.pratamawijaya.onboarding.open")
    }

    private fun internalIntent(context: Context, action: String) = Intent(action).setPackage(context.packageName)
}