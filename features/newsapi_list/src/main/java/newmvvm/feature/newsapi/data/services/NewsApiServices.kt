package newmvvm.feature.newsapi.data.services

import newmvvm.feature.newsapi.data.remote.model.response.TopHeadlinesResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface NewsApiServices {
    @GET("top-headlines")
    suspend fun topHeadlines(@Query("country") country: String, @Query("category") category: String): TopHeadlinesResponse
}