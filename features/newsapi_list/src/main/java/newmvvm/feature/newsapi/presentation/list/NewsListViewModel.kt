package newmvvm.feature.newsapi.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.github.ajalt.timberkt.d
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

    val currentHeadlines = liveData {
        emit(emptyList<Article>())
        emitSource(getNewsListUseCase.execute(country = "us", category = "technology"))
    }
}