package newmvvm.feature.newsapi.domain.usecase

import androidx.lifecycle.LiveData
import com.github.ajalt.timberkt.d
import newmvvm.feature.newsapi.domain.model.Article
import newmvvm.feature.newsapi.domain.repository.NewsApiRepository

internal class GetNewsListUseCase(private val newsApiRepository: NewsApiRepository) {

    fun execute(country: String, category: String): LiveData<List<Article>> {
        return newsApiRepository.topHeadlines(country, category)
    }

    fun getTopNewsByCountry(
        country: String,
        category: String
    ): LiveData<List<Article>> {
        d { "get news list usecase" }
        return newsApiRepository.topHeadlines(country, category)
    }

    fun getSomeData(): LiveData<List<Article>> {
        return newsApiRepository.getData()
    }
}