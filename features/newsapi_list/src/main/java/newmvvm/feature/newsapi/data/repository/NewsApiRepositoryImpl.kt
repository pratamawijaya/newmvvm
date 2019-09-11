package newmvvm.feature.newsapi.data.repository

import androidx.lifecycle.liveData
import newmvvm.feature.newsapi.data.remote.mapper.ArticleNetworkModelMapper
import newmvvm.feature.newsapi.data.services.NewsApiServices
import newmvvm.feature.newsapi.domain.model.Article
import newmvvm.feature.newsapi.domain.repository.NewsApiRepository

internal class NewsApiRepositoryImpl(val newsApi: NewsApiServices,
                                     val articleMapper: ArticleNetworkModelMapper) : NewsApiRepository {

    override suspend fun topHeadlines(country: String, category: String, pageSize: Int, page: Int): List<Article> {
        val articlesModel = newsApi.topHeadlines(country, category)
        return articleMapper.mapToList(articlesModel.articles)
    }

    override fun getData() = liveData {
        val articlesModel = newsApi.topHeadlines("us", "technology")
        val articlesDomain = articleMapper.mapToList(articlesModel.articles)
        emit(articlesDomain)
    }

    override fun everything(query: String, sortBy: String) = liveData<List<Article>> {

    }
}