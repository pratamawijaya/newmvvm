package com.pratamawijaya.newsapi

import android.app.Application
import com.pratamawijaya.newsapi.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@MainApp)
            modules(listOf(appModule))
        }

    }
}