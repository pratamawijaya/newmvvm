package newsapi.common.network

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val TIMEOUT: Long = 60

fun createOkHttpClient(interceptor: Interceptor?, debug: Boolean = false): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    val clientBuilder = OkHttpClient.Builder()

    if (debug) {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(httpLoggingInterceptor)
    }

    interceptor?.let {
        clientBuilder.addInterceptor(interceptor)
    }

    return clientBuilder
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create()

    val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()
    return retrofit.create(T::class.java)
}
