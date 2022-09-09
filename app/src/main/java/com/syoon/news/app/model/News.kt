package com.syoon.news.app.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val author: String?,
    val title: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
): Parcelable

@Parcelize
data class TopNewsDto(
    val articles: List<News>
): Parcelable

