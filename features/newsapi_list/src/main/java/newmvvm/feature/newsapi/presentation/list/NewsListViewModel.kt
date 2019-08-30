package newmvvm.feature.newsapi.presentation.list

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import newmvvm.feature.newsapi.domain.model.Article
import newmvvm.feature.newsapi.domain.usecase.GetNewsListUseCase

class NewsListViewModel(private val useCase: GetNewsListUseCase) : ViewModel() {

    private var _articles = MutableLiveData<List<Article>>()

    val articles: LiveData<List<Article>>
        get() = _articles

    fun topHeadlines() {
        Log.d("tag", "running topheadlines viewmodel")
        viewModelScope.launch {
            try {
                val articles = useCase.getTopNewsByCountry(country = "indo", category = "Technology")
                Log.d("tag", "size ${articles.value?.size}")
                articles.value?.map {
                    Log.d("debug", "data ${it.title}")
                }
            } catch (ex: Exception) {
                Log.e("error", "error ${ex.localizedMessage}")
            }
        }
    }

}