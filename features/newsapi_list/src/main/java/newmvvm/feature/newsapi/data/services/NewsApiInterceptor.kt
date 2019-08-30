package newmvvm.feature.newsapi.data.services

import okhttp3.Interceptor
import okhttp3.Response

class NewsApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request.apply {
            newBuilder()
                    .addHeader("X-Api-Key", "4b4df2ea3a154950852b6fda536cfb7f")
                    .build()
        }
        return chain.proceed(request)
    }
}