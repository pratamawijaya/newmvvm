package com.pratamawijaya.hackernewslist

import com.pratamawijaya.hackernewslist.data.HackerNewsApi
import newsapi.common.network.createNetworkClient
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

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
    single { hackerNewsApi }
}

private val retrofit: Retrofit = createNetworkClient("https://hacker-news.firebaseio.com/v0/", BuildConfig.DEBUG)
private val hackerNewsApi: HackerNewsApi = retrofit.create(HackerNewsApi::class.java)