package newmvvm.feature.opendota.data.remote.model

data class HeroesNetworkModel(val id: Int? = 0,
                              val name: String? = "",
                              val localized_name: String? = "",
                              val primary_attr: String? = "",
                              val attack_type: String? = "",
                              val roles: List<String>
)