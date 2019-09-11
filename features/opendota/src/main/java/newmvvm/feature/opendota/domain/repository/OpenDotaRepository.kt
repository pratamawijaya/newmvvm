package newmvvm.feature.opendota.domain.repository

import newmvvm.feature.opendota.domain.model.Heroes

interface OpenDotaRepository {
    suspend fun getHeroes(): List<Heroes>
}