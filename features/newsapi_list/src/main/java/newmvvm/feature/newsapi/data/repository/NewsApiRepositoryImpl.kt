package newmvvm.feature.newsapi.data.repository

import newmvvm.feature.newsapi.domain.repository.NewsApiRepository
import newmvvm.feature.newsapi.data.services.NewsApiServices

class NewsApiRepositoryImpl(val newsApi: NewsApiServices) : NewsApiRepository {
    override fun topHeadlines(country: String, category: String, pageSize: Int, page: Int) {

    }

    override fun everything(query: String, sortBy: String) {
    }
}