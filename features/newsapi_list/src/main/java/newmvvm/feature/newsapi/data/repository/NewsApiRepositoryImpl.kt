package newmvvm.feature.newsapi.data.repository

import androidx.lifecycle.liveData
import newmvvm.feature.newsapi.data.remote.model.mapper.ArticleMapper
import newmvvm.feature.newsapi.data.services.NewsApiServices
import newmvvm.feature.newsapi.domain.model.Article
import newmvvm.feature.newsapi.domain.repository.NewsApiRepository

internal class NewsApiRepositoryImpl(val newsApi: NewsApiServices,
                                     val articleMapper: ArticleMapper) : NewsApiRepository {

    override suspend fun topHeadlines(country: String, category: String, pageSize: Int, page: Int): List<Article> {
        val articlesModel = newsApi.topHeadlines(country, category)
        return articleMapper.mapToListDomain(articlesModel.articles)
    }

    override fun getData() = liveData {
        val articlesModel = newsApi.topHeadlines("us", "technology")
        val articlesDomain = articleMapper.mapToListDomain(articlesModel.articles)
        emit(articlesDomain)
    }

    override fun everything(query: String, sortBy: String) = liveData<List<Article>> {

    }
}