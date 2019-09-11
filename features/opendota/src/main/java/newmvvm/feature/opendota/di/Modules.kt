package newmvvm.feature.opendota.di

import newmvvm.feature.opendota.BuildConfig
import newmvvm.feature.opendota.data.remote.services.OpenDotaInterceptor
import newmvvm.feature.opendota.data.remote.services.OpenDotaServices
import newsapi.common.network.createOkHttpClient
import newsapi.common.network.createWebService
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(listOf(
            featureModule,
            networkModule
    ))
}

val featureModule = module {

}

val networkModule = module {
    single { createOkHttpClient(OpenDotaInterceptor(), BuildConfig.DEBUG) }
    single { createWebService<OpenDotaServices>(okHttpClient = get(), url = "https://api.opendota.com/api/") }
}