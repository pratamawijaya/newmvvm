package newmvvm.feature.opendota.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import kotlinx.coroutines.launch
import newmvvm.feature.opendota.domain.usecase.GetHeroesListCase

internal class HeroesListViewModel(private val useCase: GetHeroesListCase) : ViewModel() {

    fun getHeroes() {
        viewModelScope.launch {
            try {
                useCase.getHeroesDota().also {
                    if (it.isNotEmpty()) {
                        it.map {
                            d { "heroes ${it.name} ${it.img}" }
                        }
                    } else {
                        d { "data empty" }
                    }
                }
            } catch (ex: Exception) {
                e { "error ${ex.localizedMessage}" }
            }
        }
    }
}