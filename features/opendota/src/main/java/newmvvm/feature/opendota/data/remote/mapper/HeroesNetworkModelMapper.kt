package newmvvm.feature.opendota.data.remote.mapper

import newmvvm.common.core.Mapper
import newmvvm.feature.opendota.data.remote.model.HeroesNetworkModel
import newmvvm.feature.opendota.domain.model.Heroes

class HeroesNetworkModelMapper : Mapper<HeroesNetworkModel, Heroes> {

    override fun map(from: HeroesNetworkModel): Heroes {
        return Heroes(
                id = from.id ?: 0,
                name = from.localized_name ?: "",
                img = getImageHeroesUrl(from.name ?: "")
        )
    }

    private fun getImageHeroesUrl(name: String): String {
        // sample name -> npc_dota_hero_ember_spirit
        // sample name -> npc_dota_hero_terrorblade
        val cleanName = name.replace("npc_dota_hero_", "")
        return "http://cdn.dota2.com/apps/dota2/images/heroes/${cleanName}_full.png"
    }
}