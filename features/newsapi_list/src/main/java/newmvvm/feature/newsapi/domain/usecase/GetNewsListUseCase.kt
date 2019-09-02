package newmvvm.feature.newsapi.domain.usecase

import com.github.ajalt.timberkt.d
import newmvvm.feature.newsapi.domain.model.Article
import newmvvm.feature.newsapi.domain.repository.NewsApiRepository

internal class GetNewsListUseCase(private val newsApiRepository: NewsApiRepository) {
    suspend fun getTopNewsByCountry(country: String,
                                    category: String): List<Article> {
        d { "get news list usecase" }
        return newsApiRepository.topHeadlines(country, category)
    }
}