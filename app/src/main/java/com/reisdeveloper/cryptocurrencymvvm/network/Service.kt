package com.reisdeveloper.cryptocurrencymvvm.network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://api.coinlayer.com/api/"
private const val ACCESS_KEY = "cf3b8dd2592d0e5a8326f727b7a4cc2f"

class Service {

    private val log = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    val client = OkHttpClient
        .Builder()
        .addInterceptor { chain ->

            val originalRequest = chain.request()
            val originalUrl = originalRequest.url
            val newUrl = originalUrl.newBuilder()
                .addQueryParameter("access_key", ACCESS_KEY)
                .build()

            val newRequest = originalRequest.newBuilder().url(newUrl).build()

            chain.proceed(
                newRequest
                    .newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .build()
            )
        }

        .addInterceptor(log)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()

    fun <API> createService(apiClass: Class<API>): API {
        return retrofit.create(apiClass)
    }

}