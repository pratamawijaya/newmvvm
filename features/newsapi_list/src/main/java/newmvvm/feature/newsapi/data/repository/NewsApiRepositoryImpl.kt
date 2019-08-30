package newmvvm.feature.newsapi.data.repository

import kotlinx.coroutines.Deferred
import newmvvm.feature.newsapi.domain.repository.NewsApiRepository
import newmvvm.feature.newsapi.data.services.NewsApiServices
import newmvvm.feature.newsapi.domain.model.Article

class NewsApiRepositoryImpl(val newsApi: NewsApiServices) : NewsApiRepository {

    override suspend fun topHeadlines(country: String, category: String, pageSize: Int, page: Int): Deferred<List<Article>> {
        val response = newsApi.topHeadlines(country).await()
//        return response.articles
    }

    override fun everything(query: String, sortBy: String) {
    }
}