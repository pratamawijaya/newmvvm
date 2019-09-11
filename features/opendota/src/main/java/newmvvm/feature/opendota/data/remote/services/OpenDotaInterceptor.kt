package newmvvm.feature.opendota.data.remote.services

import okhttp3.Interceptor
import okhttp3.Response

class OpenDotaInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val newUrl = req.url.newBuilder()
                .addQueryParameter("api_key", "").build()
        req = req.newBuilder().url(newUrl).build()
        return chain.proceed(req)
    }

}