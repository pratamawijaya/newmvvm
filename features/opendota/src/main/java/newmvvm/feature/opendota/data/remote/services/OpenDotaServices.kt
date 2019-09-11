package newmvvm.feature.opendota.data.remote.services

import newmvvm.feature.opendota.data.remote.model.HeroesNetworkModel
import retrofit2.http.GET

interface OpenDotaServices {
    @GET("heroes")
    suspend fun heroes(): List<HeroesNetworkModel>
}