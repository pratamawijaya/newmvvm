package newmvvm.feature.newsapi.domain.usecase

import androidx.lifecycle.LiveData
import newmvvm.feature.newsapi.domain.model.Article
import newmvvm.feature.newsapi.domain.repository.NewsApiRepository

class GetNewsListUseCase(private val newsApiRepository: NewsApiRepository) {
    suspend fun getTopNewsByCountry(country: String,
                                    category: String): LiveData<List<Article>> {
        return newsApiRepository.topHeadlines(country, category)
    }
}