package com.pratamawijaya.hackernewslist

import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
            listOf(
                    repositoryModule,
                    networkModule
            )
    )
}

val repositoryModule: Module = module {
}

val networkModule: Module = module {
}