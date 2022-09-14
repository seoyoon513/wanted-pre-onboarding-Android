package com.syoon.news.app.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.syoon.news.app.database.AppDataBase
import com.syoon.news.app.database.SavedNewsDao
import com.syoon.news.app.database.SavedNews
import com.syoon.news.app.model.News

class SavedNewsRepository(context: Context) {

    private val dao: SavedNewsDao = AppDataBase.getInstance(context).savedNewsDao()


    suspend fun addNews(savedNews: SavedNews) {
        dao.insert(savedNews)
    }

    suspend fun deleteNews(savedNews: SavedNews) {
        dao.delete(savedNews)
    }

    fun getAllSavedData(): List<SavedNews> {
        return dao.getAll()
    }

    fun getBookMark(title: String): Boolean {
        if(dao.getBookmark(title) != null) {
            return true
        }
        return false
    }

}