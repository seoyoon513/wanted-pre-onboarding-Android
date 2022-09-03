package com.syoon.news.app.model

data class News(
    val author: String,
    val title: String,
    val description: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)

data class TopNewsDto(
    val articles: List<News>
)

