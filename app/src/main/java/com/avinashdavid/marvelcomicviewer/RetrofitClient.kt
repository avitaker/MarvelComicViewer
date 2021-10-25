package com.avinashdavid.marvelcomicviewer.api

import android.util.Base64
import com.avinashdavid.marvelcomicviewer.BuildConfig
import com.avinashdavid.marvelcomicviewer.api.apis.DocspublicApi
import com.avinashdavid.marvelcomicviewer.api.tools.GeneratedCodeConverters
import com.avinashdavid.marvelcomicviewer.api.tools.WrapperConverterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.io.IOException
import java.util.concurrent.TimeUnit

val marvelApi by lazy {
    Retrofit.Builder()
        .baseUrl("http://gateway.marvel.com/")
        .client(createOkHttpClient())
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
                    .header("Accept","*/*")
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
            }
        }
        .addInterceptor(getHeaderInterceptor())
        .build()
}