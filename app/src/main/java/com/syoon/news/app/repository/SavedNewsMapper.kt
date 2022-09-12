package com.syoon.news.app.repository

import com.syoon.news.app.database.SavedNews
import com.syoon.news.app.model.News

object SavedNewsMapper {

    fun savedToNews(savedNews: SavedNews) =
        News(
            title = savedNews.title,
            author = savedNews.author,
            urlToImage = savedNews.urlToImage,
            publishedAt = savedNews.publishedAt,
            content = savedNews.content
        )

}