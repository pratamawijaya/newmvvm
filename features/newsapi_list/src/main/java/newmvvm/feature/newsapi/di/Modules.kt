package newmvvm.feature.newsapi.di

import newmvvm.feature.newsapi.data.repository.NewsApiRepositoryImpl
import newmvvm.feature.newsapi.domain.repository.NewsApiRepository
import newmvvm.feature.newsapi.data.services.NewsApiInterceptor
import newmvvm.feature.newsapi.data.services.NewsApiServices
import newmvvm.feature.newsapi.domain.usecase.GetNewsListUseCase
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
                    networkModule,
                    useCaseModule)
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

val useCaseModule = module {
    factory { GetNewsListUseCase(newsApiRepository = get()) }
}