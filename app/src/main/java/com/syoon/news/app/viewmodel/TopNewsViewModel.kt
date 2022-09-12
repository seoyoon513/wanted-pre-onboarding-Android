package com.syoon.news.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syoon.news.app.model.News
import com.syoon.news.app.repository.TopNewsRepository
import com.syoon.news.app.utils.Constant.Companion.API_KEY
import kotlinx.coroutines.launch

class TopNewsViewModel: ViewModel() {

    private val topNewsRepository = TopNewsRepository()

    private val newsList = MutableLiveData<List<News>>()


    fun fetchCategoryNews(category: String): LiveData<List<News>> {
        viewModelScope.launch {
            newsList.postValue(topNewsRepository.getCategoryNews(API_KEY, category))
        }
        return newsList
    }

    fun fetchNewsList(): LiveData<List<News>> {
        viewModelScope.launch {
            newsList.postValue(topNewsRepository.getTopNews(API_KEY))
        }
        return newsList
    }
}