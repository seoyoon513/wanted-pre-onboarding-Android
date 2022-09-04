package com.syoon.news.app.repository

import com.syoon.news.app.database.SavedNewsDao
import com.syoon.news.app.model.News
import com.syoon.news.app.model.SavedNews
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SavedNewsRepository(private val dao: SavedNewsDao) {

    suspend fun getSavedNews(): List<SavedNews> {
        return dao.getAll()
    }

    suspend fun addNews(savedNews: SavedNews) {
        dao.insert(savedNews)
    }

    suspend fun deleteNews(savedNews: SavedNews) {
        dao.delete(savedNews)
    }

//    suspend fun addSavedNews(news: News) {
//        withContext(Dispatchers.IO) {
//            val savedNews = SavedNews(
//                author = news.author,
//                title = news.title,
//                description = news.description,
//                urlToImage = news.urlToImage,
//                publishedAt = news.publishedAt,
//                content = news.content
//            )
//        }
//    }
}