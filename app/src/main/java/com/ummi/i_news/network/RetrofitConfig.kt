package com.ummi.i_news.network

import com.google.gson.GsonBuilder
import com.ummi.i_news.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//fungsi rebuild adalah mengaktifkan service project kalian

object RetrofitConfig {
    //buat akses portnya(itu langsung ke htttp login)
    val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder().addInterceptor(interceptor).retryOnConnectionFailure(true)
        .connectTimeout(30, TimeUnit.SECONDS).build()

    // untuk convert menjadi gson
    val gson = GsonBuilder().setLenient().create()

    //entry data
    //ngatur url yang mau dieksekusi
    val retrofit =
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(client)
            //buat nge convert ke dalam json
            .addConverterFactory(
                GsonConverterFactory.create(
                    gson
                )
            ).build()

    // Funcation untuk meyambung end point dari class Api service
    fun getInstance(): ApiService = retrofit.create(ApiService::class.java)

}