package com.syoon.news.app.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_news")
data class SavedNews(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val author: String,
    val title: String,
    val description: String,
    @ColumnInfo(name = "url_to_image")val urlToImage: String,
    @ColumnInfo(name = "published_at")val publishedAt: String,
    val content: String,
    @ColumnInfo(name = "is_saved_news")val isSavedNews: Boolean = true
)
