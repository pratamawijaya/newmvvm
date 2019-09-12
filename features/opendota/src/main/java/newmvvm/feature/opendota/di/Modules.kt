package newmvvm.feature.opendota.di

import newmvvm.feature.opendota.BuildConfig
import newmvvm.feature.opendota.data.remote.mapper.HeroesNetworkModelMapper
import newmvvm.feature.opendota.data.remote.services.OpenDotaInterceptor
import newmvvm.feature.opendota.data.remote.services.OpenDotaServices
import newmvvm.feature.opendota.data.repository.OpenDotaRepositoryImpl
import newmvvm.feature.opendota.domain.repository.OpenDotaRepository
import newmvvm.feature.opendota.domain.usecase.GetHeroesListCase
import newmvvm.feature.opendota.presentation.list.HeroesListViewModel
import newsapi.common.network.createOkHttpClient
import newsapi.common.network.createWebService
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(listOf(
            featureModule,
            networkModule,
            mapperModule,
            repositoryModule,
            useCaseModule,
            viewModelModule
    ))
}

val viewModelModule = module {
    viewModel { HeroesListViewModel(useCase = get()) }
}

val featureModule = module {
}

val mapperModule = module {
    single { HeroesNetworkModelMapper() }
}

val useCaseModule = module {
    factory { GetHeroesListCase(repository = get()) }
}

val repositoryModule = module {
    single { OpenDotaRepositoryImpl(services = get(), heroesMapper = get()) as OpenDotaRepository }
}

val networkModule = module {
    single { openDotaApi }
}

private val okHttpClient : OkHttpClient = createOkHttpClient(OpenDotaInterceptor(),BuildConfig.DEBUG)
private val openDotaApi: OpenDotaServices = createWebService(okHttpClient = okHttpClient, url = "https://api.opendota.com/api/")