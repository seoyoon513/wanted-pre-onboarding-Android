package com.syoon.news.app.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.syoon.news.app.model.SavedNews

@Dao
interface SavedNewsDao {

    @Query("select * from saved_news")
    suspend fun getAll(): List<SavedNews>

    @Insert(onConflict = REPLACE)
    suspend fun insert(savedNews: SavedNews)

    @Delete
    suspend fun delete(savedNews: SavedNews)

}