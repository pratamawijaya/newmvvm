package newmvvm.feature.newsapi.data.services

import kotlinx.coroutines.*
import newmvvm.feature.newsapi.data.model.response.TopHeadlinesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiServices {
    @GET("top-headlines")
    fun topHeadlines(@Query("country") country: String): Deferred<TopHeadlinesResponse>
}