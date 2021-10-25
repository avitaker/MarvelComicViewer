package com.avinashdavid.marvelcomicviewer.util

import com.avinashdavid.marvelcomicviewer.BuildConfig
import com.avinashdavid.marvelcomicviewer.api.apis.DocspublicApi
import com.avinashdavid.marvelcomicviewer.api.tools.GeneratedCodeConverters
import com.avinashdavid.marvelcomicviewer.makeMD5
import com.google.gson.GsonBuilder
import com.grapesnberries.curllogger.CurlLoggerInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit

val marvelApi by lazy {
    Retrofit.Builder()
        .baseUrl("http://gateway.marvel.com/")
        .client(createOkHttpClient())
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson()))
        .addConverterFactory(GeneratedCodeConverters.converterFactory())
        .build()
        .create(DocspublicApi::class.java)
}

private fun getHeaderInterceptor(): Interceptor {
    return object : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val request =
                chain.request().newBuilder()
                    .build()
            return chain.proceed(request)
        }
    }
}

private fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .apply {
            if(BuildConfig.DEBUG){
                this.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                this.readTimeout(240, TimeUnit.SECONDS)
                this.connectTimeout(240, TimeUnit.SECONDS)
                addInterceptor(CurlLoggerInterceptor())
            }
        }
        .addInterceptor(getHeaderInterceptor())
        .build()
}

private fun gson() = GsonBuilder().create()

data class ApiSignature(val timestamp: String = Date().time.toString()) {
    val apiKey = BuildConfig.MARVEL_PUBLIC_KEY
    val hash = makeMD5(timestamp + BuildConfig.MARVEL_PRIVATE_KEY + BuildConfig.MARVEL_PUBLIC_KEY)
}