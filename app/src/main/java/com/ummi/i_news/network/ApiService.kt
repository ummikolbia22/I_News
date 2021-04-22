package com.ummi.i_news.network

import com.ummi.newsay.model.ResponseNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    fun getTopHeadlinesNews(
        @Query("country") country: String?,
        @Query("apiKey") apiKey: String?,
    ): Call<ResponseNews>
}