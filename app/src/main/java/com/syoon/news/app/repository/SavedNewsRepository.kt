package com.syoon.news.app.repository

import android.app.Application
import com.syoon.news.app.database.AppDataBase
import com.syoon.news.app.database.SavedNewsDao
import com.syoon.news.app.database.SavedNews

class SavedNewsRepository {

    private val dao = AppDataBase.getDao()

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