package com.syoon.news.app.repository

import com.syoon.news.app.model.News
import com.syoon.news.app.network.NewsApiClient

class TopNewsRepository {

    suspend fun getTopNews(apiKey: String): List<News> {
        return NewsApiClient.newsApi.getTopNews(apiKey).articles
    }

    suspend fun getCategoryNews(apiKey: String, category: String): List<News> {
        return NewsApiClient.newsApi.getCategoryNews(apiKey, category).articles
    }
}