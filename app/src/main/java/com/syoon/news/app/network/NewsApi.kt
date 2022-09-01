package com.syoon.news.app.network

import com.syoon.news.app.model.News
import com.syoon.news.app.model.TopNewsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    //https://newsapi.org/v2/top-headlines?country=us&apiKey=

    @GET("top-headlines?country=us")
    suspend fun getTopNews(
        @Query("apiKey") apikey: String
    ): TopNewsDto

}