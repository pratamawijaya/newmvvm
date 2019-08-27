package newsapi.common.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createNetworkClient(baseUrl: String, debug: Boolean = false) = retrofitClient(baseUrl, httpClient(debug))

private fun httpClient(debug: Boolean): OkHttpClient {
    val httpLogging = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
    val clientBuilder = OkHttpClient.Builder()

    if (debug) {
        httpLogging.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(httpLogging)
    }

    return clientBuilder.build()
}

private fun retrofitClient(baseUrl: String, httpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()