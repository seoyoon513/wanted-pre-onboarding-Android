package com.syoon.news.app.database

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface SavedNewsDao {

    @Query("select * from saved_news")
    suspend fun getAll(): List<SavedNews>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(savedNews: SavedNews)

    @Delete
    suspend fun delete(savedNews: SavedNews)

}