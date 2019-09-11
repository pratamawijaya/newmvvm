package newmvvm.feature.opendota.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import kotlinx.coroutines.launch
import newmvvm.feature.opendota.domain.model.Heroes
import newmvvm.feature.opendota.domain.usecase.GetHeroesListCase

sealed class HeroesListState

data class HeroesLoaded(val heroes: List<Heroes>) : HeroesListState()

internal class HeroesListViewModel(private val useCase: GetHeroesListCase) : ViewModel() {

    var heroesListState = MutableLiveData<HeroesListState>()

    fun getHeroes() {
        viewModelScope.launch {
            try {
                useCase.getHeroesDota().also {
                    if (it.isNotEmpty()) {
                        heroesListState.postValue(HeroesLoaded(it))
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