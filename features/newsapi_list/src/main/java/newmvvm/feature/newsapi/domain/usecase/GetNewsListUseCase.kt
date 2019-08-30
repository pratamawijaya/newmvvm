package newmvvm.feature.newsapi.domain.usecase

import newmvvm.feature.newsapi.domain.repository.NewsApiRepository

class GetNewsListUseCase(private val newsApiRepository: NewsApiRepository) {
    fun getTopNewsByCountry(country: String) {

    }
}