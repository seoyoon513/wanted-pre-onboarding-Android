package com.syoon.news.app.repository

import com.syoon.news.app.model.News
import com.syoon.news.app.model.TopNewsDto
import com.syoon.news.app.network.NewsApiClient

class TopNewsRepository {

    suspend fun getTopNews(apiKey: String): TopNewsDto {
        return NewsApiClient.newsApi.getTopNews(apiKey)
    }
}