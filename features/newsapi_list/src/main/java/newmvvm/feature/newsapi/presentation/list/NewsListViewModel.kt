package newmvvm.feature.newsapi.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import kotlinx.coroutines.launch
import newmvvm.feature.newsapi.domain.model.Article
import newmvvm.feature.newsapi.domain.usecase.GetNewsListUseCase

sealed class NewsListState
data class ArticlesLoaded(val list: List<Article>) : NewsListState()
object LoadingState : NewsListState()
data class ErrorState(val msg: String) : NewsListState()

internal class NewsListViewModel(private val getNewsListUseCase: GetNewsListUseCase) : ViewModel() {

    var newsListState = MutableLiveData<NewsListState>()

    fun getData() {
        viewModelScope.launch {
            getNewsListUseCase.getSomeData().also {
                d { "get data value ${it.value?.size}" }
            }
        }
    }

    fun topHeadlines() {
        d { "newslistmodel running topheadlines viewmodel" }

        newsListState.postValue(LoadingState)

        viewModelScope.launch {
            try {
                getNewsListUseCase.getTopNewsByCountry(country = "us", category = "technology").also {
                    if (it.isNotEmpty()) {
                        newsListState.postValue(ArticlesLoaded(it))
                    } else {
                        d { "article is empty" }
                        newsListState.postValue(ErrorState("Article Empty"))
                    }
                }
            } catch (ex: Exception) {
                e { "error ${ex.localizedMessage}" }
                newsListState.postValue(ErrorState("Error"))
            }
        }
    }
}