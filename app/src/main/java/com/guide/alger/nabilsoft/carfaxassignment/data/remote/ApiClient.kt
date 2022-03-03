package com.guide.alger.nabilsoft.carfaxassignment.data.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.plugins.RxJavaPlugins
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val retrofit by lazy {
         val loginterceptor = HttpLoggingInterceptor().apply {level =  HttpLoggingInterceptor.Level.BODY }
        val client = OkHttpClient.Builder().apply { addInterceptor(loginterceptor) }.build()
        val retrofit=Retrofit.Builder().apply {
            baseUrl("https://carfax-for-consumers.firebaseio.com")
            addConverterFactory(GsonConverterFactory.create())
            client(client)
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        }.build()
            retrofit
    }
}