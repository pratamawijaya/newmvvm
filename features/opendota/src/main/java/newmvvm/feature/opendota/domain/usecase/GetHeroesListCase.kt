package newmvvm.feature.opendota.domain.usecase

import newmvvm.feature.opendota.domain.model.Heroes
import newmvvm.feature.opendota.domain.repository.OpenDotaRepository

internal class GetHeroesListCase(private val repository: OpenDotaRepository) {

    suspend fun getHeroesDota(): List<Heroes> {
        return repository.getHeroes()
    }
}