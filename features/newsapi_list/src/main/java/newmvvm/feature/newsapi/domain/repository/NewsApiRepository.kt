package newmvvm.feature.newsapi.domain.repository

interface NewsApiRepository {
    fun topHeadlines(country: String, category: String, pageSize: Int = 10, page: Int)
    fun everything(query: String, sortBy: String = "popularity" )
}