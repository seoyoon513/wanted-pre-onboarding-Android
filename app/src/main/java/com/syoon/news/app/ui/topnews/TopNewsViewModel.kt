package com.syoon.news.app.ui.topnews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syoon.news.app.model.News
import com.syoon.news.app.model.TopNewsDto
import com.syoon.news.app.repository.CategoryNewsRepository
import com.syoon.news.app.repository.TopNewsRepository
import com.syoon.news.app.ui.common.Event
import com.syoon.news.app.utils.Constant.Companion.API_KEY
import kotlinx.coroutines.launch

class TopNewsViewModel: ViewModel() {

    private val topNewsRepository = TopNewsRepository()
    private val categoryNewsRepository = CategoryNewsRepository()

    private val newsList = MutableLiveData<List<News>>()
    private val _openNewsDetailEvent = MutableLiveData<Event<News>>()

    val openNewsDetailEvent: LiveData<Event<News>> = _openNewsDetailEvent

    fun fetchCategoryNews(category: String): LiveData<List<News>> {
        viewModelScope.launch {
            newsList.postValue(categoryNewsRepository.getCategoryNews(API_KEY, category))
        }
        return newsList
    }

    fun fetchNewsList(): LiveData<List<News>> {
        viewModelScope.launch {
            newsList.postValue(topNewsRepository.getTopNews(API_KEY))
        }
        return newsList
    }

    fun openNewsDetail(news: News) {
        _openNewsDetailEvent.value = Event(news)
    }
}