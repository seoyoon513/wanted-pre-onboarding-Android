package com.syoon.news.app.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface SavedNewsDao {

    @Query("SELECT * FROM saved_news")
    fun getAll(): List<SavedNews>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(savedNews: SavedNews)

    @Delete
    suspend fun delete(savedNews: SavedNews)

}