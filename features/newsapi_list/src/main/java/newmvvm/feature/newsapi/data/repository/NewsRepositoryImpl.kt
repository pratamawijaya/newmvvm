package newmvvm.feature.newsapi.data.repository

import newmvvm.feature.newsapi.domain.repository.NewsApiRepository

class NewsRepositoryImpl : NewsApiRepository {
    override fun topHeadlines(country: String, category: String, pageSize: Int, page: Int) {

    }

    override fun everything(query: String, sortBy: String) {
    }
}