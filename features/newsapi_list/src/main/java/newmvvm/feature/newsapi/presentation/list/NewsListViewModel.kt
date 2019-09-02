package newmvvm.feature.newsapi.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import kotlinx.coroutines.launch
import newmvvm.feature.newsapi.domain.model.Article
import newmvvm.feature.newsapi.domain.usecase.GetNewsListUseCase

internal class NewsListViewModel(private val getNewsListUseCase: GetNewsListUseCase) : ViewModel() {

    private var _articles = MutableLiveData<List<Article>>()

    val articles: LiveData<List<Article>>
        get() = _articles

    fun topHeadlines() {
        d { "newslistmodel running topheadlines viewmodel" }
        viewModelScope.launch {
            try {
                getNewsListUseCase.getTopNewsByCountry(country = "us", category = "technology").also {
                    if (it.isNotEmpty()) {
                        it.map { article ->
                            d { "article ${article.title}" }
                        }
                    } else {
                        d { "article is empty" }
                    }
                }
            } catch (ex: Exception) {
                e { "error ${ex.localizedMessage}" }
            }
        }
    }
}