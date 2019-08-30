package newmvvm.feature.newsapi.domain.repository

import kotlinx.coroutines.Deferred
import newmvvm.feature.newsapi.domain.model.Article


interface NewsApiRepository {
    suspend fun topHeadlines(country: String, category: String, pageSize: Int = 10, page: Int): Deferred<List<Article>>
    fun everything(query: String, sortBy: String = "popularity")
}