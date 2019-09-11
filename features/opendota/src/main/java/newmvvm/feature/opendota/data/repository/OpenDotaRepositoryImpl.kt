package newmvvm.feature.opendota.data.repository

import newmvvm.feature.opendota.data.remote.mapper.HeroesNetworkModelMapper
import newmvvm.feature.opendota.data.remote.services.OpenDotaServices
import newmvvm.feature.opendota.domain.model.Heroes
import newmvvm.feature.opendota.domain.repository.OpenDotaRepository

class OpenDotaRepositoryImpl(
    val services: OpenDotaServices,
    val heroesMapper: HeroesNetworkModelMapper
) : OpenDotaRepository {

    override suspend fun getHeroes(): List<Heroes> {
        return services.heroes().map { heroesMapper.map(it) }
    }
}