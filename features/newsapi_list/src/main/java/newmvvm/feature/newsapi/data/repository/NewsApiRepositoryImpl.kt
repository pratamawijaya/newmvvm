package newmvvm.feature.newsapi.data.repository

import androidx.lifecycle.liveData
import newmvvm.feature.newsapi.data.model.mapper.ArticleMapper
import newmvvm.feature.newsapi.domain.repository.NewsApiRepository
import newmvvm.feature.newsapi.data.services.NewsApiServices
import newmvvm.feature.newsapi.domain.model.Article

class NewsApiRepositoryImpl(val newsApi: NewsApiServices,
                            val articleMapper: ArticleMapper) : NewsApiRepository {

    override suspend fun topHeadlines(country: String, category: String,
                                      pageSize: Int, page: Int) = liveData {
        val articlesModel = newsApi.topHeadlines(country).await()
        emit(articleMapper.mapToListDomain(articlesModel.articles))
    }

    override fun everything(query: String, sortBy: String) = liveData<List<Article>> {

    }
}