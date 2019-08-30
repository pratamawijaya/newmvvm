package newmvvm.feature.newsapi.di

import newmvvm.feature.newsapi.data.repository.NewsApiRepositoryImpl
import newmvvm.feature.newsapi.domain.repository.NewsApiRepository
import newmvvm.feature.newsapi.services.NewsApiInterceptor
import newmvvm.feature.newsapi.services.NewsApiServices
import newsapi.common.network.createOkHttpClient
import newsapi.common.network.createWebService
import newsapi.feature.newsapilist.BuildConfig
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
            listOf(featureModule,
                    repositoryModule,
                    networkModule)
    )
}

val featureModule = module {

}

val repositoryModule = module {
    single { NewsApiRepositoryImpl(newsApi = get()) as NewsApiRepository }
}

val networkModule = module {
    single { NewsApiInterceptor() }
    single { createOkHttpClient(get(), BuildConfig.DEBUG) }
    single { createWebService<NewsApiServices>(okHttpClient = get(), url = "https://newsapi.org/v2/") }
}