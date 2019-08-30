package newmvvm.feature.newsapi.domain.repository

import androidx.lifecycle.LiveData
import newmvvm.feature.newsapi.domain.model.Article


interface NewsApiRepository {
    suspend fun topHeadlines(country: String, category: String, pageSize: Int = 10, page: Int): LiveData<List<Article>>
    fun everything(query: String, sortBy: String = "popularity"): LiveData<List<Article>>
}