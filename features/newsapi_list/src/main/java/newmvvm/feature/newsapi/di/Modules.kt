package newmvvm.feature.newsapi.di

import androidx.room.Room
import newmvvm.feature.newsapi.data.local.ArticleDatabase
import newmvvm.feature.newsapi.data.local.mapper.ArticleRoomModelMapper
import newmvvm.feature.newsapi.data.remote.mapper.ArticleNetworkModelMapper
import newmvvm.feature.newsapi.data.remote.services.NewsApiInterceptor
import newmvvm.feature.newsapi.data.remote.services.NewsApiServices
import newmvvm.feature.newsapi.data.repository.NewsApiRepositoryImpl
import newmvvm.feature.newsapi.domain.repository.NewsApiRepository
import newmvvm.feature.newsapi.domain.usecase.GetNewsListUseCase
import newmvvm.feature.newsapi.presentation.list.NewsListViewModel
import newsapi.common.network.createOkHttpClient
import newsapi.common.network.createWebService
import newsapi.feature.newsapilist.BuildConfig
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
            listOf(
                    featureModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    mapperModule,
                    viewModelModule)
    )
}

val featureModule = module {
    single {
        Room.databaseBuilder(
                androidApplication(),
                ArticleDatabase::class.java,
                "newmvvm-articlesdb").build()
    }
    single { get<ArticleDatabase>().articleDao() }
}

val mapperModule = module {
    single { ArticleNetworkModelMapper() }
    single { ArticleRoomModelMapper() }
}

val repositoryModule = module {
    single { NewsApiRepositoryImpl(newsApi = get(), articleMapper = get()) as NewsApiRepository }
}

val networkModule = module {
    single { newsApiServices }
}

val useCaseModule = module {
    factory { GetNewsListUseCase(newsApiRepository = get()) }
}

val viewModelModule = module {
    viewModel { NewsListViewModel(getNewsListUseCase = get()) }
}

private val okHttpClient : OkHttpClient = createOkHttpClient(NewsApiInterceptor(),BuildConfig.DEBUG)
private val newsApiServices: NewsApiServices = createWebService(okHttpClient = okHttpClient, url = "https://newsapi.org/v2/")
